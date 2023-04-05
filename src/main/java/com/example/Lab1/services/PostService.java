package com.example.Lab1.services;

import com.example.Lab1.domain.Post;
import com.example.Lab1.domain.dto.PostDto;

import java.util.List;

public interface PostService {
    public List<PostDto> findAll();

    PostDto getById(int id);

    void save(PostDto p);

    void delete(int id);

    void update(int id, PostDto p);

    public List<PostDto> findByAuthor(String author);

    List<PostDto> findByAuthorV2(String author);
}
