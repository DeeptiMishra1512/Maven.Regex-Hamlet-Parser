import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by thook on 10/7/15.
 */
public class HamletParser {

    private String hamletData;
    private String outputFile  = "/Users/dmishra/DeeptiProjects/Maven.Regex-Hamlet-Parser/src/main/resources/OutputFile.txt";

    public HamletParser(){
        this.hamletData = loadFile();
    }

    private String loadFile(){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("hamlet.txt").getFile());
        StringBuilder result = new StringBuilder("");

        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                result.append(line).append("\n");

            }

            scanner.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        return result.toString();
    }


    public String getHamletData(){
        return hamletData;

    }

    public String patternMatcherMethod(){
        //Create 2 String variable to store the strings to be matched in file data
        // adding \\b to make sure Horatio and Tariq are a single words when being replaced.
        String stringHamlet = "\\bHamlet\\b";
        String stringHoratio = "\\bHoratio\\b";
        String modifiedData ="";


        if (hamletData == null) {
            throw new IllegalStateException("Hamlet data is not loaded.");
        }


        //Creating Pattern and Matcher for Hamlet and replace Hamlet with Leon
        Pattern hamletPattern = Pattern.compile(stringHamlet, Pattern.CASE_INSENSITIVE);
        Matcher matcherHamlet = hamletPattern.matcher(hamletData);

        modifiedData = matcherHamlet.replaceAll("Leon");

        // Creating Pattern and Matcher for Horatio and Replace "Horatio" with "Tariq"
        Pattern horatioPattern = Pattern.compile(stringHoratio, Pattern.CASE_INSENSITIVE);
        Matcher matcherHoratio = horatioPattern.matcher(modifiedData);

        modifiedData = matcherHoratio.replaceAll("Tariq");

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))){
            writer.write(modifiedData);
            System.out.println("File written successfully to: " + outputFile);
        } catch (IOException e) {
            System.out.println("Failed to write to output file.");
            e.printStackTrace();
        }

        System.out.println(modifiedData);
        return modifiedData;
    }



    public static void main(String[] args){

        HamletParser hamlet = new HamletParser();
        hamlet.patternMatcherMethod();

    }

}
