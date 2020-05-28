package com.dani.mongo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dani.mongo.domain.Post;
import com.dani.mongo.repository.PostRepository;
import com.dani.mongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired // vai instaciar o objeto automatico
	private PostRepository repo;

	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
}
