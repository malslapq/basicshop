package com.sparta.spartashop.repository;

import com.sparta.spartashop.entiry.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
