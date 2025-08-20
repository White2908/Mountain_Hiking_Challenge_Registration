package controller;

import model.Student;
import util.InputValidator;
import view.MenuView;

import java.util.Scanner;

public class RegistrationController {
    private Students list = null;
    private Mountains listM = null;

    public RegistrationController(Students students, Mountains mountains) {
        this.list = students;
        this.listM = mountains;
    }

    //Function 1
    public void Registration(){
        Scanner sc = new Scanner(System.in);
        String studentID;
        String name;
        String phoneNumber;
        String email;
        String mountainCode;
        double tuitionFee;

        // ---- ID ----
        while(true){
            System.out.print(MenuView.ENTER_STUDENT_ID);
            studentID = sc.nextLine();

            if(!InputValidator.validStudentId(studentID)){
                System.out.println(MenuView.INVALID_INPUT);
                continue;
            }

            if (list.exists(studentID)) {
                System.out.println(MenuView.DUPLICATE_ID);
                continue;
            }

                break;
        }

        // ---- Name ----
        while(true){
            System.out.print(MenuView.ENTER_NAME);
            name = sc.nextLine();

            if(!InputValidator.validName(name)){
                System.out.println(MenuView.INVALID_INPUT);
                continue;
            }

            break;
        }

        // ---- Phone ----
        while (true) {
            System.out.print(MenuView.ENTER_PHONE);
            phoneNumber = sc.nextLine();
            if (InputValidator.validPhone(phoneNumber)) {
                break;
            }
            System.out.println(MenuView.INVALID_INPUT);
        }

        // ---- Mail ----
        while (true) {
            System.out.print(MenuView.ENTER_EMAIL);
            email = sc.nextLine();
            if (InputValidator.validEmail(email)) {
                break;
            }
            System.out.println(MenuView.INVALID_INPUT);
        }

        // ---- Code ----
        while (true){
            System.out.print(MenuView.ENTER_MOUNTAIN_CODE);
            mountainCode = sc.nextLine();

            if(!InputValidator.validMountainCode(mountainCode)){
                System.out.println(MenuView.INVALID_INPUT);
                continue;
            }

            if (listM.checkExists(mountainCode)) {
                System.out.println(MenuView.INVALID_CODE);
                listM.display();
                continue;
            }

            break;
        }
        tuitionFee = InputValidator.validCalculateTuition(phoneNumber);

        Student student = new Student(studentID, name, phoneNumber, email, mountainCode, tuitionFee);
        list.addStudent(student);

        System.out.println(MenuView.SUCCESS_ADD);
    }

    //Function 2
    public void updateStudent(Student s) {
        Scanner sc = new Scanner(System.in);
        String input;

        // ---- Name ----
        System.out.print("Enter new name (Press Enter to keep: " + s.getName() + "): ");
        input = sc.nextLine();
        if (!input.trim().isEmpty()) {
            s.setName(input);
        }

        // ---- Phone ----
        while (true) {
            System.out.print("Enter new phone (Press Enter to keep: " + s.getPhoneNumber() + "): ");
            input = sc.nextLine();
            if (input.trim().isEmpty()) {
                break; // keep old phone
            }
            if (InputValidator.validPhone(input)) {
                s.setPhoneNumber(input);
                break;
            }
            System.out.println(MenuView.INVALID_INPUT);
        }

        // ---- Email ----
        while (true) {
            System.out.print("Enter new email (Press Enter to keep: " + s.getEmail() + "): ");
            input = sc.nextLine();
            if (input.trim().isEmpty()) {
                break; // keep old email
            }
            if (InputValidator.validEmail(input)) {
                s.setEmail(input);
                break;
            }
            System.out.println(MenuView.INVALID_INPUT);
        }

        // ---- Mountain Code ----
        while (true) {
            System.out.print("Enter new mountain code (Press Enter to keep: " + s.getMountainCode() + "): ");
            input = sc.nextLine();
            if (input.trim().isEmpty()) {
                break; // keep old code
            }
            if (!InputValidator.validMountainCode(input)) {
                System.out.println(MenuView.INVALID_INPUT);
                continue;
            }
            if (listM.checkExists(input)) {
                System.out.println(MenuView.INVALID_CODE);
                listM.display();
                continue;
            }
            s.setMountainCode(input);
            break;
        }

        // ---- Tuition fee (recalculate if needed) ----
        s.setTuitionFee(InputValidator.validCalculateTuition(s.getPhoneNumber()));

        System.out.println(MenuView.SUCCESS_UPDATE);
    }

}
