package yijun.sun.length;


import yijun.sun.length.bean.Expression;
import yijun.sun.length.bean.Unit;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Parse and save information from input file.
 *
 * @author SunYiJun
 */
public class InputRepos {

    private static final String INPUT_FILE = "input.txt";

    private static List<String> allLines;

    private static Map<String, Unit> unitRepos;

    private static List<Expression> calcExpressions;

    public static Map<String, Unit> getAllDefinedUnit() {
        if(unitRepos == null) {
            parseAllLines();
        }
        return unitRepos;
    }

    public static Unit getUnit(String name) {
        if(unitRepos == null) {
            parseAllLines();
        }
        Unit unit = unitRepos.get(name);
        if(unit == null && name.endsWith("s")) {
            unit = unitRepos.get(name.substring(0, name.length() - 1));
            if(unit != null) {
                unitRepos.put(name, unit);
            }
        }
        if(unit == null && name.endsWith("es")) {
            unit = unitRepos.get(name.substring(0, name.length() - 2));
            if(unit != null) {
                unitRepos.put(name, unit);
            }
        }
        if(unit == null && name.contains("ee")) {
            unit = unitRepos.get(name.replace("ee", "oo"));
            if(unit != null) {
                unitRepos.put(name, unit);
            }
        }
        return unit;
    }

    public static List<Expression> getAllExpressions() {
        if(unitRepos == null) {
            parseAllLines();
        }
        return calcExpressions;
    }

    /**
     * Parse input line, to fill units repository and expression lines.
     */
    private static void parseAllLines() {
        if(allLines == null) {
            read();
        }
        calcExpressions = new ArrayList<Expression>();
        unitRepos = new HashMap<String, Unit>();
        unitRepos.put(Unit.METER_UNIT.getName(), Unit.METER_UNIT);
        for(String line : allLines) {
            if(line.matches("\\d+ \\w+ = [\\d\\.]+ m")) {
                Unit unit = Unit.createUnit(line);
                unitRepos.put(unit.getName(), unit);
            } else if(!line.trim().isEmpty()) {
                calcExpressions.add(Expression.createExpression(line));
            }
        }
    }

    /**
     * Read input file each line into a string list.
     */
    private static void read() {
        File file = new File(INPUT_FILE);
        BufferedReader reader = null;
        allLines = new ArrayList<String>();
        try {
            reader = new BufferedReader(new FileReader(file));
            String bufferLine;
            while((bufferLine = reader.readLine()) != null) {
                allLines.add(bufferLine);
            }
        } catch(FileNotFoundException e) {
            System.err.println("File:" + file.getAbsoluteFile() + " not found!");
        } catch(IOException e) {
            System.err.println("Read file:" + file.getAbsoluteFile() + " error!");
        } finally {
            try {
                if(reader != null) {
                    reader.close();
                }
            } catch(IOException ignored) {
            }
        }
    }

}
