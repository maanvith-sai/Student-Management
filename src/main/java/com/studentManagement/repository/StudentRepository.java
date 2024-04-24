package com.studentManagement.repository;


import com.studentManagement.entity.Student;
import com.studentManagement.entity.semester.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, String> {
    @Query("SELECT u FROM Student u WHERE u.id = ?1")
    Student findByUserId(String userId);

    @Query("SELECT u FROM first u WHERE u.id1 = ?1")
    List<first> findFromFirstSemester (String userId);

    @Query("SELECT u FROM second u WHERE u.id1 = ?1")
    List<second> findFromSecondSemester (String userId);

    @Query("SELECT u FROM third u WHERE u.id1 = ?1")
    List<third> findFromThirdSemester (String userId);

    @Query("SELECT u FROM fourth u WHERE u.id1 = ?1")
    List<fourth> findFromFourthSemester (String userId);

    @Query("SELECT u FROM fifth u WHERE u.id1 = ?1")
    List<fifth> findFromFifthSemester (String userId);

    @Query("SELECT u FROM sixth u WHERE u.id1 = ?1")
    List<sixth> findFromSixthSemester (String userId);

    @Query("SELECT u FROM seventh u WHERE u.id1 = ?1")
    List<seventh> findFromSeventhSemester (String userId);

    @Query("SELECT u FROM eighth u WHERE u.id1 = ?1")
    List<eighth> findFromEighthSemester (String userId);


    @Query("SELECT u FROM Fees u WHERE u.id1 = ?1")
    List<Fees> findFromFees (String userId);
}
