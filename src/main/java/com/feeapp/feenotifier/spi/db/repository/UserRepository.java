package com.feeapp.feenotifier.spi.db.repository;

import com.feeapp.feenotifier.spi.db.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByEmailAndPassword(final String email, final String password);
    Optional<UserEntity> findByEmail(final String email);
}
