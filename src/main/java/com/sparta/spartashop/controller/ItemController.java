package com.sparta.spartashop.controller;

import com.sparta.spartashop.dto.ItemDto;
import com.sparta.spartashop.service.ItemService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @PostMapping("/post")
    public ItemDto addItem(@RequestBody ItemDto itemDto) {
        return itemService.addItem(itemDto);
    }

    @GetMapping("/post")
    public List<ItemDto> getAllItems() {
        return itemService.getAllItems();
    }

    @PutMapping("/post/{id}")
    public ItemDto modifyItem(@PathVariable Long id, @RequestBody ItemDto itemDto) {
        return itemService.modifyItem(id, itemDto);
    }

    @DeleteMapping("/post/{id}")
    public ResponseEntity<?> removeItem(@PathVariable Long id) {
        Map<String, String> response = new HashMap<>();
        response.put("msg", itemService.removeItem(id));
        return ResponseEntity.ok().body(response);
    }


}
