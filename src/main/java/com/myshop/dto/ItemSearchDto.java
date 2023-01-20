package com.myshop.dto;

import com.myshop.constant.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemSearchDto {
	private String serchDateType;
	private ItemSellStatus serchSellStatus;
	private String searchBy;
	private String searchQuery = "";
}
