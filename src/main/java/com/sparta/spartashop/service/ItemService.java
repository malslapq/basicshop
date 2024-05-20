package com.sparta.spartashop.service;

import com.sparta.spartashop.dto.ItemDto;
import com.sparta.spartashop.entiry.Item;
import com.sparta.spartashop.repository.ItemRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemDto addItem(ItemDto itemDto) {
        return ItemDto.from(
            itemRepository.save(
                Item.builder()
                    .id(itemDto.getId())
                    .title(itemDto.getTitle())
                    .content(itemDto.getContent())
                    .price(itemDto.getPrice())
                    .userName(itemDto.getUserName())
                    .build()
            )
        );
    }

    public List<ItemDto> getAllItems() {
        return itemRepository.findAll()
            .stream().map(ItemDto::from).collect(Collectors.toList());
    }

    @Transactional
    public ItemDto modifyItem(Long id, ItemDto itemDto) {

        Item item = itemRepository.findById(id)
            .orElseThrow(() -> new NullPointerException("존재하지 않는 상품"));

        item.modifyItem(itemDto);

        return ItemDto.from(item);
    }

    public String removeItem(Long id) {
        if (itemRepository.existsById(id)) {
            itemRepository.deleteById(id);
            return "삭제완료";
        } else {
            throw new NullPointerException("존재하지 않는 상품");
        }
    }
}
