package com.myshop.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import com.myshop.constant.ItemSellStatus;
import com.myshop.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long>, QuerydslPredicateExecutor<Item>, ItemRepositoryCustom {

	List<Item> findByItemNm(String ItemNm);
	List<Item> findByItemNmOrItemDetail(String ItemNm, String ItemDetail);
	List<Item> findByItemNmOrItemSellStatus(String ItemNm, String ItemSellStatus);
	
	
	
	
//	List<Item> findByPriceBetween(Integer price1, Integer price2);	
//	List<Item> findByPriceLessThanOrderByPriceDesc(Integer price);		
//	List<Item> findByRegTimeGreaterThan(String date);	
//	List<Item> findByItemSellStatusNotNull();	
//	List<Item> findByItemDetailEndsWith(String ItemDetail);
	
//	@Query("select i from Item i where i.itemDetail like %:itemDetail% order by i.price desc ")
//	List<Item> findByItemDetail(@Param("itemDetail") String itemDetail);
	
//	@Query("select i from Item i where i.itemDetail like %?1% order by i.price desc ")
//	List<Item> findByItemDetail(String itemDetail);
//	
//	@Query(value="select * from Item i where i.item_detail %:itemDetail% order by i.price desc", nativeQuery = true)
//	List<Item> findByItemDetailNative(@Param("itemDetail") String itemDetail);
	
	
//	@Query("select i from Item i where i.price > :price")
//	List<Item> findByPrice(@Param("price") int price);
	
//	@Query("select i from Item i where itemNm = :itemNm and itemSellStatus = :itemSellStatus")
//	List<Item> findByItemSellStatus(@Param("itemNm") String itemNm ,@Param("itemSellStatus") ItemSellStatus itemSellStatus);
	
	@Query("select i from Item i where itemNm = ?1 and itemSellStatus = ?2")
	List<Item> findByItemSellStatus(String itemNm , ItemSellStatus itemSellStatus);
	
	
	
}
