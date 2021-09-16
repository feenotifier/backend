package com.feeapp.feenotifier.spi.db.repository;

import com.feeapp.feenotifier.domain.User.User;
import com.feeapp.feenotifier.spi.db.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    public Optional<UserEntity> findByEmailAndPassword(final String email, final String password);

}
