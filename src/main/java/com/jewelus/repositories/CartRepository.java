package com.jewelus.repositories;

import com.jewelus.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, String> {
    Cart save(Cart cart);
}
