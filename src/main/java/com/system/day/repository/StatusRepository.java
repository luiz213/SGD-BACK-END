package com.system.day.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.system.day.entity.Status;

@Repository
public interface StatusRepository extends JpaRepository<Status, Long>{

}
