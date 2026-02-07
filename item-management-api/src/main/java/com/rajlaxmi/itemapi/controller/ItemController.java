package com.rajlaxmi.itemapi.controller;

import com.rajlaxmi.itemapi.model.Item;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    private final List<Item> itemList = new ArrayList<>();
    private int currentId = 1;

    // Root endpoint - helpful for Render to avoid whitelabel error at '/'
    @GetMapping("/")
    public String home() {
        return "Item Management API is running!";
    }

    // Add a new item
    @PostMapping
    public ResponseEntity<?> addItem(@RequestBody Item item) {
        if (item.getName() == null || item.getName().isEmpty()) {
            return ResponseEntity.badRequest().body("Item name is required");
        }
        if (item.getDescription() == null || item.getDescription().isEmpty()) {
            return ResponseEntity.badRequest().body("Item description is required");
        }

        item.setId(currentId++);
        itemList.add(item);
        return new ResponseEntity<>(item, HttpStatus.CREATED);
    }

    // Get an item by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getItemById(@PathVariable int id) {
        Optional<Item> itemOpt = itemList.stream()
                .filter(i -> i.getId() == id)
                .findFirst();

        if (itemOpt.isPresent()) {
            return ResponseEntity.ok(itemOpt.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item not found");
        }
    }
}
