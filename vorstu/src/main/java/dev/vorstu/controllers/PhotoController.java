package dev.vorstu.controllers;

import dev.vorstu.dto.Photo;
import dev.vorstu.entity.PhotoEntity;
import dev.vorstu.repositories.PhotoRepository;
import dev.vorstu.service.PhotoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/photo")
@CrossOrigin(origins = "http://localhost:4200/")
@RequiredArgsConstructor
public class PhotoController {

    @Autowired
    private PhotoRepository photoRepository;
    private final PhotoService photoService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Photo createPhoto(@RequestBody Photo newPhoto) {
        return photoService.create(newPhoto);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PhotoEntity> getAllPhotos() {
        return photoRepository.findAll();
    }

    @GetMapping(value = "/photo/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public PhotoEntity getPhotoById(@PathVariable Long id) {
        return photoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Фото не найдено с ID: " + id));
    }
}
