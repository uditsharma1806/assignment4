package assignment4;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;

public class PrescriptionTest {

    // Test cases for addPrescription()
    @Test
    public void testAddPrescriptionValidData() {
    	Prescription presc = new Prescription(1, "John", "Doem", "1234 Elm Street, Apt 5, Cityville", -2.50f, 90, -1.75f, new Date(), "Dr. Smith");
        assertTrue(presc.addPrescription());
    }

    @Test
    public void testAddPrescriptionInvalidFirstNameShort() {
        Prescription prescription = new Prescription(1, "Jon", "Doe", "1234 Elm Street, Apt 5, Cityville", -2.50f, 90, -1.75f, new Date(), "Dr. Smith");
        assertFalse(prescription.addPrescription());
    }

    @Test
    public void testAddPrescriptionInvalidFirstNameLong() {
        Prescription prescription = new Prescription(1, "Jonathanathanathan", "Doe", "1234 Elm Street, Apt 5, Cityville", -2.50f, 90, -1.75f, new Date(), "Dr. Smith");
        assertFalse(prescription.addPrescription());
    }

    @Test
    public void testAddPrescriptionInvalidLastNameShort() {
        Prescription prescription = new Prescription(1, "John", "Do", "1234 Elm Street, Apt 5, Cityville", -2.50f, 90, -1.75f, new Date(), "Dr. Smith");
        assertFalse(prescription.addPrescription());
    }

    @Test
    public void testAddPrescriptionInvalidLastNameLong() {
        Prescription prescription = new Prescription(1, "John", "Doethanathanathan", "1234 Elm Street, Apt 5, Cityville", -2.50f, 90, -1.75f, new Date(), "Dr. Smith");
        assertFalse(prescription.addPrescription());
    }

    @Test
    public void testAddPrescriptionInvalidAddressShort() {
        Prescription prescription = new Prescription(1, "John", "Doe", "123 Main St", -2.50f, 90, -1.75f, new Date(), "Dr. Smith");
        assertFalse(prescription.addPrescription());
    }

    @Test
    public void testAddPrescriptionInvalidSphereLowBoundary() {
        Prescription prescription = new Prescription(1, "John", "Doe", "1234 Elm Street, Apt 5, Cityville", -20.01f, 90, -1.75f, new Date(), "Dr. Smith");
        assertFalse(prescription.addPrescription());
    }

    @Test
    public void testAddPrescriptionInvalidSphereHighBoundary() {
        Prescription prescription = new Prescription(1, "John", "Doe", "1234 Elm Street, Apt 5, Cityville", 20.01f, 90, -1.75f, new Date(), "Dr. Smith");
        assertFalse(prescription.addPrescription());
    }

    @Test
    public void testAddPrescriptionInvalidCylinderLowBoundary() {
        Prescription prescription = new Prescription(1, "John", "Doe", "1234 Elm Street, Apt 5, Cityville", -2.50f, 90, -4.01f, new Date(), "Dr. Smith");
        assertFalse(prescription.addPrescription());
    }

    @Test
    public void testAddPrescriptionInvalidCylinderHighBoundary() {
        Prescription prescription = new Prescription(1, "John", "Doe", "1234 Elm Street, Apt 5, Cityville", -2.50f, 90, 4.01f, new Date(), "Dr. Smith");
        assertFalse(prescription.addPrescription());
    }

    @Test
    public void testAddPrescriptionInvalidAxisLowBoundary() {
        Prescription prescription = new Prescription(1, "John", "Doe", "1234 Elm Street, Apt 5, Cityville", -2.50f, -1, -1.75f, new Date(), "Dr. Smith");
        assertFalse(prescription.addPrescription());
    }

    @Test
    public void testAddPrescriptionInvalidAxisHighBoundary() {
        Prescription prescription = new Prescription(1, "John", "Doe", "1234 Elm Street, Apt 5, Cityville", -2.50f, 181, -1.75f, new Date(), "Dr. Smith");
        assertFalse(prescription.addPrescription());
    }

    @Test
    public void testAddPrescriptionValidWithMaxValues() {
        Prescription prescription = new Prescription(1, "Johnathan", "Doeenough", "1234 Elm Street, Apt 5, Cityville, Somecountry", 20.00f, 180, 4.00f, new Date(), "Dr. Smithfieldfieldfield");
        assertTrue(prescription.addPrescription());
    }

    @Test
    public void testAddPrescriptionInvalidOptometristShort() {
        Prescription prescription = new Prescription(1, "John", "Doe", "1234 Elm Street, Apt 5, Cityville", -2.50f, 90, -1.75f, new Date(), "Dr. S");
        assertFalse(prescription.addPrescription());
    }

    @Test
    public void testAddPrescriptionInvalidOptometristLong() {
        Prescription prescription = new Prescription(1, "John", "Doe", "1234 Elm Street, Apt 5, Cityville", -2.50f, 90, -1.75f, new Date(), "Dr. Smithfieldfieldfieldfieldfield");
        assertFalse(prescription.addPrescription());
    }

    @Test
    public void testAddPrescriptionValidWithMinimumValues() {
        Prescription prescription = new Prescription(1, "John", "Doem", "1234 Elm Street, Apt 5, Cityville, Longaddress", -20.00f, 0, -4.00f, new Date(), "Dr. Optometry");
        assertTrue(prescription.addPrescription());
    }
}
