package com.myshop.repository;

import org.springframework.data.domain.Page;

import com.myshop.dto.ItemSearchDto;
import com.myshop.entity.Item;

public interface ItemRepositoryCustom {
	Page<Item> getAdminItemPage(ItemSearchDto itemSearchDto);
}
