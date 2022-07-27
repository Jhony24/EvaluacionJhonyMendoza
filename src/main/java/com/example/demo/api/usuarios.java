package com.example.demo.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/")
public class usuarios {
	@RequestMapping(value="holamundo",method = RequestMethod.GET)
	public List HolaMundo() {
		List myArrayList = new ArrayList();
		ArrayList<Integer> lista = new ArrayList<Integer>();
		for (int i = 1; i <= 100; i++) {
			 if (i%3==0 && i%5==0){
				myArrayList.add("SOMOS BA");
			}else if(i%3==0) {
				myArrayList.add("SOMOS");
				}else if (i%5==0){
					myArrayList.add("BA");
				}else{
				myArrayList.add(i);
			}
		}
		
		return myArrayList;
		
	}
	
	@RequestMapping(value="anagrama",method = RequestMethod.GET)
	public String Anagrama() {
		 String palabra1 = "ACUERDOE";        // Tom Sorvolo Acertijo
	     String palabra2 = "ECUADORR";        // Soy Lord Voldemort
	 
	        if (VerificarAnagrama(palabra1, palabra2)) {
	           return "SI ES UNA ANAGRAMA";
	        }
	        else {
	            return "NO ES UN ANAGRAMA";
	        }
		
	}
	
	 public static boolean VerificarAnagrama(String palabra1, String palabra2)
	    {
	        // caso base
	        if (palabra1 == null || palabra2 == null) {
	            return false;
	        }
	 
	        // verificar longitudes
	        if (palabra1.length() != palabra2.length()) {
	            return false;
	        }
	 
	        Map<Character, Integer> freq = new HashMap<>();
	 
	        for (char c: palabra1.toCharArray()) {
	            freq.put(c, freq.getOrDefault(c, 0) + 1);
	        }
	 
	        for (char c: palabra2.toCharArray())
	        {
	            if (!freq.containsKey(c)) {
	                return false;
	            }
	 
	            freq.put(c, freq.get(c) - 1);
	 
	            if (freq.get(c) == 0) {
	                freq.remove(c);
	            }
	        }
	 
	        return freq.isEmpty();
	    }
	 
	 @RequestMapping(value="ordenar",method = RequestMethod.GET)
		public List Ordenar() {
		 List myArrayList = new ArrayList();
		 Integer [] numeros = {50,5,10,36,25,85,23,65};
		 Arrays.sort(numeros, Collections.reverseOrder());                                                                 
		 for (int n : numeros) {
		       myArrayList.add(n);                                                                                     
		 }
		 return myArrayList;
		}
	 
	 @RequestMapping(value="consumo",method = RequestMethod.GET)
		public List<Object> getConsumo() {
		 String url= "https://jsonplaceholder.typicode.com/posts";
		 RestTemplate restTemplate = new RestTemplate();
		 
		 Object[] consumo = restTemplate.getForObject(url, Object[].class);
		 return Arrays.asList(consumo);
		}
}
