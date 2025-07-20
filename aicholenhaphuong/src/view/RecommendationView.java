package view;

import model.Course;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.File;
import java.util.HashSet;
import java.util.Set;

public class RecommendationView {

    public void displayWelcomeMessage() {
        System.out.println("--- AGENT TƯ VẤN LỘ TRÌNH HỌC TẬP ---");
    }

    public String promptForUserGoal() {
        System.out.println("\nChào bạn, tôi là Agent tư vấn. Bạn muốn học về lĩnh vực gì?");
        System.out.println("(Ví dụ: 'lập trình AI', 'phát triển web cho người mới bắt đầu', 'học về cơ sở dữ liệu')");
        return Validation.getString("> ");
    }

    public void displayAnalysisMessage(String userGoal) {
        System.out.printf("\nĐã nhận yêu cầu: \"%s\".\n", userGoal);
        System.out.println("Agent đang phân tích và tạo lộ trình... Vui lòng chờ.");
    }

    public void displayLearningPath(String userGoal, ArrayList<Course> path) {
        System.out.println("\n=======================================================");
        System.out.printf("--- LỘ TRÌNH ĐỀ XUẤT CHO '%s' ---%n", userGoal.toUpperCase());

        if (path.isEmpty()) {
            System.out.println("Hiện tại hệ thống chưa hỗ trợ lĩnh vực này. Vui lòng thử lại với lĩnh vực khác.");
        } else {
            int step = 1;
            for (Course course : path) {
                System.out.printf("Bước %d: %s%n", step++, course);
            }

            System.out.print("\n--> Bạn có muốn đăng ký tất cả các khóa học trên không? (y/n): ");
            String answer = Validation.getString("> ").trim().toLowerCase();

            if (answer.equals("y") || answer.equals("yes")) {
                String[] days = {"Thứ 2", "Thứ 3", "Thứ 4", "Thứ 5", "Thứ 6"};
                String[] hours = {"07:00", "09:00", "13:00", "15:00"};
                String[] timeSlots = new String[days.length * hours.length];

                int index = 0;
                for (String hour : hours) {
                    for (String day : days) {
                        timeSlots[index++] = hour + " " + day;
                    }
                }

                Set<String> alreadyRegistered = loadRegisteredCourseIds();
                Set<String> usedTimeSlots = loadRegisteredTimeSlots();

                for (Course course : path) {
                    if (alreadyRegistered.contains(course.getCourseId())) {
                        System.out.println("Bạn đã đăng ký khóa học: " + course.getCourseId() + " - " + course.getCourseName() + ". Bỏ qua.");
                        continue;
                    }

                    System.out.println("\nĐăng ký khóa học: " + course.getCourseId() + " - " + course.getCourseName());
                    System.out.println("Lịch học hiện tại (X: đã được chọn, O: còn trống):");

                    int count = 1;
                    System.out.printf("%-10s", "");
                    for (String day : days) {
                        System.out.printf("%-20s", day);
                    }
                    System.out.println();

                    for (String hour : hours) {
                        System.out.printf("%-10s", hour);
                        for (String day : days) {
                            String slot = hour + " " + day;
                            if (usedTimeSlots.contains(slot)) {
                                System.out.printf("%-20s", count + ". X");
                            } else {
                                System.out.printf("%-20s", count + ". O");
                            }
                            count++;
                        }
                        System.out.println();
                    }

                    int choice = 0;
                    while (choice < 1 || choice > timeSlots.length || usedTimeSlots.contains(timeSlots[choice - 1])) {
                        System.out.print("Lựa chọn của bạn (1-" + timeSlots.length + ", chọn số có dấu O): ");
                        try {
                            choice = Integer.parseInt(Validation.getString("> "));
                        } catch (NumberFormatException e) {
                            System.out.println("Nhập số hợp lệ.");
                        }
                    }

                    String selectedTime = timeSlots[choice - 1];
                    saveCourseRegistration(course.getCourseId(), selectedTime);
                    usedTimeSlots.add(selectedTime);
                }

                System.out.println("\nHoàn tất đăng ký các khóa học chưa đăng ký trong lộ trình.");
            }
        }

        System.out.println("=======================================================\n");
    }

    public void displayError(String errorMessage) {
        System.err.println("\n--- ĐÃ CÓ LỖI XẢY RA ---");
        System.err.println(errorMessage);
        System.err.println("========================\n");
    }

    private static void saveCourseRegistration(String id, String time) {
        try (PrintWriter out = new PrintWriter(new FileWriter("registered.txt", true))) {
            out.println(id + ";" + time);
        } catch (IOException e) {
            System.out.println("Không thể lưu đăng ký khóa học " + id);
        }
    }

    private static Set<String> loadRegisteredCourseIds() {
        Set<String> ids = new HashSet<>();
        File file = new File("registered.txt");
        if (!file.exists()) return ids;

        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                if (!line.isEmpty()) {
                    String[] parts = line.split(";");
                    if (parts.length >= 1) {
                        ids.add(parts[0]);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Không thể đọc file đăng ký.");
        }

        return ids;
    }

    private static Set<String> loadRegisteredTimeSlots() {
        Set<String> times = new HashSet<>();
        File file = new File("registered.txt");
        if (!file.exists()) return times;

        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                if (!line.isEmpty()) {
                    String[] parts = line.split(";");
                    if (parts.length >= 2) {
                        times.add(parts[1]);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Không thể đọc file đăng ký.");
        }

        return times;
    }
}
