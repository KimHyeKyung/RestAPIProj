package com.kosta.rest.ex3;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ProductDAO {

	List<ProductFamily> selectProductFamily() throws Exception;
	List<Product> selectProduct(Integer fid) throws Exception;
}
