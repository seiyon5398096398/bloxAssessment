package com.blox.questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class QuestionsApplication {
	
	public static void main(String[] args) {	
		
		SpringApplication.run(QuestionsApplication.class, args);
		
		String jsonString = "{\n"
				+ "  \"firstname\": \"ss234\",\n"
				+ "	\"lastname\": \"s78\",\n"
				+ "  \"email\": \"ss.do@eample.com\",\n"
				+ "  \"phonenumber\": [1234577890],\n"
				+ "  \"doj\": \"2023-03-01\",\n"
				+ "  \"salary\": 2800000\n"
				+ "}" ;
		
		String jsonStringList = """
	            ["Java", "Python", "JavaScript"]
	            """;
		
		
		ObjectMapper mapper = new ObjectMapper();
		Object result= null;
		List<Object> list = new ArrayList<>();
		Map<Object, Object> map = new HashMap<>();
		
		try {
			
			result = mapper.readValue(jsonString, Object.class);
			
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		if(result!=null && result instanceof Map)
		{
			map = (Map<Object, Object>) result;
			System.out.println("Map items: "+ map);
		}
		else if(result!=null && result instanceof List)
		{
			list = (List<Object>)result;
			System.out.println("List items  "+list);
		}
		else
		{
			System.out.println("not able to parse the string..");
		}		
		
	}

}
