package com.example.songapp.service;

import com.example.songapp.model.Song;
import com.example.songapp.repository.ISongRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongService implements ISongService {
    private final ISongRepository repository;

    public SongService(ISongRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Song> findAll() {
        return repository.findAll();
    }
    @Override

    public void save(Song song) {
        repository.save(song);
    }
    @Override
    public Optional<Song> findById(Integer id) {
        return repository.findById(id);
    }
}
