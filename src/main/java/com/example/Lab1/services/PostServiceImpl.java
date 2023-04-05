package com.example.Lab1.services;

import com.example.Lab1.domain.Post;
import com.example.Lab1.domain.dto.PostDto;
import com.example.Lab1.repositories.PostRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;

    private final ModelMapper modelMapper;

    @Autowired
    public PostServiceImpl(PostRepository postRepository, ModelMapper modelMapper) {
        this.postRepository = postRepository;
        this.modelMapper = modelMapper;
    }

    public List<PostDto> findAll() {
        return postRepository.findAll().stream().map(post -> modelMapper.map(post, PostDto.class))
                .collect(Collectors.toList());
    }

    public PostDto getById(int id) {
        return modelMapper.map(postRepository.getById(id), PostDto.class);
    }

    @Override
    public void save(PostDto p) {
        postRepository.save(modelMapper.map(p, Post.class));
    }

    @Override
    public void delete(int id) {
        postRepository.delete(id);
    }

    @Override
    public void update(int id, PostDto p) {
        postRepository.update(id, modelMapper.map(p, Post.class));
    }

    @Override
    public List<PostDto> findByAuthor(String author) {
        return postRepository.findByAuthor(author).stream().map(post -> modelMapper.map(post, PostDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<PostDto> findByAuthorV2(String author) {
        return postRepository.findByAuthor(author).stream().map(post -> modelMapper.map(post, PostDto.class))
                .collect(Collectors.toList());
    }
}
