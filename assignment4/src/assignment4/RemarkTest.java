package assignment4;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

public class RemarkTest {

    // Test cases for addRemark()
    @Test
    public void testAddRemarkValidRemarkClient() {
        Prescription prescription = new Prescription(1, "John", "Doem", "1234 Elm Street, Apt 5, Cityville", -2.50f, 90, -1.75f, new Date(), "Dr. Smith");
        assertTrue(prescription.addRemark("This is a valid client remark", "client"));
    }

    @Test
    public void testAddRemarkValidRemarkOptometrist() {
        Prescription prescription = new Prescription(1, "John", "Doem", "1234 Elm Street, Apt 5, Cityville", -2.50f, 90, -1.75f, new Date(), "Dr. Smith");
        assertTrue(prescription.addRemark("This is a valid optometrist remark", "optometrist"));
    }

    @Test
    public void testAddRemarkInvalidRemarkTooShort() {
        Prescription prescription = new Prescription(1, "John", "Doem", "1234 Elm Street, Apt 5, Cityville", -2.50f, 90, -1.75f, new Date(), "Dr. Smith");
        assertFalse(prescription.addRemark("Short", "client"));
    }

  

    @Test
    public void testAddRemarkInvalidRemarkNoCapitalization() {
        Prescription prescription = new Prescription(1, "John", "Doem", "1234 Elm Street, Apt 5, Cityville", -2.50f, 90, -1.75f, new Date(), "Dr. Smith");
        assertFalse(prescription.addRemark("this remark has no capital with enough words", "optometrist"));
    }

    @Test
    public void testAddRemarkInvalidTypeNotInList() {
        Prescription prescription = new Prescription(1, "John", "Doem", "1234 Elm Street, Apt 5, Cityville", -2.50f, 90, -1.75f, new Date(), "Dr. Smith");
        assertFalse(prescription.addRemark("Valid remark with enough words as required", "invalidType"));
    }

    @Test
    public void testAddRemarkValidWithMaxWords() {
        Prescription prescription = new Prescription(1, "John", "Doem", "1234 Elm Street, Apt 5, Cityville", -2.50f, 90, -1.75f, new Date(), "Dr. Smith");
        String maxWordsRemark = "This remark has exactly the maximum twenty word limit for the validation requirement to test edge case.";
        assertTrue(prescription.addRemark(maxWordsRemark, "client"));
    }

    @Test
    public void testAddRemarkMultipleRemarksValid() {
        Prescription prescription = new Prescription(1, "John", "Doem", "1234 Elm Street, Apt 5, Cityville", -2.50f, 90, -1.75f, new Date(), "Dr. Smith");
        assertTrue(prescription.addRemark("First valid remark with enough words", "client"));
        assertTrue(prescription.addRemark("Second valid remark with enough words", "optometrist"));
    }

    @Test
    public void testAddRemarkExceedsRemarkLimit() {
        Prescription prescription = new Prescription(1, "John", "Doem", "1234 Elm Street, Apt 5, Cityville", -2.50f, 90, -1.75f, new Date(), "Dr. Smith");
        prescription.addRemark("First valid remark with enough words", "client");
        prescription.addRemark("Second valid remark with enough words", "optometrist");
        assertFalse(prescription.addRemark("Third valid remark with enough words", "client"));
    }
    @Test
    public void testAddRemarkInvalidRemarkTypeLowercase() {
        Prescription prescription = new Prescription(1, "John", "Doe", "1234 Elm Street, Apt 5, Cityville", -2.50f, 90, -1.75f, new Date(), "Dr. Smith");
        assertFalse(prescription.addRemark("This is a valid remark format", "clientt"));
    }

    @Test
    public void testAddRemarkInvalidRemarkTypeUppercase() {
        Prescription prescription = new Prescription(1, "John", "Doe", "1234 Elm Street, Apt 5, Cityville", -2.50f, 90, -1.75f, new Date(), "Dr. Smith");
        assertFalse(prescription.addRemark("This is a valid remark format", "OPTOMETRISTT"));
    }

    @Test
    public void testAddRemarkOnlyWhitespace() {
        Prescription prescription = new Prescription(1, "John", "Doe", "1234 Elm Street, Apt 5, Cityville", -2.50f, 90, -1.75f, new Date(), "Dr. Smith");
        assertFalse(prescription.addRemark("      ", "client"));
    }

   

    @Test
    public void testAddRemarkValidOptometristRemarkWithMixedCase() {
        Prescription prescription = new Prescription(1, "John", "Doe", "1234 Elm Street, Apt 5, Cityville", -2.50f, 90, -1.75f, new Date(), "Dr. Smith");
        assertTrue(prescription.addRemark("Optometrist’s Remark With Mixed Case with enough words.", "Optometrist"));
    }

    @Test
    public void testAddRemarkExactlySixWords() {
        Prescription prescription = new Prescription(1, "John", "Doe", "1234 Elm Street, Apt 5, Cityville", -2.50f, 90, -1.75f, new Date(), "Dr. Smith");
        assertTrue(prescription.addRemark("This is exactly six word remark", "client"));
    }

    @Test
    public void testAddRemarkExactlyTwentyWords() {
        Prescription prescription = new Prescription(1, "John", "Doe", "1234 Elm Street, Apt 5, Cityville", -2.50f, 90, -1.75f, new Date(), "Dr. Smith");
        assertTrue(prescription.addRemark("This remark contains exactly twenty words to test the upper word limit in the validation of the add remark method.", "optometrist"));
    }
}
