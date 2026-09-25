package com.example.hw2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuItem implements Serializable {
    private Long id;
    private Long restaurantId;
    private String dishName;
    private Integer price;
}
