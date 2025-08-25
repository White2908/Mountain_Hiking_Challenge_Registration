import controller.Mountains;
import controller.RegistrationController;
import controller.Students;
import model.Mountain;
import view.MenuView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Mountains mountains = new Mountains();
        mountains.loadFromCSV("resource/MountainList.csv");

        Students students = new Students();
        students.loadFromCSV("resource/StudentList.csv");

        RegistrationController controller = new RegistrationController(students, mountains);

        boolean exit = false;
        while (!exit) {
            System.out.print(MenuView.MAIN_MENU);
            System.out.print(MenuView.ENTER_OPTION);

            String optLine = sc.nextLine().trim();
            if (optLine.isEmpty()) continue;

            int option;
            try {
                option = Integer.parseInt(optLine);
            } catch (NumberFormatException e) {
                System.out.println("Invalid option. Please enter a number.");
                continue;
            }

            switch (option) {
                case 1:
                    controller.Registration();
                    break;
                case 2:
                    System.out.print(MenuView.ENTER_STUDENT_ID);
                    String studentID = sc.nextLine().trim();
                    if (students.exists(studentID)) {
                        controller.updateStudent(students.findById(studentID));
                    } else {
                        System.out.println(MenuView.INVALID_ID);
                    }
                    break;
                case 3:
                    students.display();
                    break;
                case 4:
                    System.out.print(MenuView.ENTER_DELETE_ID);
                    String delId = sc.nextLine().trim();
                    if (students.exists(delId)) {
                        System.out.println(students.findById(delId).toString());
                        System.out.print(MenuView.ENTER_Y_OR_N);
                        if (sc.nextLine().trim().equalsIgnoreCase("Y")) {
                            students.removeById(delId);
                            System.out.println(MenuView.SUCCESS_DELETE);
                            students.display();
                        } else {
                            System.out.println("Canceled.");
                        }
                    } else {
                        System.out.println(MenuView.INVALID_ID);
                    }
                    break;
                case 5:
                    System.out.print(MenuView.ENTER_NAME);
                    String name = sc.nextLine().trim();
                    students.searchByName(name).display();
                    break;
                case 6:
                    System.out.print(MenuView.ENTER_CAMPUS);
                    String campus = sc.nextLine().trim();
                    students.searchByCampus(campus).display();
                    break;
                case 7:
                    mountains.showStatistics(students);
                    break;
                case 8:
                    mountains.saveFromCSV("resource/MountainList.csv");
                    students.saveFromCSV("resource/StudentList.csv");
                    System.out.println(MenuView.SUCCESS_SAVE);
                case 9:
                    break;

                default:
                    System.out.println("Invalid option.");
            }
            System.out.println("Press ENTER to continue.");
            sc.nextLine();
        }
    }
}