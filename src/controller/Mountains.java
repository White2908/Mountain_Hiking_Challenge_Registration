package controller;

import model.Mountain;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Mountains {
    private final List<Mountain> list = new ArrayList<>();
    private RegistrationController controller;

    //Add mountainCode unlock if needed
    public void add(Mountain m) {
        if (m != null) {
            list.add(m);
        }
    }

    //Find mountainCode
    public Mountain findByCode(String code) {
        if (code == null) return null;
        for (Mountain m : list) {
            if (m.getCode().equalsIgnoreCase(code)) {
                return m;
            }
        }
        return null;
    }

    //Check MountainCode
    public boolean checkExists(String code) {
        return findByCode(code) == null;
    }

    //Function 7
    public void showStatistics(Students s) {
        int total = 0;
        float cost = 0;
        if (list.isEmpty()) {
            System.out.println("No data!!!");
            return;
        }

        System.out.println("Peak Name   | Number of Participants | Total Cost");
        System.out.println("-------------------------------------------------");
        for(Mountain m : list){
            Students byMountain = s.searchByMountain(m.getCode());
            byMountain.display();

            if(!byMountain.isEmpty()){
                total = byMountain.size();
                cost = byMountain.totalTuitionFee();
                System.out.println(m.getCode() + "  | " + total + "  | " + cost);
            }
        }

    }

    //Showcase mountainCode
    public void display() {
        if (list.isEmpty()) {
            System.out.println("No mountain data!!!");
            return;
        }
        System.out.println("Code ");
        System.out.println("-----------------------");
        for (Mountain m : list) {
            System.out.println(m.getCode());
        }
    }

    //Load file MountainList.csv
    public void loadFromCSV(String fileName) {
        list.clear();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = br.readLine()) != null) {
                String code = line.trim();
                list.add(new Mountain(code));
                if (code.isEmpty()) continue;
            }

            System.out.println("Loaded " + list.size() + " mountains from " + fileName);
        } catch (IOException e) {
            System.out.println("Error reading file " + fileName + ": " + e.getMessage());
        }
    }

    //Save file MountainList.csv
    public void saveFromCSV(String fileName){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))){
            for(Mountain m : list){
                bw.write(m.getCode());
                bw.newLine();
            }
        }catch(IOException e){
            System.out.println("Error writing file " + fileName + ": " + e.getMessage());
        }
    }
}
