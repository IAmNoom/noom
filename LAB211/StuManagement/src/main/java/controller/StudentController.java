package controller;

import java.util.*;
import model.Student;
import view.Menu1;
import view.StudentView;

public class StudentController extends Menu1 {
    private ArrayList<Student> list;
    private StudentView view;
    private Scanner sc;

    public StudentController(String title, String[] options, Scanner sc) {
        super(title, options, sc);
        this.sc = sc;
        this.list = new ArrayList<>();
        this.view = new StudentView(sc);
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1: createStudent(); break;
            case 2: findAndSort(); break;
            case 3: updateOrDelete(); break;
            case 4: report(); break;
            case 5: view.showMessage("Bye!"); break;
        }
    }

     private void createStudent() {
        while (true) {
            Student s = view.inputStudent();
            list.add(s);
            if (list.size() >= 3) {
                System.out.print("Do you want to continue (Y/N)? ");
                String ans = sc.nextLine().trim();
                if (!ans.equalsIgnoreCase("Y")) break;
            }
        }
    }

    private void findAndSort() {
        System.out.print("Enter name to search: ");
        String keyword = sc.nextLine().trim().toLowerCase();
        ArrayList<Student> result = new ArrayList<>();
        for (Student s : list) {
            if (s.getName().toLowerCase().contains(keyword)) {
                result.add(s);
            }
        }
        result.sort(Comparator.comparing(Student::getName));
        for (Student s : result) {
            System.out.println(s.getName() + " | " + s.getSemester() + " | " + s.getCourse());
        }
    }

    private void updateOrDelete() {
        System.out.print("Enter student ID to search: ");
        String id = sc.nextLine().trim();
        Student found = null;
        for (Student s : list) {
            if (s.getId().equalsIgnoreCase(id)) {
                found = s;
                break;
            }
        }
        if (found == null) {
            view.showMessage("Student not found!");
            return;
        }
        System.out.print("Do you want to Update (U) or Delete (D)? ");
        String choice = sc.nextLine().trim();
        if (choice.equalsIgnoreCase("U")) {
            Student newS = view.inputStudent();
            found.setName(newS.getName());
            found.setSemester(newS.getSemester());
            found.setCourse(newS.getCourse());
            view.showMessage("Updated successfully.");
        } else if (choice.equalsIgnoreCase("D")) {
            list.remove(found);
            view.showMessage("Deleted successfully.");
        } else {
            view.showMessage("Invalid choice.");
        }
    }

    private void report() {
        Map<String, Map<String, Integer>> reportMap = new HashMap<>();
        for (Student s : list) {
            reportMap.putIfAbsent(s.getName(), new HashMap<>());
            Map<String, Integer> courses = reportMap.get(s.getName());
            courses.put(s.getCourse(), courses.getOrDefault(s.getCourse(), 0) + 1);
        }
        for (String name : reportMap.keySet()) {
            for (Map.Entry<String, Integer> entry : reportMap.get(name).entrySet()) {
                System.out.println(name + " | " + entry.getKey() + " | " + entry.getValue());
            }
        }
    }
}

