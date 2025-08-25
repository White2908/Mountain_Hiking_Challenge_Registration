package controller;

import model.Mountain;
import model.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Students {
    private final List<Student> list = new ArrayList<>();

    //Add Student to list
    public void addStudent(Student s) {
        if (s != null) {
            list.add(s);
        }
    }

    //Find Student by ID
    public Student findById(String id) {
        if (id == null) return null;
        for (Student s : list) {
            if (s.getStudentID().equalsIgnoreCase(id)) {
                return s;
            }
        }
        return null;
    }

    //Check if Student exists
    public boolean exists(String id) {
        return findById(id) != null;
    }

    //Function 4
    public boolean removeById(String id) {
        Student s = findById(id);
        if (s != null) {
            list.remove(s);
            return true;
        }
        return false;
    }

    //Function 5
    public Students searchByName(String keyword) {
        Students result = new Students();
        if (keyword == null || keyword.isEmpty()) return result;

        String kw = keyword.toLowerCase();
        for (Student s : list) {
            if (s.getName().toLowerCase().contains(kw)){
                result.addStudent(s);
            }
        }
        return result;
    }

    public Students searchByCampus(String campus) {
        Students result = new Students();
        if (campus == null || campus.isEmpty()) return result;

        String camp = campus.toLowerCase();
        for (Student s : list) {
            if (s.getStudentID().toLowerCase().contains(camp)){
                result.addStudent(s);
            }
        }
        return result;
    }

    //Search Student by MountainCode
    public Students searchByMountain(String m) {
        Students result = new Students();
        if (m == null || m.isEmpty()) return result;

        String mCode = m.toLowerCase();
        for (Student s : list) {
            if (s.getMountainCode().toLowerCase().contains(mCode)){
                result.addStudent(s);
            }
        }
        return result;
    }

    //Showcase students list
    public void display() {
        if (list.isEmpty()) {
            System.out.println("No student data available.");
            return;
        }

        System.out.println("---------------------------------------------------------------------------------------------------------------------");
        System.out.println("Student ID | Name                 | Phone Number  | Email                           | Mountain Code  | Tuition Fee        ");
        for (Student s : list) {
            System.out.println(String.format("%-10s | %-20s | %-13s | %-31s | %-15s| %.0f",
                    s.getStudentID(),
                    s.getName(),
                    s.getPhoneNumber(),
                    s.getEmail(),
                    s.getMountainCode(),
                    s.getTuitionFee()));
        }
    }

    //Calculate total fee
    public float totalTuitionFee(){
        float total = 0;
        for(Student stu : list){
            total += stu.getTuitionFee();
        }
        return total;
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    //Load file StudentsList.csv
    public void loadFromCSV(String fileName) {
        list.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            int lineNumber = 0;
            br.readLine(); // Skip header

            while ((line = br.readLine()) != null) {
                lineNumber++;
                if (line.trim().isEmpty()) continue;

                String[] parts = line.split(",");
                if (parts.length != 6) {
                    System.out.println("Line " + lineNumber + ": Invalid number of fields: " + line);
                    continue;
                }

                try {
                    String studentID = parts[0].trim();
                    String name = parts[1].trim();
                    String phoneNumber = parts[2].trim();
                    String email = parts[3].trim();
                    String mountainCode = parts[4].trim();
                    double tuitionFee = Double.parseDouble(parts[5].trim());

                    if (studentID.isEmpty() || name.isEmpty() || phoneNumber.isEmpty()
                            || email.isEmpty() || mountainCode.isEmpty()) {
                        System.out.println("Line " + lineNumber + ": Required field(s) missing");
                        continue;
                    }

                    list.add(new Student(studentID, email, phoneNumber, name, mountainCode, tuitionFee));
                } catch (NumberFormatException e) {
                    System.out.println("Line " + lineNumber + ": Invalid tuition fee format");
                }
            }
            System.out.println("Successfully loaded " + list.size() + " students from " + fileName);
        } catch (IOException e) {
            System.out.println("Error reading file " + fileName + ": " + e.getMessage());
        }
    }

    //Save file StudentsList.csv
    public void saveFromCSV(String fileName){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))){
            for(Student s : list){
                bw.write(s.getStudentID() + "," + s.getName() + "," + s.getPhoneNumber() + "," + s.getEmail() + "," + s.getMountainCode() + "," + s.getTuitionFee());
                bw.newLine();
            }
        }catch(IOException e){
            System.out.println("Error writing file " + fileName + ": " + e.getMessage());
        }
    }
}
