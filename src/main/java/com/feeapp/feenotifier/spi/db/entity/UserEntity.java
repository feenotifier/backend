package com.feeapp.feenotifier.spi.db.entity;

import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.Instant;

@Data
@Entity
@Table(name = "user_details")
@Log4j2
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "user_id_sequence")
    Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "password")
    private String password;

    @Column(name = "user_permission")
    private String userPermission;

    @Column(name = "created_at")
    @CreationTimestamp
    private Instant createdAt;

}
