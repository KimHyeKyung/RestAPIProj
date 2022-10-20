package com.kosta.rest.ex2;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ArticleDAO {

	void insertArticle(Article article) throws Exception;
	Article selectArticle(Integer id) throws Exception;
	List<Article> selectArticleList() throws Exception;
	void updateArticle(Article article) throws Exception;
	void deleteArticle(Integer id) throws Exception;
	
	//파라미터가 2개 이상일 경우 xml에 parameterType을 써줄필요가 없이 변수들을 #{}형태로 넣으면 된다.wow!
	void updateTitle(@Param("id") Integer id, @Param("title") String title) throws Exception;
	void updateContent(@Param("id") Integer id, @Param("content") String content)throws Exception;
	
}
