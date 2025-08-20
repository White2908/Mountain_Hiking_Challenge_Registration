package view;

public class MenuView {
    public static final String MAIN_MENU =
            "\n=============    MOUNTAIN HIKING   ============\n" +
                    "1. New Registration\n" +
                    "2. Update Registration Information\n" +
                    "3. Display Registered List\n" +
                    "4. Delete Registration Information\n" +
                    "5. Search Participants by Name\n" +
                    "6. Filter Data by Campus\n" +
                    "7. Statistics of Registration Numbers by Location\n" +
                    "8. Save Data to File\n" +
                    "9. Exit Program\n" +
            "===============================================\n";

    public static final String ENTER_OPTION        = "Enter your option: ";
    public static final String ENTER_Y_OR_N        = "Enter 'Y' or 'N': ";
    public static final String ENTER_CAMPUS        = "Enter a campus code (CE, DE, HE, SE, QE): ";

    public static final String ENTER_STUDENT_ID    = "Enter student ID: ";
    public static final String ENTER_NAME          = "Enter student name: ";
    public static final String ENTER_PHONE         = "Enter phone number: ";
    public static final String ENTER_EMAIL         = "Enter student email: ";
    public static final String ENTER_MOUNTAIN_CODE = "Enter mountain code: ";
    public static final String ENTER_DELETE_ID     = "Enter student ID to delete: ";
    public static final String ENTER_KEYWORD       = "Enter keyword (name): ";

    public static final String INVALID_INPUT       = "Invalid input, please try again.\n";
    public static final String INVALID_CODE        = "Invalid mountain code, please try again.\n";
    public static final String INVALID_ID          = "Invalid student ID, please try again.\n";
    public static final String INVALID_EMAIL       = "Invalid email, please try again.\n";
    public static final String INVALID_PHONE       = "Invalid phone number, please try again.\n";
    public static final String INVALID_NAME        = "Invalid name, please try again.\n";
    public static final String INVALID_MOUNTAIN    = "Invalid mountain, please try again.\n";
    public static final String DUPLICATE_ID        = "Student ID already exists!\n";
    public static final String NOT_FOUND           = "package controller;\n";

    public static final String SUCCESS_ADD         = "Registration added successfully!\n";
    public static final String SUCCESS_UPDATE      = "Registration updated successfully!\n";
    public static final String SUCCESS_DELETE      = "Registration deleted successfully!\n";
    public static final String SUCCESS_SEARCH      = "Search results: \n";
    public static final String SUCCESS_SAVE        = "Data saved successfully!\n";
    public static final String SUCCESS_EXIT        = "Exiting program...\n";
}
