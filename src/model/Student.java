package model;

public class Student {
    private String studentID;
    private String name;
    private String phoneNumber;
    private String email;
    private String mountainCode;
    private double tuitionFee = 6000000.00;

    public Student() {
    }

    public Student(String studentID, String name, String phoneNumber,String email, String mountainCode, double tuitionFee) {
        this.studentID = studentID;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.mountainCode = mountainCode;
        this.tuitionFee = tuitionFee;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getMountainCode() {
        return mountainCode;
    }

    public double getTuitionFee() {
        return tuitionFee;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMountainCode(String mountainCode) {
        this.mountainCode = mountainCode;
    }

    public void setTuitionFee(double tuitionFee) {
        this.tuitionFee = tuitionFee;
    }

    @Override
    public String toString() {
        return String.format("Student ID: %s\n" +
                             "Name      : %s\n" +
                             "Phone     : %s\n" +
                             "Email     : %s\n" +
                             "Mountain  : %s\n" +
                             "Tuition   : %.2f\n",

                studentID, name, phoneNumber, email, mountainCode, tuitionFee);
    }

    public String toCSV() {
        return String.format("%s | %s | %s | %s | %.2f\n" +
                studentID, name, phoneNumber, mountainCode, tuitionFee);
    }
}

