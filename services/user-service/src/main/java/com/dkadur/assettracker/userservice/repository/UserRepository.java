package com.dkadur.assettracker.userservice.repository;

import com.dkadur.assettracker.userservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.PreRemove;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByUsername(String username);

}
