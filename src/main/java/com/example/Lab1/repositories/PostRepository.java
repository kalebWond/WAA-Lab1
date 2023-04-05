package com.example.Lab1.repositories;

import com.example.Lab1.domain.Post;

import java.util.List;

public interface PostRepository {
    public List<Post> findAll();

    public Post getById(int id);

    public void save(Post p);

    public void delete(int id);

    public void update(int id, Post p);

    public List<Post> findByAuthor(String author);
}
