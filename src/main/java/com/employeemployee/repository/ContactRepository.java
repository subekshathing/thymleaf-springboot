package com.employeemployee.repository;

import com.employeemployee.model.FContact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository <FContact, Long> {
}
