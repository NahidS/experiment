package com.nseidi.experiment.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.nseidi.experiment.entity.Music;
import com.nseidi.experiment.repository.MusicRepository;

@RestController
@RequestMapping("/music")
public class MusicController {
   
   private final MusicRepository musicRepository;
   
   @Autowired
   public MusicController(MusicRepository musicRepository) {
      this.musicRepository = musicRepository;
   }
   
   @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, 
         produces = MediaType.APPLICATION_JSON_VALUE) 
   public ResponseEntity<Music> createMusic(
         @RequestBody Music music) {
      Music newMusic = musicRepository.save(music);
      return new ResponseEntity<>(newMusic, HttpStatus.OK);
   }
   
   @GetMapping(value = "/{musicId}", produces = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<Music> getMusic(@PathVariable String musicId) {
      Optional<Music> music = musicRepository.findById(musicId);
      return new ResponseEntity<>(music.get(), HttpStatus.OK);
   }
}
