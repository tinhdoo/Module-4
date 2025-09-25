package com.example.songapp.controller;

import com.example.songapp.dto.SongDto;
import com.example.songapp.model.Song;
import com.example.songapp.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/songs")
public class SongController {
    private final ISongService songService;

    public SongController(ISongService songService) {
        this.songService = songService;
    }

    @GetMapping
    public String getAllSongs(Model model){
        model.addAttribute("songs", songService.findAll());
        return "list";
    }

    @GetMapping("/create")
    public String createSong(Model model){
        model.addAttribute("songDto", new SongDto());
        return "create";
    }

    @PostMapping("/create")
    public String createSong(@Validated @ModelAttribute("songDto") SongDto songDto,
                                BindingResult bindingResult,
                                RedirectAttributes redirect,
                                Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("songs", songService.findAll());
            return "create";
        }


        Song song = new Song();
        BeanUtils.copyProperties(songDto, song);
        songService.save(song);
        redirect.addFlashAttribute("message", "Thêm mới thành công");
        return "redirect:/songs";
    }
    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable Integer id, Model model) {
        Optional<Song> songOptional = songService.findById(id);
        if (songOptional.isPresent()) {
            SongDto songDto = new SongDto();
            BeanUtils.copyProperties(songOptional.get(), songDto);
            model.addAttribute("songDto", songDto);
            return "update";
        }
        return "redirect:/songs";
    }


    @PostMapping("/update")
    public String updateSong(@Validated @ModelAttribute("songDto") SongDto songDto,
                             BindingResult bindingResult,
                             RedirectAttributes redirect) {
        if (bindingResult.hasErrors()) {
            return "update";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songDto, song);
        songService.save(song);
        redirect.addFlashAttribute("message", "Cập nhật thành công");
        return "redirect:/songs";
    }


}
