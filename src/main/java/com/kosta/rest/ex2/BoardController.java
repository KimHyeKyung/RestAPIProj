package com.kosta.rest.ex2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoardController {

	static Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	ArticleDAO articleDAO;
	
	@PostMapping("/boards")
	public ResponseEntity<String> addArticle(@RequestBody Article article){
		try {
			articleDAO.insertArticle(article);
			return new ResponseEntity<String>("ADD_SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("ADD_FAILED", HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/boards/{id}")
	public ResponseEntity<Article> getArticle(@PathVariable Integer id) {
		try {
			Article article = articleDAO.selectArticle(id);
			return new ResponseEntity<Article>(article, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Article>((Article)(null), HttpStatus.BAD_REQUEST);
		}
	}
	
	//객체 자체를 넘길때는 @requestBody안써도 된다.
	//하지만 stringify로 넘기면 @requestBody써야한다.
	@PutMapping("/boards/{id}")
	public ResponseEntity<String> modifyArticle(@PathVariable Integer id, Article article){
		try {
			article.setId(id);
			articleDAO.updateArticle(article);
			return new ResponseEntity<String>("MODIFY_SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("MODIFY_FAILED", HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/boards/title/{id}")
	public ResponseEntity<String> modifyTitle(@PathVariable Integer id, @RequestParam("title") String title){
		try {
			articleDAO.updateTitle(id, title);
			return new ResponseEntity<String>("MODIFY_SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("MODIFY_FAILED", HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/boards/content/{id}")
	public ResponseEntity<String> modifyContent(@PathVariable Integer id, @RequestParam("content") String content){
		try {
			articleDAO.updateContent(id, content);
			return new ResponseEntity<String>("MODIFY_SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("MODIFY_FAILED", HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/boards/del/{id}")
	public ResponseEntity<String> deleteArticle(@PathVariable Integer id){
	try {
		articleDAO.deleteArticle(id);
		return new ResponseEntity<String>("DELETE_SUCCESS", HttpStatus.OK);
	} catch (Exception e) {
		e.printStackTrace();
		return new ResponseEntity<String>("DELETE_FAILED", HttpStatus.BAD_REQUEST);
	}
	
	
	}
	
	
	
}
