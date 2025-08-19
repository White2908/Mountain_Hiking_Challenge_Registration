import controller.Mountains;
import controller.RegistrationController;
import controller.Students;
import model.Mountain;
import view.MenuView;
import view.RegistrationView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int option = 0;
        Mountains mountains = new Mountains();
        mountains.loadFromCSV("resource/MountainList.csv");
        mountains.display();

        Students students = new Students();
        students.loadFromCSV("resource/StudentList.csv");
        students.display();

        RegistrationController controller = new RegistrationController(students, mountains);

        boolean exit = false;
        while(exit == false){
            System.out.print(MenuView.MAIN_MENU);
            System.out.print(MenuView.ENTER_OPTION);
            option = sc.nextInt();
            switch (option){
                case 1:
                    controller.Registration();
                    students.display();
                case 2:
            }
            sc.nextLine();
        }

    }
}
