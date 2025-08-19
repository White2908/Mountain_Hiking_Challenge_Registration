package controller;

import model.Mountain;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Mountains {
    private final List<Mountain> list = new ArrayList<>();

    public void add(Mountain m) {
        if (m != null) {
            list.add(m);
        }
    }

    public Mountain findByCode(String code) {
        if (code == null) return null;
        for (Mountain m : list) {
            if (m.getCode().equalsIgnoreCase(code)) {
                return m;
            }
        }
        return null;
    }


    public List<Mountain> getAll() {
        return new ArrayList<>(list);
    }

    public boolean exists(String code) {
        return findByCode(code) != null;
    }

    public void display() {
        if (list.isEmpty()) {
            System.out.println("No mountain data!!!");
            return;
        }
        System.out.println("Code   | Mountain Name");
        System.out.println("-----------------------");
        for (Mountain m : list) {
            System.out.println(m.getCode() + "  | " + m.getName());
        }
    }

    public void loadFromCSV(String fileName) {
        list.clear();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String code = parts[0].trim();
                    String name = parts[1].trim();
                    list.add(new Mountain(code, name));
                }
            }

            System.out.println("Loaded " + list.size() + " mountains from " + fileName);
        } catch (IOException e) {
            System.out.println("Error reading file " + fileName + ": " + e.getMessage());
        }
    }

    public void clear() {
        list.clear();
    }
}
