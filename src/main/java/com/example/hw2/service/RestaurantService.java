package com.example.hw2.service;

import com.example.hw2.model.MenuItem;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class RestaurantService {

    @Cacheable(value = "restaurantMenu", key = "#id")
    public List<MenuItem> getMenuByRestaurantId(Long id) {
        log.info("--- Thực hiện truy vấn DB cho restaurantId: {} ---", id);
        try {
            // Giả lập thời gian truy vấn DB phức tạp
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        // Trả về dữ liệu hard-code
        return Arrays.asList(
                new MenuItem(1L, id, "Phở Bò", 55000),
                new MenuItem(2L, id, "Bún Chả", 60000)
        );
    }
}
