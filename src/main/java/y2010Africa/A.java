package y2010Africa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class A {
    static final String DIRECTORY = "/Users/tsong/Downloads/";
    static final String FILE = "A-large-practice.in";
    static final String OUTFILE = "/tmp/output-large";

    private static String go(int c, int numItems, String line) {
        Map<Integer, Integer> m = new HashMap<Integer, Integer>(numItems);
        String[] values = line.split("\\s");
        String result = "";

        for (int i = 0; i < values.length; i++) {
            int cost = Integer.parseInt(values[i]);

            int lookingFor = c - cost;

            if (m.containsKey(lookingFor)) {
                int otherIndex = m.get(lookingFor);

                if (i < otherIndex)
                    result = (i + 1) + " " + (otherIndex + 1);
                else
                    result = (otherIndex + 1) + " " + (i + 1);

                break;
            } else {
                m.put(cost, i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        try {
            PrintWriter writer = new PrintWriter(OUTFILE, "utf-8");

//            FileReader f = new FileReader(args[0]);
            FileReader f = new FileReader(DIRECTORY + FILE);
            BufferedReader reader = new BufferedReader(f);

            int numCases = Integer.parseInt(reader.readLine());
            for (int i = 0; i < numCases; i++) {
                int c = Integer.parseInt(reader.readLine());
                int numItems = Integer.parseInt(reader.readLine());
                String line = reader.readLine();

                writer.println("Case #" + (i + 1) + ": " + go(c, numItems, line));
            }

            writer.close();
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
