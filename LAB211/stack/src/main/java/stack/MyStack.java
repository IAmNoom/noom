package stack;

import java.util.ArrayList;

public class MyStack {
    private ArrayList<Integer> stackValues;

    public MyStack() {
        stackValues = new ArrayList<>();
    }

    // Push giá trị vào stack
    public void push(int value) {
        stackValues.add(value);
        System.out.println("Pushed: " + value);
    }

    // Pop giá trị ra khỏi stack
    public Integer pop() {
        if (stackValues.isEmpty()) {
            System.out.println("⚠ Stack is empty, cannot pop!");
            return null;
        }
        int value = stackValues.remove(stackValues.size() - 1);
        System.out.println("Popped: " + value);
        return value;
    }

    // Get giá trị trên cùng
    public Integer get() {
        if (stackValues.isEmpty()) {
            System.out.println("⚠ Stack is empty!");
            return null;
        }
        int value = stackValues.get(stackValues.size() - 1);
        System.out.println("Top value: " + value);
        return value;
    }

    // Hiển thị stack
    public void display() {
        System.out.println("Stack: " + stackValues);
    }
}

