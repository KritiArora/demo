package com.example.demo.service;


import com.example.demo.model.Item;
import com.example.demo.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public Optional<Item> getItemById(Long id) {
        return itemRepository.findById(id);
    }

    @Override
    public Item addItem(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public Item updateItem(Long id, Item item) {
        Optional<Item> existing = itemRepository.findById(id);
        if (existing.isPresent()) {
            Item updated = existing.get();
            updated.setName(item.getName());
            updated.setCategory(item.getCategory());
            updated.setQuantity(item.getQuantity());
            updated.setPrice(item.getPrice());
            return itemRepository.save(updated);
        }
        return null;
    }

    @Override
    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }
}

