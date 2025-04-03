package com.example.demo.service;
import com.example.demo.model.Item;
import java.util.List;
import java.util.Optional;
public interface ItemService {
    List<Item> getAllItems();
    Optional<Item> getItemById(Long id);
    Item addItem(Item item);
    Item updateItem(Long id, Item item);
    void deleteItem(Long id);
}

