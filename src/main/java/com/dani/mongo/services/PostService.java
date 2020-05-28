package com.dani.mongo.services;

import java.util.Date;
import java.util.List;
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
	
	public List<Post> findyByTitle(String text){
		return repo.searchTitle(text); //consulta com @query
		//return repo.findByTitleContainingIgnoreCase(text);  //consulta com query methods
	}
	
	public List<Post> fullSearch(String text, Date minDate, Date maxDate){
		maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000); //acrescentando um dia a data maxima
		return repo.fullSearch(text, minDate, maxDate);
	}
}
