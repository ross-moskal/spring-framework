package com.cydeo.bootstrap;

import com.cydeo.entity.Car;
import com.cydeo.repository.CarRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataGenerator implements CommandLineRunner {
    CarRepository carRepository;

    public DataGenerator(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Car c1 = new Car("Honda", "Accord");
        Car c2 = new Car("Hyundai", "Sonata");
        Car c3 = new Car("BMW", "M5");
        carRepository.save(c1);
        carRepository.save(c2);
        carRepository.save(c3);
    }
}
