package customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import customer.model.Product;

@RestController
public class CustomerController {
	
	@Autowired
	private Environment env;
	
	@GetMapping("/useGet")
	
	public Product[] useGet(){
		String getProduct = env.getProperty("product.get.all");

		RestTemplate res=new RestTemplate();
		
		ResponseEntity<Product[]> response=res.getForEntity(getProduct, Product[].class);
		Product[] listpr=response.getBody();
		
		return listpr;
	}
	
   @GetMapping("/usePost")
	
	public Product usePost(){
		
		RestTemplate res=new RestTemplate();
		String getPorductByName = env.getProperty("product.get.byname");
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		Product pr=new Product();
		pr.setProduct_id(1);
		HttpEntity<Product> request = new HttpEntity<>(pr,headers);
		ResponseEntity<Product> response=res.postForEntity(getPorductByName, request, Product.class);
		Product prod=response.getBody();
		
		return prod;
	}
	
  
   @GetMapping("/getprod_name/{name}")
	
 	public Product[] getprod_name(@PathVariable String name){
	   
	   System.out.println("name is"+name);
	   String getPorductByName = env.getProperty("product.get.byname");
 		RestTemplate res=new RestTemplate();
 		
 		HttpHeaders headers = new HttpHeaders();
 		headers.setContentType(MediaType.APPLICATION_JSON);
 		Product pr=new Product();
 		pr.setProduct_name(name);
 		HttpEntity<Product> request = new HttpEntity<>(pr,headers);
 		ResponseEntity<Product[]> response=res.postForEntity(getPorductByName, request, Product[].class);
 		Product[] prod=response.getBody();
 		
 		return prod;
 	}

  
}
