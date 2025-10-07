package validator;

import java.time.Year;

public class Validator {

    public static boolean isValidID(String id) {
        return id != null && id.matches("\\d{6}");
    }

    public static boolean isValidFullName(String name) {
        return name != null && name.matches("[a-zA-Z ]+");
    }

    public static boolean isValidPhone(String phone) {
        return phone != null && phone.matches("\\d{12}");
    }

    public static boolean isValidYearOfBirth(int year) {
        int currentYear = Year.now().getValue();
        return year > 1900 && year < currentYear;
    }

    public static boolean isValidMajor(String major) {
        return major != null && major.length() <= 30;
    }

    public static boolean isValidYearInProfession(int yearInProfession, int yearOfBirth) {
        int currentYear = Year.now().getValue();
        int age = currentYear - yearOfBirth;
        return yearInProfession >= 0 && yearInProfession < age;
    }

    public static boolean isValidContractType(String type) {
        return type != null && (type.equalsIgnoreCase("Long") || type.equalsIgnoreCase("Short"));
    }

    public static boolean isValidSalaryCoefficient(double coef) {
        return coef >= 0;
    }

    public static boolean isValidYearOfAdmission(int yearOfAdmission, int yearOfBirth) {
        int currentYear = Year.now().getValue();
        return yearOfAdmission >= yearOfBirth && yearOfAdmission <= currentYear;
    }

    public static boolean isValidEnglishScore(int score) {
        return score >= 0 && score <= 100;
    }
}
