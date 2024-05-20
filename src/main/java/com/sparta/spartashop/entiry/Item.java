package com.sparta.spartashop.entiry;

import com.sparta.spartashop.dto.ItemDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String content;
    @Column(nullable = false)
    private int price;
    @Column(nullable = false)
    private String userName;

    public void modifyItem(ItemDto itemDto){
        this.title = itemDto.getTitle();
        this.content = itemDto.getContent();
        this.price = itemDto.getPrice();
        this.userName = itemDto.getUserName();
    }

}
