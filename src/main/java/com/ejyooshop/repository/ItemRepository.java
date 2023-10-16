package com.ejyooshop.repository;

import com.ejyooshop.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long>, QuerydslPredicateExecutor<Item> {
    // # Query Method

    // 상품 이름을 이용하여 데이터를 조회
    List<Item> findByItemNm(String itemNm);

    // OR 조건을 사용하여 데이터 조회
    List<Item> findByItemNmOrItemDetail(String itemNm, String itemDetail);

    // LessThan 조건을 사용하여 데이터 조회
    List<Item> findByPriceLessThan(Integer price);

    // Order By 로 정렬 처리하기
    List<Item> findByPriceLessThanOrderByPriceDesc(Integer price);





    // @Query
    @Query("select i from Item i where i.itemDetail like %:itemDetail% order by i.price desc")
    List<Item> findByItemDetail(@Param("itemDetail") String itemDetail);

    // @Query -> native query
    @Query(value="select * from item i where i.item_detail like %:itemDetail% order by i.price desc", nativeQuery = true)
    List<Item> findByItemDetailByNative(@Param("itemDetail") String itemDetail);
}
