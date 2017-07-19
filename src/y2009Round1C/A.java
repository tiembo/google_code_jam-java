package y2009Round1C;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class A {
    static final String DIRECTORY = "/Users/tsong/Downloads/";
    static final String FILE = "A-large-practice.in";
    static final String OUTFILE = "/tmp/output";

    private static String go(String line) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();

        Integer nextBase = 1;

        for (int i = 0; i < line.length(); i++) {
            Character c = line.charAt(i);

            if (!map.containsKey(c)) {
                map.put(c, nextBase);

                if (nextBase == 1)
                    nextBase = 0;
                else if (nextBase == 0)
                    nextBase = 2;
                else
                    nextBase++;
            }
        }

        int base = map.size() < 2 ? 2 : map.size();

        long result = 0;
        for (int i = 0; i < line.length(); i++) {
            Character c = line.charAt(i);
            result = result * base + map.get(c);
        }

        return String.valueOf(result);
    }

    public static void main(String[] args) {
        try {
            PrintWriter writer = new PrintWriter(OUTFILE, "utf-8");
            FileReader f = new FileReader(DIRECTORY + FILE);
            BufferedReader reader = new BufferedReader(f);

            int numCases = Integer.parseInt(reader.readLine());
            for (int i = 0; i < numCases; i++) {
                writer.println("Case #" + (i + 1) + ": " + go(reader.readLine()));
            }

            writer.close();
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
