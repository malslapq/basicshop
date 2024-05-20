package com.sparta.spartashop.dto;

import com.sparta.spartashop.entiry.Item;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ItemDto {

    private Long id;
    private String title;
    private String content;
    private int price;
    private String userName;

    public static ItemDto from (Item item) {
        return ItemDto.builder()
            .id(item.getId())
            .title(item.getTitle())
            .content(item.getContent())
            .price(item.getPrice())
            .userName(item.getUserName())
            .build();
    }

}
