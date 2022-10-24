package com.cydeo.repository;

import com.cydeo.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, String> {
    List<Department> findByDepartment(String department);

    List<Department> findByDivisionIs(String string);
    //    List<Department> findByDivision(String string);
    //    List<Department> findByDivisionEquals(String string);

    List<Department> findDistinctTop3ByDivisionContaining(String division);


}
