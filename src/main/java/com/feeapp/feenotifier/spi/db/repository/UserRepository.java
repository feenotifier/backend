package com.feeapp.feenotifier.spi.db.repository;

import com.feeapp.feenotifier.spi.db.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
