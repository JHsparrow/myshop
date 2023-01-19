package com.myshop.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.modelmapper.ModelMapper;

import com.myshop.constant.ItemSellStatus;
import com.myshop.entity.Item;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ItemFormDto {
	
	private Long id;
	
	@NotBlank(message = "상품명은 필수 입력 값입니다.")
	private String itemNm;
	
	@NotNull(message = "가격은 필수 입력 값입니다.")
	private int price;
	
	@NotNull(message = "재고는 필수 입력 값입니다.")
	private int stockNumber;
	
	@NotBlank(message = "상품 상세설명은 필수 입력 값입니다.")
	private String itemDetail;
	
	private ItemSellStatus itemSellStatus;
	
	private List<ItemImgDto> itemImgDtoList = new ArrayList<>(); // 상품 이미지 정보 저장
	
	private List<Long> itemImgIds = new ArrayList<>(); //상품 이미지 아이디 저장
	
	private static ModelMapper modelMapper = new ModelMapper();
	
	public Item createItem() {
		return modelMapper.map(this, Item.class);
	}
	public static ItemFormDto of(Item item) {
		return modelMapper.map(item, ItemFormDto.class);
	}
	
}
