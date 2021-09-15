package com.feeapp.feenotifier.db;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table
public class users {
    @Id
    Long id;
    private String username;
    private String pass;
}
