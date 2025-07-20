package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import view.ListView;
import view.Validation;

public class CourseList {
    private final ArrayList<Course> allCourses = new ArrayList<>();

    public CourseList() {
        loadCoursesFromFile("course.txt");
    }

    private void loadCoursesFromFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 4) {
                    allCourses.add(new Course(parts[0].trim(), parts[1].trim(), parts[2].trim(), parts[3].trim()));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Course> getAllCourses() {
        return allCourses;
    }

    public Course getCourseById(String id) {
        return allCourses.stream()
                .filter(c -> c.getCourseId().equals(id.trim()))
                .findFirst().orElse(null);
    }

    public void display() {
        ListView.listAll(allCourses);
    }
    public ArrayList<Course> search(Predicate<Course> predicate){
        ArrayList<Course> list = new ArrayList<>();
        for (Course c : allCourses) {
            if (predicate.test(c)) {
                list.add(c);
            }
        }
        return list;
    }
    public void sort() {
        allCourses.sort(Comparator.comparing(Course::getCourseName));
        display();
    }
    public boolean delete() {
        String id = Validation.getString("Nhập mã khóa học cần xóa: ");
        return allCourses.removeIf(c -> c.getCourseId().equals(id));
    }
    public void registerCourse() {
    Scanner sc = new Scanner(System.in);
    display(); // Hiển thị danh sách khóa học

    System.out.print("Enter course ID to register (e.g., AI101): ");
    String id = sc.nextLine().trim().toUpperCase();

    Course selected = getCourseById(id);
    if (selected == null) {
        System.out.println("Course not found.");
        return;
    }

    // Kiểm tra đã đăng ký chưa
    List<String> registered = loadRegisteredCourseIds();
    if (registered.contains(id)) {
        System.out.println("You have already registered for this course.");
        return;
    }

    // Chọn giờ học
    String[] timeSlots = {"7:00", "9:00", "13:00", "15:00"};
    System.out.println("Choose a time slot:");
    for (int i = 0; i < timeSlots.length; i++) {
        System.out.println((i + 1) + ". " + timeSlots[i]);
    }
    int timeChoice = 0;
    while (timeChoice < 1 || timeChoice > timeSlots.length) {
        System.out.print("Your choice (1-4): ");
    try {
        timeChoice = Integer.parseInt(sc.nextLine());
    } catch (NumberFormatException e) {
        System.out.println("Invalid input.");
    }
}
    String selectedTime = timeSlots[timeChoice - 1];

    // Chọn ngày học
    String[] days = {"Thứ 2", "Thứ 3", "Thứ 4", "Thứ 5", "Thứ 6"};
    System.out.println("Choose a day of the week:");
    for (int i = 0; i < days.length; i++) {
        System.out.println((i + 1) + ". " + days[i]);
    }
    int dayChoice = 0;
    while (dayChoice < 1 || dayChoice > days.length) {
        System.out.print("Your choice (1-5): ");
    try {
        dayChoice = Integer.parseInt(sc.nextLine());
    } catch (NumberFormatException e) {
        System.out.println("Invalid input.");
    }
}
    String selectedDay = days[dayChoice - 1];

    // Kết hợp giờ + ngày
    String finalTime = selectedTime + " " + selectedDay;

    // Ghi vào file
    try (FileWriter fw = new FileWriter("registered.txt", true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter out = new PrintWriter(bw)) {
            out.println(id + ";" + finalTime);
            System.out.println("Course " + id + " registered at " + finalTime + " successfully.");
    } catch (IOException e) {
    System.out.println("Failed to register course.");
    }
}
public List<String> loadRegisteredCourseIds() {
    List<String> registered = new ArrayList<>();
    File file = new File("registered.txt");
    if (!file.exists()) return registered;

    try (Scanner sc = new Scanner(file)) {
        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (!line.isEmpty()) {
                String[] parts = line.split(";");
                if (parts.length >= 1) {
                    registered.add(parts[0]);
                }
            }
        }
    } catch (IOException e) {
        System.out.println("Lỗi đọc file");
    }
    return registered;
}
}
