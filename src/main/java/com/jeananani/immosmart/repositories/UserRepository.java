package com.jeananani.immosmart.repositories;

import com.jeananani.immosmart.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
