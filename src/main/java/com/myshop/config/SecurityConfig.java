package com.myshop.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.myshop.service.MemberService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	MemberService memberService;
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.formLogin()
		.loginPage("/members/login") //로그인 페이지 url설정
		.defaultSuccessUrl("/") // 로그인 성공시 이동할 페이지
		.usernameParameter("email") //로그인 시 사용할 파라메터
		.failureUrl("/members/login/error") //로그인 실패시 이동할 url
		.and()
		.logout()
		.logoutRequestMatcher(new AntPathRequestMatcher("/members/logout")) //로그아웃 url
		.logoutSuccessUrl("/"); // 로그아웃 성공 시 이동할 url
		
		http.authorizeRequests()
		.mvcMatchers("/css/**","/js/**","/img/**").permitAll()
		.mvcMatchers("/","/members/**","/item/**","/images/**").permitAll()
		.mvcMatchers("/admin/**").hasRole("AMDIN") // adimin' 으로 시작하는 경로는 계정이 ADMIN role일 경우 에만 접근 가능하도록 설정
		.anyRequest().authenticated(); //그 외에 페이지는 모두 로그인 인증을 받아야한다.
		
		//인증되지 않은 사용자가 리소스에 접근했을때 설정
		http.exceptionHandling().authenticationEntryPoint(new CustomAuthenticationEntryPoint());
		return http.build();
	}
	
	//비밀번호 암호화 저장
	@Bean //스프링 객체
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
