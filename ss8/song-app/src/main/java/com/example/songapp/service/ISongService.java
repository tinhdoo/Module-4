package com.example.songapp.service;

import com.example.songapp.model.Song;

import java.util.List;
import java.util.Optional;

public interface ISongService {
    List<Song> findAll();

    void save(Song song);

    Optional<Song> findById(Integer id);
}
