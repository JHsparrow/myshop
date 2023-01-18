package com.myshop.repository;

import static org.junit.jupiter.api.Assertions.*;


import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.TestPropertySource;
import org.thymeleaf.util.StringUtils;

import com.myshop.constant.ItemSellStatus;
import com.myshop.entity.Item;
import com.myshop.entity.QItem;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

@SpringBootTest
@TestPropertySource(locations="classpath:application-test.properties")
class ItemRepositoryTest {

	@Autowired
	ItemRepository itemRepository;
	
	@PersistenceContext 
	
	EntityManager em;
	
	
	public void createItemTest() {
		for(int i=1; i<=5; i++) {
			Item item = new Item();
			item.setItemNm("테스트 상품"+i);
			item.setPrice(10000+i);
			item.setItemDetail("테스트 상품 설명"+i);
			item.setItemSellStatus(ItemSellStatus.SELL);
			item.setStockNumber(100);
			item.setRegTime(LocalDateTime.now());
			item.setUpdateTime(LocalDateTime.now());
			Item saveItem = itemRepository.save(item);
		}
	}
	
	public void createItemTest2() {
		for(int i=6; i<=10; i++) {
			Item item = new Item();
			item.setItemNm("테스트 상품"+i);
			item.setPrice(10000);
			item.setItemDetail("테스트 상품 설명"+i);
			item.setItemSellStatus(ItemSellStatus.SOLD_OUT);
			item.setStockNumber(0);
			item.setRegTime(LocalDateTime.now());
			item.setUpdateTime(LocalDateTime.now());
			Item saveItem = itemRepository.save(item);
		}
	}
//	@Test
//	@DisplayName("상품 조회 테스트")
//	public void findByItemTest() {
//		this.createItemTest();
//		List<Item> itemList = itemRepository.findByItemNm("테스트 상품1");
//		for(Item item : itemList) {
//			System.out.println(item.toString());
//		}
//		
//	}
//	
//	@Test
//	@DisplayName("상품 조회 or 테스트")
//	public void findByItemOrDetailTest() {
//		this.createItemTest();
//		List<Item> itemList = itemRepository.findByItemNmOrItemDetail("테스트 상품1","테스트 상품 상세5");
//		for(Item item : itemList) {
//			System.out.println(item.toString());
//		}
//	}
//	
//	@Test
//	@DisplayName("상품 조회 order 테스트")
//	public void findByPriceLessThanOrderByPriceDescTest() {
//		this.createItemTest();
//		List<Item> itemList = itemRepository.findByPriceLessThanOrderByPriceDesc(15000);
//		for(Item item : itemList) {
//			System.out.println(item.toString());
//		}
//	}
	


//	itemSellStatus가 null이 아닌 레코드를 구하는 Juinit 테스트 코드를 완성하시오.
//	itemDetail이 설명1로 끝나는 레코드를 구하는 Junit 테스트 코드를 완성하시오.

//	@Test
//	@DisplayName("퀴즈1-1")
//	public void findByItemOrDetailTest() {
//		this.createItemTest();
//		List<Item> itemList = itemRepository.findByItemNmOrItemDetail("테스트 상품1","Sell");
//		for(Item item : itemList) {
//			System.out.println(item.toString());
//		}
//	}
	
//	@Test
//	@DisplayName("퀴즈1-2")
//	public void findByItemOrDetailTest() {
//		this.createItemTest();
//		List<Item> itemList = itemRepository.findByPriceBetween(10004,10008);
//		for(Item item : itemList) {
//			System.out.println(item.toString());
//		}
//	}
	
//	@Test
//	@DisplayName("퀴즈1-3")
//	public void findByRegTime() {
//		this.createItemTest();
//		List<Item> itemList = itemRepository.findByRegTimeGreaterThan("2023-1-1 12:12:44");
//		for(Item item : itemList) {
//			System.out.println(item.toString());
//		}
//	}
	
//	@Test
//	@DisplayName("퀴즈1-4")
//	public void findByRegTime() {
//		this.createItemTest();
//		List<Item> itemList = itemRepository.findByItemSellStatusNotNull();
//		for(Item item : itemList) {
//			System.out.println(item.toString());
//		}
//	}
	
//	@Test
//	@DisplayName("퀴즈1-5")
//	public void findByRegTime() {
//		this.createItemTest();
//		List<Item> itemList = itemRepository.findByItemDetailEndsWith("설명1");
//		for(Item item : itemList) {
//			System.out.println(item.toString());
//		}
//	}
	
//	@Test
//	@DisplayName("JPQL 테스트")
//	public void findByRegTime() {
//		this.createItemTest();
//		List<Item> itemList = itemRepository.findByItemDetail("테스트 상품 설명2");
//		for(Item item : itemList) {
//			System.out.println(item.toString());
//		}
//	}
	
//	@Test
//	@DisplayName("JPQL 테스트")
//	public void findByItemDetailNative() {
//		this.createItemTest();
//		List<Item> itemList = itemRepository.findByItemDetailNative("테스트 상품 설명2");
//		for(Item item : itemList) {
//			System.out.println(item.toString());
//		}
//	}
	
//	@Test
//	@DisplayName("JPQL 테스트")
//	public void findByItemDetail() {
//		this.createItemTest();
//		List<Item> itemList = itemRepository.findByPrice(10005);
//		for(Item item : itemList) {
//			System.out.println(item.toString());
//		}
//	}
	
//	@Test
//	@DisplayName("JPQL 테스트")
//	public void findByItemSellStatus() {
//		this.createItemTest();
//		List<Item> itemList = itemRepository.findByItemSellStatus("테스트 상품1",ItemSellStatus.SELL);
//		for(Item item : itemList) {
//			System.out.println(item.toString());
//		}
//	}
	
//	@Test
//	@DisplayName("queryDSL 테스트")
//	public void queryDslTest() {
//		this.createItemTest();
//		JPAQueryFactory qf = new JPAQueryFactory(em);
//		QItem qItem = QItem.item;
//		
//		JPAQuery<Item> query = qf.selectFrom(qItem)
//				.where(qItem.itemSellStatus.eq(ItemSellStatus.SELL))
//				.where(qItem.itemDetail.like("%테스트 상품 상세 설명%"))
//				.orderBy(qItem.price.desc());
//		
//		List<Item> itemList = query.fetch();
//		for(Item item : itemList) {
//			System.out.println(item.toString());
//		}
//	}
//	
//	@Test
//	@DisplayName("queryDSL 테스트2")
//	public void queryDslTest2() {
//		this.createItemTest2();
//		
//		BooleanBuilder b = new BooleanBuilder();
//		QItem item = QItem.item;
//		
//		String itemDetail = "테스트 상품 상세 설명";
//		int price = 10000;
//		String itemSellStatus = "";
//		
//		b.and(item.itemDetail.like("%"+itemDetail+"%"));
//		b.and(item.price.gt(price));
//		
//		if(StringUtils.equals(itemSellStatus, ItemSellStatus.SELL)) {
//			b.and(item.itemSellStatus.eq(ItemSellStatus.SELL));
//		}
//		
//		Pageable page = PageRequest.of(0, 3); // 조회할 페이지 번호 , 한 페이지당 조회할 개수
//		Page<Item> itemPageResult = itemRepository.findAll(page);
//		
//	}
	
//	@Test
//	@DisplayName("queryDSL 테스트3")
//	public void queryDslTest3() {
//		this.createItemTest2();
//		
//		JPAQueryFactory qf = new JPAQueryFactory(em);
//		QItem item = QItem.item;
//		
//		Pageable page = PageRequest.of(0, 3); // 조회할 페이지 번호 , 한 페이지당 조회할 개수
//		
//		JPAQuery<Item> query = qf.select
//		
//		Page<Item> itemPageResult = itemRepository.findAll(page);
//		
//	}
	
	
//	@Test
//	@DisplayName("DSL퀴즈 1")
//	public void queryDslQuiz1() {
//		this.createItemTest();
//		JPAQueryFactory qf = new JPAQueryFactory(em);
//		QItem qItem = QItem.item;
//		
//		JPAQuery<Item> query = qf.selectFrom(qItem)
//				.where(qItem.itemNm.eq("테스트 상품1"))
//				.where(qItem.itemSellStatus.eq(ItemSellStatus.SELL));
//		
//		List<Item> itemList = query.fetch();
//		for(Item item : itemList) {
//			System.out.println(item.toString());
//		}
//	}
	
//	@Test
//	@DisplayName("DSL퀴즈 2")
//	public void queryDslQuiz2() {
//		this.createItemTest();
//		JPAQueryFactory qf = new JPAQueryFactory(em);
//		QItem qItem = QItem.item;
//		
//		JPAQuery<Item> query = qf.selectFrom(qItem)
//				.where(qItem.price.between(10004,10008));
//		
//		List<Item> itemList = query.fetch();
//		for(Item item : itemList) {
//			System.out.println(item.toString());
//		}
//	}
	
//	@Test
//	@DisplayName("DSL퀴즈 3")
//	public void queryDslQuiz3() {
//		this.createItemTest();
//		JPAQueryFactory qf = new JPAQueryFactory(em);
//		QItem qItem = QItem.item;
//		
//		JPAQuery<Item> query = qf.selectFrom(qItem)
//				.where(qItem.regTime.after(LocalDateTime.of(2023, 1, 1, 12, 12, 44)));
//		
//		List<Item> itemList = query.fetch();
//		for(Item item : itemList) {
//			System.out.println(item.toString());
//		}
//	}
	
//	@Test
//	@DisplayName("DSL퀴즈 4")
//	public void queryDslQuiz4() {
//		this.createItemTest();
//		JPAQueryFactory qf = new JPAQueryFactory(em);
//		QItem qItem = QItem.item;
//		
//		JPAQuery<Item> query = qf.selectFrom(qItem)
//				.where(qItem.itemSellStatus.isNotNull());
//		
//		List<Item> itemList = query.fetch();
//		for(Item item : itemList) {
//			System.out.println(item.toString());
//		}
//	}
	
	@Test
	@DisplayName("DSL퀴즈 5")
	public void queryDslQuiz5() {
		this.createItemTest();
		JPAQueryFactory qf = new JPAQueryFactory(em);
		QItem qItem = QItem.item;
		
		JPAQuery<Item> query = qf.selectFrom(qItem)
				.where(qItem.itemDetail.endsWith("설명1"));
		
		List<Item> itemList = query.fetch();
		for(Item item : itemList) {
			System.out.println(item.toString());
		}
	}
	
	
	
	
}
