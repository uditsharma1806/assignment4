package assignment4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Prescription {
    private int prescID;
    private String firstName;
    private String lastName;
    private String address;
    private float sphere;
    private float axis;
    private float cylinder;
    private Date examinationDate;
    private String optometrist;
    private String[] remarkTypes = { "client", "optometrist" };
    private ArrayList<String> postRemarks = new ArrayList<>();

    // Constructor
    public Prescription(int prescID, String firstName, String lastName, String address, float sphere, float axis,
                        float cylinder, Date examinationDate, String optometrist) {
        this.prescID = prescID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.sphere = sphere;
        this.axis = axis;
        this.cylinder = cylinder;
        this.examinationDate = examinationDate;
        this.optometrist = optometrist;
    }

   





	public boolean addPrescription() {
        // Integrated validation logic for prescription details
        if (firstName.length() >= 4 && firstName.length() <= 15 &&
            lastName.length() >= 4 && lastName.length() <= 15 &&
            address.length() >= 20 &&
            sphere >= -20.00 && sphere <= 20.00 &&
            cylinder >= -4.00 && cylinder <= 4.00 &&
            axis >= 0 && axis <= 180 &&
            optometrist.length() >= 8 && optometrist.length() <= 25) {
                
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("presc.txt", true))) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
                String prescriptionDetails = prescID + ", " + firstName + " " + lastName + ", " + address + ", "
                        + sphere + ", " + axis + ", " + cylinder + ", " + dateFormat.format(examinationDate) + ", "
                        + optometrist;
                writer.write(prescriptionDetails);
                writer.newLine();
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    public boolean addRemark(String remark, String type) {
        // Integrated validation logic for remarks
        String[] words = remark.trim().split("\\s+");
        if (words.length >= 6 && words.length <= 20 &&
            Character.isUpperCase(remark.charAt(0)) &&
            (type.equalsIgnoreCase(remarkTypes[0]) || type.equalsIgnoreCase(remarkTypes[1])) &&
            postRemarks.size() < 2) {
                
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("remark.txt", true))) {
                String remarkEntry = type + ": " + remark;
                writer.write(remarkEntry);
                writer.newLine();
                postRemarks.add(remark);
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

}
