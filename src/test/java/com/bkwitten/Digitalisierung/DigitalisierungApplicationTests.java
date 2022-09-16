package com.bkwitten.Digitalisierung;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class DigitalisierungApplicationTests {
        
        @Autowired
	private MockMvc mockMvc;
/*
	@Test
	public void plus() throws Exception {
            System.out.println("/////////////////// Test 1 ///////////////");
            int a = 10, b = 12;
            int c = a+b;
            
            this.mockMvc.perform(get("/plus").param("a", String.valueOf(a)).param("b", String.valueOf(b))).andDo(print()).andExpect(status().isOk()).andExpect(content().string(String.valueOf(c)));
            
	}
*/

}
