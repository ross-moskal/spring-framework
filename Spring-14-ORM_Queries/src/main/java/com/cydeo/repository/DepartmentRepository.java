package com.cydeo.repository;

import com.cydeo.entity.Department;
import com.cydeo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, String> {
    List<Department> findByDepartment(String department);

    List<Department> findByDivisionIs(String string);
    //    List<Department> findByDivision(String string);
    //    List<Department> findByDivisionEquals(String string);

    List<Department> findDistinctTop3ByDivisionContaining(String division);

    @Query("select d from Department d where d.division in ?1")
    List<Department> getDepartmentDivision(List<String> division);

    List<Department> retrieveDepartmentByDivision(String division);

    @Query(nativeQuery = true)
    List<Department> retrieveDepartmentByDivisionContain(String pattern);
}
