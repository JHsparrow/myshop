package com.myshop.dto;

import java.time.LocalDateTime;

import com.myshop.constant.ItemSellStatus;

import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public class ItemDto {

	private Long id;
	private String itemNm;
	private int price;
	private int stockNumber;
	private String itemDetail;
	private ItemSellStatus itemSellStatus;
	private LocalDateTime regTime;
	private LocalDateTime updatetime;
}
