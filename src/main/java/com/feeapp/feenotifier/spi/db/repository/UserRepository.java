package com.feeapp.feenotifier.spi.db.repository;

import com.feeapp.feenotifier.spi.db.entity.UserEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
  Optional<UserEntity> findByEmailAndPassword(final String email, final String password);

  Optional<UserEntity> findByEmail(final String email);

  Optional<UserEntity> findByUserId(final String userId);
}
