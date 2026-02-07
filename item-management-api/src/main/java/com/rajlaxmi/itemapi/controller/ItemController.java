package com.rajlaxmi.itemapi.controller;

import com.rajlaxmi.itemapi.model.Item;
import com.rajlaxmi.itemapi.service.ItemService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping
    public Item addItem(@Valid @RequestBody Item item) {
        return itemService.addItem(item);
    }


    @GetMapping("/{id}")
    public Item getItem(@PathVariable int id) {
        return itemService.getItemById(id);
    }
}
