package com.example.oxxo.controller;

import org.springframework.http.ResponseEntity;
import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.oxxo.service.BlogService;

import io.swagger.v3.oas.annotations.Operation;

import com.example.oxxo.entity.Blog;
import com.example.oxxo.model.request.CreateBlogRequest;
import com.example.oxxo.model.response.MessageResponse;

@RestController
@RequestMapping("/api/blog")
@CrossOrigin(origins = "*",maxAge = 3600)
public class BlogController {

    @Autowired
    private BlogService blogService;

    @GetMapping("/")
    @Operation(summary="Obtener toda la lista de blogs")
    public ResponseEntity<List<Blog>> getList(){
        List<Blog> list = blogService.getList();

        return ResponseEntity.ok(list);

    }

    @GetMapping("/{id}")
    @Operation(summary="Recuperar blog por ID")
    public ResponseEntity<Blog> getBlog(@PathVariable long id){
        
        Blog blog =blogService.getBlog(id);
        return ResponseEntity.ok(blog);

    }

    @GetMapping("/newest")
    @Operation(summary="Obtenga la última lista de blogs con cantidad = límite")
    public ResponseEntity<List<Blog>> getListNewest(@RequestParam int limit){
        List<Blog> list = blogService.getListNewest(limit);
        return ResponseEntity.ok(list);
    }


    @PostMapping("/create")
    @Operation(summary="Crear un nuevo blog")
    public ResponseEntity<Blog> create(@RequestBody CreateBlogRequest request){

        Blog blog = blogService.createBlog(request);

        return ResponseEntity.ok(blog);

    }

    @PutMapping("/update/{id}")
    @Operation(summary="Encuentra blog por id y actualízalo")
    public ResponseEntity<Blog> update(@PathVariable long id, @RequestBody CreateBlogRequest request){

        Blog blog = blogService.updateBlog(id, request);

        return ResponseEntity.ok(blog);

    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary="Eliminar blog por ID")
    public ResponseEntity<?> delete(@PathVariable long id){
        blogService.deleteBlog(id);
        return ResponseEntity.ok(new MessageResponse("¡Bloc Eliminado!"));
    }
    
}
