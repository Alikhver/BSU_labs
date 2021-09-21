package lab2.example11;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(new File("src/lab2/example11/file.txt"));

        List<String> list = new ArrayList<>();

        while (scanner.hasNext()) {
            list.add(scanner.next());
        }

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
