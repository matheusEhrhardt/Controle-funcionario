package com.marcos.mrcjewelscatalog.repositories;

import com.marcos.mrcjewelscatalog.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
