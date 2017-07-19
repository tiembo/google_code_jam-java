package y2008Round1A;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class A {
    private static String go(int size, String line1, String line2) {
        String[] s1 = line1.split("\\s");
        String[] s2 = line2.split("\\s");

        int[] i1 = new int[size];
        int[] i2 = new int[size];

        for (int i = 0; i < size; i++) {
            i1[i] = Integer.parseInt(s1[i]);
            i2[i] = Integer.parseInt(s2[i]);
        }

        Arrays.sort(i1);
        Arrays.sort(i2);

        long result = 0;
        for (int i = 0; i < size; i++) {
            long l1 = i1[i];
            long l2 = i2[size - i - 1];
            result += l1 * l2;
        }

        return String.valueOf(result);
    }

    public static void main(String[] args) {
        try {
            String outfile = "/tmp/output";
            PrintWriter writer = new PrintWriter(outfile, "utf-8");

            FileReader f = new FileReader(args[0]);
            BufferedReader reader = new BufferedReader(f);

            int numCases = Integer.parseInt(reader.readLine());
            for (int i = 0; i < numCases; i++) {
                int size = Integer.parseInt(reader.readLine());
                String line1 = reader.readLine();
                String line2 = reader.readLine();

                writer.println("Case #" + (i + 1) + ": " + go(size, line1, line2));
            }

            writer.close();
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
