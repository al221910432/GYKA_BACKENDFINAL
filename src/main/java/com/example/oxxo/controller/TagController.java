package com.example.oxxo.controller;

import java.util.List;

import com.example.oxxo.entity.Category;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.oxxo.entity.Tag;
import com.example.oxxo.model.response.MessageResponse;
import com.example.oxxo.service.TagService;

import io.swagger.v3.oas.annotations.Operation;

import com.example.oxxo.model.request.CreateTagRequest;

@RestController
@RequestMapping("/api/tag")
@CrossOrigin(origins = "*",maxAge = 3600)
public class TagController {

    @Autowired
    private TagService tagService;

    @GetMapping("/enabled")
    @Operation(summary="Obtener la lista de categorías activadas")
    public ResponseEntity<List<Tag>> getListEnabled(){
        List<Tag> tags = tagService.getListEnabled();
        return ResponseEntity.ok(tags);
    }
    @GetMapping("/")
    @Operation(summary="Obtener la lista de tags")
    public ResponseEntity<List<Tag>> getList(){
        
        List<Tag> list = tagService.getListTag();

        return ResponseEntity.ok(list);
    }

    @PostMapping("/create")
    @Operation(summary="Crear una nuevo tag")
    public ResponseEntity<Tag> createTag(@RequestBody CreateTagRequest request){
        Tag tag = tagService.createTag(request);
        return ResponseEntity.ok(tag);
    }

    @PutMapping("/update/{id}")
    @Operation(summary="Encuentra el tag por id y actualízala")
    public ResponseEntity<Tag> updateTag(@PathVariable long id,@RequestBody CreateTagRequest request){
        Tag tag = tagService.updateTag(id, request);

        return ResponseEntity.ok(tag);
    }
    @PutMapping("/enable/{id}")
    @Operation(summary="Habilitar etiqueta por id")
    public ResponseEntity<?> enabled(@PathVariable long id){
        tagService.enableTag(id);
        return ResponseEntity.ok(new MessageResponse("Enable tag success"));

    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary="Eliminar etiqueta por id")
    public ResponseEntity<?> deleteTag(@PathVariable long id){
        tagService.deleleTag(id);

        return ResponseEntity.ok(new MessageResponse("¡Tag Eliminado!"));

    }
    
}
