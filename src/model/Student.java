package model;

public class Student {
    private String studentID;
    private String name;
    private String phoneNumber;
    private String email;
    private String mountainCode;
    private double tuitionFee;

    public Student() {
    }

    public Student(String studentID, String email, String phoneNumber, String name, String mountainCode, double tuitionFee) {
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
        return String.format("%s | %s | %s | %s | %s | %.0f",
                studentID, name, phoneNumber, email, mountainCode, tuitionFee);
    }
}
