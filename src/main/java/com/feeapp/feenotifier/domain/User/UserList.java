package com.feeapp.feenotifier.domain.User;

import com.feeapp.feenotifier.spi.db.entity.UserEntity;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class UserList {
  private List<UserEntity> users;

  public UserList() {
    this.users = new ArrayList<>();
  }
}
