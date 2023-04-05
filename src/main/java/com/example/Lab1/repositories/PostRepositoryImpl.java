package com.example.Lab1.repositories;

import com.example.Lab1.domain.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PostRepositoryImpl implements PostRepository {

    private static List<Post> posts;
    private static int productId = 300;

    static {
        posts = new ArrayList<>();
        Post p1 = new Post(101, "First post", "This is the first post inserted", "John Doe");
        Post p2 = new Post(105, "Second post", "This is the second post inserted", "Jane Fox");
        posts.add(p1);
        posts.add(p2);
    }

    public List<Post> findAll() {
        return posts;
    }

    public void save(Post p) {
        p.setId(productId);
        productId++;
        posts.add(p);
    }

    @Override
    public void delete(int id) {
        var product = posts
                .stream()
                .filter(l -> l.getId() == id)
                .findFirst().get();
        posts.remove(product);
    }

    @Override
    public void update(int id, Post p) {
        Post toUpdate = getById(id);
        toUpdate.setContent(p.getContent());
        toUpdate.setTitle(p.getTitle());
        toUpdate.setAuthor(p.getAuthor());
        System.out.println(posts);
    }

    @Override
    public List<Post> findByAuthor(String author) {
        return posts
                .stream()
                .filter(l -> l.getAuthor().toLowerCase().equals(author.toLowerCase()))
                .collect(Collectors.toList());
    }


    public Post getById(int id) {
        return posts
                .stream()
                .filter(l -> l.getId() == id)
                .findFirst()
                .orElse(null);

    }
}
