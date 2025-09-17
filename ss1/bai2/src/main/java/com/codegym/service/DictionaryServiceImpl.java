package com.codegym.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DictionaryServiceImpl implements IDictionaryService {
    static final private Map<String, String> listWords = new HashMap<>();

    static {
        listWords.put("hello", "Xin chào");
        listWords.put("goodbye", "Tạm biệt");
        listWords.put("good", "Giỏi");
    }

    @Override
    public String translate(String eng) {
        if (eng == null || eng.trim().isEmpty()) {
            return "Vui lòng nhập từ cần dịch!";
        }

        String key = eng.trim().toLowerCase();
        String result = listWords.get(key);

        if (result == null) {
            return "Không tìm thấy từ: " + eng;
        }

        return result;
    }
}
