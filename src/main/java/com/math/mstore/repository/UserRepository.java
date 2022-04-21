package com.math.mstore.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.math.mstore.model.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {

	public Optional<UserModel> findByEmail(String email);

	public List<UserModel> findAllByNameContainingIgnoreCase(String name);

}

