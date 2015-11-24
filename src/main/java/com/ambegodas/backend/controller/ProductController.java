/**
 * @autor pathmasri
 * Nov 22, 2015 5:30:50 PM
 */
package com.ambegodas.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ambegodas.backend.model.Product;
import com.ambegodas.backend.resource.ProductResource;
import com.ambegodas.backend.resource.asm.ProductResourceAsm;
import com.ambegodas.backend.service.ProductService;

@Controller
public class ProductController {
	
private ProductService productService;
	
	@Autowired
	public ProductController(ProductService productService){
		this.productService = productService;
	}
	
	public ProductController(){
	}
	
	@RequestMapping(value="/products/{productCode}", method=RequestMethod.GET)
	public @ResponseBody Product getProduct(@PathVariable String productCode){
	
		Product product = productService.getProduct(productCode);
		return product;
		
//		if(product != null){
//			ProductResource res = new ProductResourceAsm().toResource(product);
//			return new ResponseEntity<ProductResource>(res,HttpStatus.OK);
//		} else {
//			return new ResponseEntity<ProductResource>(HttpStatus.NOT_FOUND);
//		}				
	}

	@RequestMapping(value = "/product", method = RequestMethod.POST)
	public ResponseEntity<ProductResource> addProduct(@RequestBody Product product){

		Product newProduct = productService.addProduct(product);

		if(newProduct != null){
			ProductResource res = new ProductResourceAsm().toResource(newProduct);
			return new ResponseEntity<ProductResource>(res,HttpStatus.CREATED);
		} else {
			return new ResponseEntity<ProductResource>(HttpStatus.NOT_FOUND);
		}

	}

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public @ResponseBody List<Product> getProducts(){

		return	productService.getProducts().getProducts();
	}

	@RequestMapping(value = "/product", method = RequestMethod.PUT)
	public ResponseEntity<ProductResource> updateProduct(@RequestBody Product product){

		Product updatedProduct = productService.updateProduct(product);
		if(updatedProduct != null){
			ProductResource res = new ProductResourceAsm().toResource(updatedProduct);
			return new ResponseEntity<ProductResource>(res, HttpStatus.OK);
		} else {
			return new ResponseEntity<ProductResource>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "/product", method = RequestMethod.DELETE)
	public ResponseEntity<ProductResource> deleteProduct(@RequestBody Product product){
		try{
			productService.deleteProduct(product);
			return new ResponseEntity<ProductResource>(HttpStatus.OK);
		} catch(Exception e){
			e.printStackTrace();
			return new ResponseEntity<ProductResource>(HttpStatus.EXPECTATION_FAILED);
		}
				
	}

}
