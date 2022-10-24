package com.cydeo.repository;

import com.cydeo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByEmail(String email);

    List<Employee> findByFirstNameAndLastNameOrEmail(String firstName, String lastName, String email);

    List<Employee> findByFirstNameIsNot(String firstName);

    List<Employee> findByLastNameStartingWith(String lastName);

    List<Employee> findBySalaryGreaterThan(Integer salary);

    List<Employee> findByHireDateBetween(LocalDate startDate, LocalDate endDate);

    List<Employee> findBySalaryIsGreaterThanEqualOrderBySalaryDesc(Integer salary);

    List<Employee> findDistinctTop3BySalaryLessThan(Integer salary);

    List<Employee> findByEmailIsNull();

    @Query("SELECT e from Employee e where e.email = 'sdubber7@t-online.de'")
    Employee getEmployeeDetail();

    @Query("select e.salary from Employee  e where e.email = 'sdubber7@t-online.de'")
    Integer getEmployeeSalary();

    @Query("select e from Employee e where e.email=?1")
    Optional<Employee> getEmployeeDetail(String email);

    @Query("select e from Employee e where e.email=?1 and e.salary=?2")
    Employee getEmployeeDetail(String email, int salary);

    @Query("select e from Employee e where e.salary <> ?1")
    List<Employee> getEmployeeSalaryNotEqual(int salary);

    @Query("select e from Employee e where e.firstName like ?1")
    List<Employee> getEmployeeFirstNameLike(String pattern);

    @Query(value = "select * from Employee where salary = ?1", nativeQuery = true)
    List<Employee> readEmployeeDetailBySalary(int salary);
    @Query("select e from Employee e where e.salary = :salary")
    List<Employee> getEmployeeSalary(@Param("salary") int salary);
    @Modifying
    @Transactional
    @Query("update Employee e set e.email = 'admin@email.com' where e.id = :id")
    void updateEmployeeJPQL(@Param("id") int id);
}
