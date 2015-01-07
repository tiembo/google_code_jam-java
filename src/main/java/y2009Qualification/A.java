package y2009Qualification;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;

public class A {
    static final String DIRECTORY = "/Users/tsong/Downloads/";
    static final String FILE = "A-large-practice.in";
    static final String OUTFILE = "/tmp/output-";

    static int l;

    private static String go(String line, HashSet<String> dictionary) {

        /**
         * Populate pattern.  Treat (ab)d(dc) the same as (ab)(d)(dc),
         * with the middle d just being a HashSet with a single element
         */
        char[] chars = line.toCharArray();
        ArrayList<HashSet<Character>> pattern = new ArrayList<HashSet<Character>>(l);
        int i = 0;

        while (i < chars.length) {
            HashSet<Character> charSet = new HashSet<Character>();

            char c = chars[i];
            if (c == '(') {
                i++;
                while(chars[i] != ')') {
                    charSet.add(chars[i]);
                    i++;
                }
            } else {
                charSet.add(c);
            }

            pattern.add(charSet);
            i++;
        }

        int total = 0;
        for (String dictWord : dictionary)
          if (hasWord(pattern, dictWord))
              total++;

        return String.valueOf(total);
    }

    // return true if each HashSet contains the corresponding character in dictWord
    private static boolean hasWord(ArrayList<HashSet<Character>> pattern, String dictWord) {
        int i = 0;

        while (i < dictWord.length()) {
            HashSet<Character> charGroup = pattern.get(i);
            if (!charGroup.contains(dictWord.charAt(i)))
                return false;
            i++;
        }

        return true;
    }

    public static void main(String[] args) {
        try {
            PrintWriter writer = new PrintWriter(OUTFILE, "utf-8");
            FileReader f = new FileReader(DIRECTORY + FILE);
            BufferedReader reader = new BufferedReader(f);

            String[] integers = reader.readLine().split(" ");
            l = Integer.parseInt(integers[0]);
            int d = Integer.parseInt(integers[1]);
            int n = Integer.parseInt(integers[2]);

            // create dictionary of list of known words
            HashSet<String> dictionary = new HashSet<String>(d);
            for (int i = 0; i < d; i++)
                dictionary.add(reader.readLine());

            // match each pattern line to dictionary
            for (int i = 0; i < n; i++)
                writer.println("Case #" + (i + 1) + ": " + go(reader.readLine(), dictionary));

            writer.close();
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}