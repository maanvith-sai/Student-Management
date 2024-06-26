package com.studentManagement.repository.semester;


import com.studentManagement.entity.Student;
import com.studentManagement.entity.semester.Fees;
import com.studentManagement.entity.semester.first;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeesInterface extends JpaRepository<Fees,Long> {

    @Query("SELECT s FROM Student s JOIN FETCH s.fees")
    List<Student> findAllUsersWithAddressfirst();

    @Query("SELECT s FROM first s where s.id1=:value")
    List<first> findUsersWithId(@Param("value") String value);
}
