package com.feeapp.feenotifier.spi.db.repository;

import com.feeapp.feenotifier.spi.db.entity.UserEntity;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
  Optional<UserEntity> findByEmailAndPassword(final String email, final String password);

  Optional<UserEntity> findByEmail(final String email);

  Optional<UserEntity> findByUserId(final String userId);

  @Modifying
  @Transactional
  @Query(value = "update user_details  set account_status = ?1 where email= ?2", nativeQuery = true)
  void setAccountAsActive(String status, String email);
}
