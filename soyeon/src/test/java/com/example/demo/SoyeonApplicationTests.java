package com.example.demo;

import java.util.HashMap;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SoyeonApplicationTests { 

	@Test
	public int solution() {
		int answer = 0;
		String[][] clothes = {{"A","a"},{"B","b"},{"C","a"}};
		
		HashMap<String, Integer> map = new HashMap<>();
		for(String[] clothe : clothes) {
			String type = clothe[1];
			map.put(type, map.getOrDefault(type, 0) + 1);
		}
		System.out.println(answer);
		return answer;
	};
	
	

}
