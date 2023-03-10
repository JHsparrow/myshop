package com.myshop.repository;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.thymeleaf.util.StringUtils;

import com.myshop.constant.ItemSellStatus;
import com.myshop.dto.ItemSearchDto;
import com.myshop.entity.Item;
import com.myshop.entity.QItem;
import com.querydsl.core.QueryResults;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;

public class ItemRepositoryCustomImpl implements ItemRepositoryCustom {

	private JPAQueryFactory queryFactory;
	
	public ItemRepositoryCustomImpl(EntityManager em) {
		this.queryFactory = new JPAQueryFactory(em);
	}
	
	private BooleanExpression regDtsAfter(String searchDateType) {
		LocalDateTime dateTime = LocalDateTime.now();
		
		if(StringUtils.equals("all", searchDateType) || searchDateType == null) return null;
		else if(StringUtils.equals("1d", searchDateType)) dateTime = dateTime.minusDays(1);
		else if(StringUtils.equals("1w", searchDateType)) dateTime = dateTime.minusWeeks(1);
		else if(StringUtils.equals("1m", searchDateType)) dateTime = dateTime.minusMonths(1);
		else if(StringUtils.equals("6m", searchDateType)) dateTime = dateTime.minusMonths(6);
		
		return QItem.item.regTime.after(dateTime);
	}
	
	private BooleanExpression searchSellStatusEq(ItemSellStatus searchSellStatus) {
		return searchSellStatus == null ? null : QItem.item.itemSellStatus.eq(searchSellStatus);
	}
	
	private BooleanExpression searchByLike(String searchBy, String searchQuery) {
		if(StringUtils.equals("itemNm", searchBy)) {
			return QItem.item.itemNm.like("%" + searchQuery + "%");
		}
		else if(StringUtils.equals("createdBy", searchBy)) {
			return QItem.item.createBy.like("%" + searchQuery + "%");
		}
		return null;
	}
	
	@Override
	public Page<Item> getAdminItemPage(ItemSearchDto itemSearchDto, Pageable pageable ) {
		
		 
		
		List<Item> content = queryFactory
				.selectFrom(QItem.item) 
				.where(regDtsAfter(itemSearchDto.getSerchDateType()),
						searchSellStatusEq(itemSearchDto.getSerchSellStatus()),
						searchByLike(itemSearchDto.getSearchBy(), itemSearchDto.getSearchQuery()))
				.orderBy(QItem.item.id.desc())
				.offset(pageable.getOffset())  //???????????? ????????? ?????? ?????????
				.limit(pageable.getPageSize()) //????????? ????????? ??? ?????? ??????
				.fetch();
		
		long total = content.size();
		
		return new PageImpl<>(content, pageable, total);
	}
	
}
