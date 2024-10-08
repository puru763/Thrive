package com.thrive.userservice.repository;

import com.thrive.userservice.entity.User;
import com.thrive.userservice.entity.dto.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
     Optional<User> findByMobileNumber(String mobileNumber);
}
