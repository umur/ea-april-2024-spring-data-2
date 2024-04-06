package com.Shop.Market.repository;

import com.Shop.Market.Domain.Product;
import com.Shop.Market.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
