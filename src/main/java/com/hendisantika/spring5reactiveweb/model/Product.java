package com.hendisantika.spring5reactiveweb.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * Created by IntelliJ IDEA.
 * Project : spring5-reactive-web
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 10/04/20
 * Time: 07.20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @JsonProperty("id")
    private int productId;

    @JsonProperty("name")
    private String productName;

    @JsonProperty("description")
    private String description;

    @JsonProperty("image")
    private String imageUrl;

    @JsonProperty("price")
    private BigDecimal price;
}
