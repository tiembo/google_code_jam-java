import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;

public class Template {
    private static final String DIRECTORY = "";
    private static final String FILE = "";
    private static final String OUTFILE = "/tmp/output-";

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

                // uncomment if each case has additional specifications
                // String[] caseArgs = reader.readLine().split(" ");

                writer.println("Case #" + (i + 1) + ": " + go());
            }

            writer.close();
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}