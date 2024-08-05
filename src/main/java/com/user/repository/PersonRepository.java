package com.user.repository;

import com.user.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, String> {
    @Transactional(readOnly = true)
    PersonEntity findByPhoneNumberAndPassword(String phoneNumber, String password);
}
