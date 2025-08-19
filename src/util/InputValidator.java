package util;

import java.util.Map;
import controller.Students;

public class InputValidator {

    public static boolean validStudentId(String studentID) {
        return studentID != null && studentID.matches("^(SE|HE|DE|QE|CE)\\d{6}$");
    }

    public static boolean validName(String name) {
        return name != null && name.trim().length() >= 2 && name.trim().length() <= 20;
    }

    public static boolean validPhone(String phone) {
        return phone != null && phone.matches("^0\\d{9}$");
    }

    public static boolean validEmail(String email) {
        return email != null && email.matches("^[\\w._%+-]+@[\\w.-]+\\.[A-Za-z]{2,6}$");
    }

    public static boolean validMountainCode(String code) {
        return code != null;
    }

    public static double validCalculateTuition(String phone) {
        double fee = 6000000;
        if (phone.startsWith("098") || phone.startsWith("097") || phone.startsWith("096")
                || phone.startsWith("091") || phone.startsWith("094")) {
            fee *= 0.65;
        }
        return fee;
    }
}
