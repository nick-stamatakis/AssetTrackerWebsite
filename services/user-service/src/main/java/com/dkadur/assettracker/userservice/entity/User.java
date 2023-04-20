package com.dkadur.assettracker.userservice.entity;

import com.google.cloud.spring.data.spanner.core.mapping.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @PrimaryKey(keyOrder = 1)
    @Column(name="userId")
    private Long userId;

    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

    @Column(name="tenantId")
    private int tenantId;
}
