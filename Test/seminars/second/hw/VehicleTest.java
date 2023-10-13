package seminars.second.hw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

class VehicleTest {
    Car car;
    Motorcycle moto;

    @BeforeEach
    void setUp() {
        car = new Car("Dodge", "Ram", 2010);
        moto = new Motorcycle("Ural", "IMZ-72", 1992);
    }

    @Test
    public void testCarIsInstanceOfVehicle() {
        assertTrue(car instanceof Vehicle);
    }

    @Test
    public void testMotoIsInstanceOfVehicle() {
        assertTrue(moto instanceof Vehicle);
    }

    @Test
    public void testCarHasFourWheels() {
        assertThat(car.getNumWheels()).isEqualTo(4);
    }

    @Test
    public void testMotoHasTwoWheels() {
        assertThat(moto.getNumWheels()).isEqualTo(2);
    }

    @Test
    public void testCarSpeed() {
        car.testDrive();
        assertThat(car.getSpeed()).isEqualTo(60);
    }

    @Test
    public void testMotoSpeed() {
        moto.testDrive();
        assertThat(moto.getSpeed()).isEqualTo(75);
    }

    @Test
    public void testCarParking() {
        car.testDrive();
        car.park();
        assertThat(car.getSpeed()).isEqualTo(0);
    }

    @Test
    public void testMotoParking() {
        moto.testDrive();
        moto.park();
        assertThat(moto.getSpeed()).isEqualTo(0);
    }
}