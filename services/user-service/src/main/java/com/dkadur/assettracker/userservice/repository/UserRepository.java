package com.dkadur.assettracker.userservice.repository;

import com.dkadur.assettracker.userservice.entity.User;
import com.google.cloud.spring.data.spanner.repository.SpannerRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends SpannerRepository<User, Long> {

    List<User> findByUsername(String username);

}
