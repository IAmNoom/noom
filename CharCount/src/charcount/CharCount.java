package charcount;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CharCount {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Nhập chuỗi từ người dùng
        System.out.print("Enter your content:\n");
        String input = sc.nextLine();

        // Đếm từ bằng StringTokenizer
        Map<String, Integer> wordCount = new HashMap<>();
        StringTokenizer tokenizer = new StringTokenizer(input);
        while (tokenizer.hasMoreTokens()) {
            String word = tokenizer.nextToken().toLowerCase();
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // Đếm ký tự (chỉ tính chữ cái)
        Map<Character, Integer> letterCount = new HashMap<>();
        for (char c : input.toCharArray()) {
            if (Character.isLetter(c)) {
                char lower = Character.toLowerCase(c);
                letterCount.put(lower, letterCount.getOrDefault(lower, 0) + 1);
            }
        }

        // Xuất kết quả
        System.out.println(wordCount);
        System.out.println(letterCount);

        sc.close();
    }
}

