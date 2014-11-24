import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;

public class Template {
    static final String DIRECTORY = "/Users/tsong/Downloads/";
    static final String FILE = "";
    static final String OUTFILE = "/tmp/output-";

    private static String go() {
        return "placeholder";
    }

    public static void main(String[] args) {
        try {
            PrintWriter writer = new PrintWriter(OUTFILE, "utf-8");
            FileReader f = new FileReader(DIRECTORY + FILE);
            BufferedReader reader = new BufferedReader(f);

            int numCases = Integer.parseInt(reader.readLine());
            for (int i = 0; i < numCases; i++) {
                writer.println("Case #" + (i + 1) + ": " + go());
            }

            writer.close();
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}