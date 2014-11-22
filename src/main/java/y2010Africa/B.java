package y2010Africa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;

public class B {

    private static String go(String s) {
        String[] split = s.split("\\s");
        int strlen = split.length;
        String result = split[strlen - 1];

        if (strlen > 1)
            for (int i = strlen - 1; i > 0; i--)
                result += " " + split[i - 1];

        return result;
    }

    public static void main(String[] args) {
        try {
            String outfile = "/tmp/output";
            PrintWriter writer = new PrintWriter(outfile, "utf-8");

            FileReader f = new FileReader(args[0]);
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