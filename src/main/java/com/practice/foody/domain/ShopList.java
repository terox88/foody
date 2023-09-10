package com.practice.foody.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class ShopList {
    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    private long id;
    @Column(name = "List", length = 2000)
    private String shoppingList;

}
