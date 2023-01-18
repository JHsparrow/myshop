package com.myshop.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@AutoConfigureMockMvc // 테스트 객체 만들기
@TestPropertySource(locations = "classpath:application-test.properties")

class ItemControllerTest {

	@Autowired
	MockMvc mockMvc;
	
	@Test
	@DisplayName("상품 등록 페이지 권한 테스트")
	@WithMockUser(username = "admin", roles = "ADMIN") //유저가 로그인된 상태로 테스트 할 수 있게 해준다.
	public void itemFormTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/admin/item/new")) //get방식으로 request함
        .andDo(print())
        .andExpect(status().isOk());
		
	}
	
	@Test
	@DisplayName("상품 등록 페이지 권한 테스트")
	@WithMockUser(username = "user", roles = "USER") //유저가 로그인된 상태로 테스트 할 수 있게 해준다.
	public void itemFormNotAdminTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/admin/item/new")) //get방식으로 request함
        .andDo(print())
        .andExpect(status().isForbidden());
		
	}
	
}
