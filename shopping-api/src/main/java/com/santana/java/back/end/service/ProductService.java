package com.santana.java.back.end.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.santana.java.back.end.dto.ProductDTO;
import com.santana.java.back.end.dto.UserDTO;
import com.santana.java.back.end.exception.UserNotFoundException;

@Service
public class ProductService {

	public ProductDTO getProductByIdentifier(String productIdentifier) {
		try {
			RestTemplate restTemplate = new RestTemplate();
			String url = "http://localhost:8081/product/" + productIdentifier;
			ResponseEntity<ProductDTO> response = restTemplate.getForEntity(url, ProductDTO.class);
			return response.getBody();
		} catch (HttpClientErrorException.NotFound e) {
			throw new UserNotFoundException();
		}
	}

	public UserDTO getUserByCpf(String cpf) {
		try {
			RestTemplate restTemplate = new RestTemplate();
			String url = "http://localhost:8080/user/cpf/" + cpf;
			ResponseEntity<UserDTO> response = restTemplate.getForEntity(url, UserDTO.class);
			return response.getBody();
		} catch (HttpClientErrorException.NotFound e) {
			throw new UserNotFoundException();
		}
	}
}