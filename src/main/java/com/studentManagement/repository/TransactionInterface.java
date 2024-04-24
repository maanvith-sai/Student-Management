package com.studentManagement.repository;

import com.studentManagement.entity.semester.TransactionId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionInterface extends JpaRepository<TransactionId,String>
{

}
