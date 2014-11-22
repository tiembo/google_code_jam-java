package y2014Qualification;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class A {
    private static String go(String line1, String line2) {
        String[] one = line1.split("\\s");
        String[] two = line2.split("\\s");
        Set<String> o = new HashSet<String>(Arrays.asList(one));

        int matches = 0;
        String match = null;
        for (String s : two)
            if (o.contains(s)) {
                match = s;
                matches++;
            }

        switch (matches) {
            case (0): return "Volunteer cheated!";
            case (1): return match;
            default: return "Bad magician!";
        }

    }

    public static void main(String[] args) {
        try {
            String outfile = "/tmp/output";
            PrintWriter writer = new PrintWriter(outfile, "utf-8");

            FileReader f = new FileReader(args[0]);
            BufferedReader reader = new BufferedReader(f);

            int numCases = Integer.parseInt(reader.readLine());
            for (int i = 0; i < numCases; i++) {
                String row1 = null, row2 = null;
                int whichRow = Integer.parseInt(reader.readLine());
                for (int j = 0; j < 4; j++) {
                    if (j == whichRow - 1)
                        row1 = reader.readLine();
                    else
                        reader.readLine();
                }

                whichRow = Integer.parseInt(reader.readLine());
                for (int j = 0; j < 4; j++) {
                    if (j == whichRow - 1)
                        row2 = reader.readLine();
                    else
                        reader.readLine();
                }

                writer.println("Case #" + (i + 1) + ": " + go(row1, row2));
            }

            writer.close();
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
