package com.user.repository;

import com.user.entity.AddressEntity;
import com.user.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<AddressEntity, Long> {

    List<AddressEntity> findAllByPersonEntityPhoneNumber(String phoneNumber);
}
