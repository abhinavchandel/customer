package customer.controller;

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
	
	@GetMapping("/useGet")
	
	public Product[] useGet(){
		
		RestTemplate res=new RestTemplate();
		
		ResponseEntity<Product[]> response=res.getForEntity("http://localhost:8082//allprod", Product[].class);
		Product[] listpr=response.getBody();
		
		return listpr;
	}
	
   @GetMapping("/usePost")
	
	public Product usePost(){
		
		RestTemplate res=new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		Product pr=new Product();
		pr.setProduct_id(1);
		HttpEntity<Product> request = new HttpEntity<>(pr,headers);
		ResponseEntity<Product> response=res.postForEntity("http://localhost:8082//getByprod_name", request, Product.class);
		Product prod=response.getBody();
		
		return prod;
	}
	
  
   @GetMapping("/getprod_name/{name}")
	
 	public Product[] getprod_name(@PathVariable String name){
	   
	   System.out.println("name is"+name);
 		
 		RestTemplate res=new RestTemplate();
 		
 		HttpHeaders headers = new HttpHeaders();
 		headers.setContentType(MediaType.APPLICATION_JSON);
 		Product pr=new Product();
 		pr.setProduct_name(name);
 		HttpEntity<Product> request = new HttpEntity<>(pr,headers);
 		ResponseEntity<Product[]> response=res.postForEntity("http://localhost:8082//getByprod_name", request, Product[].class);
 		Product[] prod=response.getBody();
 		
 		return prod;
 	}

  
}
