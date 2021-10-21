import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;


public class Main {
    public static String s = new String("");
    public static void main(String[] args) throws IOException {
        try {
//            File file_in = new File("in.txt");
            File file_in = new File(args[0]);
            Reader reader = null;
            int c;
            try {
                reader = new InputStreamReader(new FileInputStream(file_in));
                while ((c = reader.read()) != -1) {
//                     if ((char)c != '\r') {
                        s += (char)c;
//                     }
                }
                reader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            // 去除注释
            Pattern p1 = Pattern.compile("/\\*(.*?)\\*/", Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
            Pattern p2 = Pattern.compile("/\\*.*", Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
            Pattern p3 = Pattern.compile("\\/\\/.*");
            Matcher m1 = p1.matcher(s);
            String result1 = m1.replaceAll("");
            Matcher m2 = p2.matcher(result1);
            String result2 = m2.replaceAll("");
            Matcher m3 = p3.matcher(result2);
            String result = m3.replaceAll("");

            CharStream inputStream = CharStreams.fromString(result);
            compUnitLexer lexer = new compUnitLexer(inputStream);
            CommonTokenStream tokenStream = new CommonTokenStream(lexer);
            compUnitParser parser = new compUnitParser(tokenStream);
            parser.removeErrorListeners();
            myErrorListener mel = new myErrorListener();
            parser.addErrorListener(mel);
            ParseTree tree = parser.compUnit();
            Visitor visitor = new Visitor();
            visitor.visit(tree);
//            System.out.println(visitor.results);

            try {
//                FileWriter file_out = new FileWriter("out.txt");
                FileWriter file_out = new FileWriter(args[1]);
                BufferedWriter output = new BufferedWriter(file_out);
                output.write(visitor.ans);
                output.flush();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
                        System.out.println(visitor.ans);

        } catch (Exception e) {
            e.printStackTrace();
        }
        

    }
}
