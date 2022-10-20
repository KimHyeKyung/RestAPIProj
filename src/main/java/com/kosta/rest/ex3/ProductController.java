package com.kosta.rest.ex3;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {

	@Autowired
	ProductDAO productDAO;
	
	@GetMapping("/productform")
	public ModelAndView productform() {
		ModelAndView mav = new ModelAndView("JsonTest3");
		try {
			List<ProductFamily> productFamily = productDAO.selectProductFamily();
			mav.addObject("productFamily", productFamily);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	
	@ResponseBody
	@GetMapping("/productList/{fid}")
	public ResponseEntity<List<Product>> productList(@PathVariable Integer fid) {
		try {
			List<Product> pList = productDAO.selectProduct(fid);
			return new ResponseEntity<List<Product>>(pList, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<List<Product>>((List<Product>)null, HttpStatus.BAD_REQUEST);
		}
	}
	
	
	
	
	
	
}
