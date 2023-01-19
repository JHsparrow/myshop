package com.myshop.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;
import lombok.Setter;

@EntityListeners(value = {AuditingEntityListener.class}) //auditing적용을 위해
@MappedSuperclass
@Getter
@Setter

public class BaseEntity extends BaseTimeEntity {
	@CreatedBy
	@Column(updatable = false)
	private String createBy;
	
	@LastModifiedBy
	private String modifiedBy;
}
