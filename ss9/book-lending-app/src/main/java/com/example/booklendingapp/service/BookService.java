package com.example.booklendingapp.service;

import com.example.booklendingapp.model.Book;
import com.example.booklendingapp.model.Borrow;
import com.example.booklendingapp.repository.IBookRepository;
import com.example.booklendingapp.repository.IBorrowRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookService implements IBookService {
    private final IBookRepository repository;
    private final IBorrowRepository borrowRepository;

    public BookService(IBookRepository repository, IBorrowRepository borrowRepository) {
        this.repository = repository;
        this.borrowRepository = borrowRepository;
    }

    @Override
    public List<Book> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Book> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public String borrowBook(Integer id) {
        Book book = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy sách!"));

        if (book.getQuantity() <= 0) {
            throw new RuntimeException("Sách đã hết, không thể mượn!");
        }

        book.setQuantity(book.getQuantity() - 1);
        repository.save(book);

        String code = String.format("%05d", new Random().nextInt(100000));

        Borrow borrow = new Borrow();
        borrow.setBook(book);
        borrow.setCode(code);
        borrowRepository.save(borrow);

        return code;
    }

    @Override
    public void returnBook(String code) {
        Borrow borrow = borrowRepository.findByCode(code)
                .orElseThrow(() -> new RuntimeException("Mã mượn sách không hợp lệ!"));

        if (borrow.isReturned()) {
            throw new RuntimeException("Sách đã được trả rồi!");
        }

        Book book = borrow.getBook();
        book.setQuantity(book.getQuantity() + 1);
        repository.save(book);

        borrow.setReturned(true);
        borrowRepository.save(borrow);
    }
}
