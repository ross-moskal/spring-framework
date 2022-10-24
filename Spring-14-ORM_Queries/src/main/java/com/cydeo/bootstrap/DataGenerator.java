package com.cydeo.bootstrap;

import com.cydeo.entity.Region;
import com.cydeo.repository.CourseRepository;
import com.cydeo.repository.DepartmentRepository;
import com.cydeo.repository.EmployeeRepository;
import com.cydeo.repository.RegionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataGenerator implements CommandLineRunner {
    private RegionRepository regionRepository;
    private DepartmentRepository departmentRepository;
    private EmployeeRepository employeeRepository;
    private CourseRepository courseRepository;

    public DataGenerator(RegionRepository regionRepository, DepartmentRepository departmentRepository, EmployeeRepository employeeRepository, CourseRepository courseRepository) {
        this.regionRepository = regionRepository;
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("------------------ START --------------------");
        System.out.println("findByCountry: " + regionRepository.findByCountry("Canada"));

        System.out.println("findDistinctByCountry: " + regionRepository.findDistinctByCountry("Canada"));

        System.out.println("findByCountryContaining: " + regionRepository.findByCountryContaining("United"));

        System.out.println("findByCountryContainingOrderByCountry: " + regionRepository.findByCountryContainingOrderByCountry("Asia"));

        System.out.println("findTop2ByCountry: " + regionRepository.findTop2ByCountry("Canada"));

        System.out.println("------------------ END --------------------");

        System.out.println("------------------ START --------------------");

        System.out.println("findByDepartment: " + departmentRepository.findByDepartment("Toys"));

        System.out.println("findByDivisionIs: " + departmentRepository.findByDivisionIs("Outdoors"));

        System.out.println("findDistinctTop3ByDivisionContaining: " + departmentRepository.findDistinctTop3ByDivisionContaining("Hea"));

        System.out.println("------------------ END --------------------");

        System.out.println("------------------ START --------------------");

        System.out.println("getEmployeeDetail: " + employeeRepository.getEmployeeDetail());

        System.out.println("getEmployeeDetail: " + employeeRepository.getEmployeeDetail("sdubber7@t-online.de"));

        System.out.println("------------------ END --------------------");

        System.out.println("------------------ START --------------------");

        System.out.println("existsByName: " + courseRepository.existsByName("JavaScript"));

        courseRepository.streamByCategory("Spring").forEach(System.out::println);

        System.out.println("------------------ END --------------------");
    }
}
