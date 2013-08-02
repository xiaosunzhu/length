package yijun.sun.length;


import yijun.sun.length.bean.Expression;
import yijun.sun.length.bean.Length;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * @author SunYiJun
 */
public class MainWork {

    private static final String OUTPUT_FILE = "output.txt";
    public static final String SIGN_UP_EMAIL = "dusunjun@126.com";

    private static List<Length> results = new ArrayList<Length>();

    public static void main(String[] args) {
        List<Expression> expressions = InputRepos.getAllExpressions();
        for(Expression expression : expressions) {
            results.add(expression.execute());
        }
        outputResults();
    }

    private static void outputResults() {
        if(results == null || results.isEmpty()) {
            return;
        }
        File outputFile = new File(OUTPUT_FILE);
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(outputFile));
            writer.append(SIGN_UP_EMAIL);
            writer.newLine();
            writer.newLine();
            for(int i = 0; i < results.size(); i++) {
                writer.append(results.get(i).toString());
                if(i != results.size() - 1) {
                    writer.newLine();
                }
            }
            writer.flush();
        } catch(IOException e) {
            System.err.println("Write file:" + outputFile.getAbsolutePath() + " error!");
            for(Length result : results) {
                System.out.println(result);
            }
        } finally {
            try {
                if(writer != null) {
                    writer.close();
                }
            } catch(IOException ignored) {
            }
        }
    }

}
