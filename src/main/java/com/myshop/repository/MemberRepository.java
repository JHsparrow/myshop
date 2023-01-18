package com.myshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myshop.entity.*;

public interface MemberRepository extends JpaRepository<Member, Long> {
	
	Member findByEmail(String email);
	
	
}
