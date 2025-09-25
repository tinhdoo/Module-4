package com.example.songapp.repository;

import com.example.songapp.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISongRepository extends JpaRepository<Song,Integer>{
}
