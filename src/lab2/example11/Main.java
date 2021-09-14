package lab2.example11;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<String> list = Arrays.asList(args);

        Map<Character, Integer> map = new HashMap<>();

        if (list.isEmpty()) {
            System.out.println("No entry parameters");
            System.exit(-1);
        }

        int strCounter = 1;

        for (String str : list) {
            for (char c : str.toCharArray()) {
                if (!map.containsKey(c)) {
                    map.put(c, 1);
                } else {
                    map.put(c, map.get(c) + 1);
                }
            }

            System.out.println("String #" + strCounter++ + ": " + str);
            System.out.println(map);
            map.clear();
        }
    }
}
