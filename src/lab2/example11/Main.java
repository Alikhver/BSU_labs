package lab2.example11;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File("src/lab2/example11/input.txt"))) {
            scanner.useDelimiter("\n");
            while (scanner.hasNext()) {
                list.add(scanner.next());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File has not been found");
            System.exit(0);
        } catch (Exception e) {
            System.out.println("Invalid entry file");
            System.exit(0);
        }

        Map<Character, Integer> map = new HashMap<>();

        if (list.isEmpty()) {
            System.out.println("No entry parameters");
            System.exit(-1);
        }

        int strCounter = 1;

        for (String str : list) {
            for (char c : str.toCharArray()) {
                if (c == '\r') {
                    break;
                }
                if (!map.containsKey(c)) {
                    map.put(c, 1);
                } else {
                    map.put(c, map.get(c) + 1);
                }
            }

            System.out.println("String #" + strCounter++ + ": " + str);
            for (Map.Entry<Character, Integer> pair : map.entrySet()) {
                System.out.println("'" + pair.getKey() + "' - " + pair.getValue());
            }
            map.clear();
        }
    }
}
