package controller;

import model.Mountain;
import model.Student;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Students {
    private final List<Student> list = new ArrayList<>();

    public void addStudent(Student s) {
        if (s != null) {
            list.add(s);
        }
    }

    public Student findById(String id) {
        if (id == null) return null;
        for (Student s : list) {
            if (s.getStudentID().equalsIgnoreCase(id)) {
                return s;
            }
        }
        return null;
    }

    public boolean exists(String id) {
        return findById(id) != null;
    }

    public boolean removeById(String id) {
        Student s = findById(id);
        if (s != null) {
            list.remove(s);
            return true;
        }
        return false;
    }

    public List<Student> searchByName(String keyword) {
        List<Student> result = new ArrayList<>();
        if (keyword == null || keyword.isEmpty()) return result;

        String kw = keyword.toLowerCase();
        for (Student s : list) {
            if (s.getName().toLowerCase().contains(kw)) {
                result.add(s);
            }
        }
        return result;
    }

    public List<Student> getAll() {
        return new ArrayList<>(list);
    }

    public void display() {
        if (list.isEmpty()) {
            System.out.println("No student data available.");
            return;
        }

        System.out.println("-----------------------------------------------------------------------------------------------------------");
        for (Student s : list) {
            System.out.println(String.format("%-7s | %-15s | %-13s | %-23s | %-9s| %.0f",
                    s.getStudentID(),
                    s.getName(),
                    s.getPhoneNumber(),
                    s.getEmail(),
                    s.getMountainCode(),
                    s.getTuitionFee()));
        }
    }


    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void clear() {
        list.clear();
    }

    public void loadFromCSV(String fileName) {
        list.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 6) {
                    String studentID = parts[0].trim();
                    String name = parts[1].trim();
                    String phoneNumber = parts[2].trim();
                    String email = parts[3].trim();
                    String mountainCode = parts[4].trim();
                    double tuitionFee = Double.parseDouble(parts[5].trim());
                    list.add(new Student(studentID, name, phoneNumber, email, mountainCode, tuitionFee));
                } else {
                    System.out.println("Skipped invalid line: " + line);
                }
            }
            System.out.println("Loaded " + list.size() + " students from " + fileName);
        } catch (IOException e) {
            System.out.println("Error reading file " + fileName + ": " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error parsing tuition fee: A non-numeric value was found.");
        }
    }
}
