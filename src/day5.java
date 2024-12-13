import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class day5 {
    public static void main(String[] args) {
        ArrayList<String> rulesData = getFileData("inputs/day5_rules");
        ArrayList<String> sequencesData = getFileData("inputs/day5_sequences");

        ArrayList<int[]> ruleSets = new ArrayList<int[]>();
        for (int i = 0; i < rulesData.size(); i++) {
            String[] arrRule = rulesData.get(i).split("\\|");
            int[] intArrRule = new int[arrRule.length];
            for (int j = 0; j < intArrRule.length; j++) {
                intArrRule[j] = Integer.parseInt(arrRule[j]);
            }
            ruleSets.add(intArrRule);
        }
        System.out.println(ruleSets);

        //parse the sequences as an arraylist of integer arrays

        ArrayList<int[]> sequenceSets = new ArrayList<int[]>();
        for (int i = 0; i < sequencesData.size(); i++) {
            String[] arrSequence = sequencesData.get(i).split(",");
            int[] intArrSequence = new int[arrSequence.length];
            for (int j = 0; j < intArrSequence.length; j++) {
                intArrSequence[j] = Integer.parseInt(arrSequence[j]);
            }
            sequenceSets.add(intArrSequence);
        }



    }
    public static ArrayList<String> getFileData(String fileName) {
        ArrayList<String> fileData = new ArrayList<String>();
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (!line.equals(""))
                    fileData.add(line);
            }
            return fileData;
        }
        catch (FileNotFoundException e) {
            return fileData;
        }
    }

    public static ArrayList<Integer> logViableUpdates(ArrayList<int[]> sequenceSets, ArrayList<int[]> ruleSets){
        ArrayList<Integer> viableUpdates = new ArrayList<Integer>();
        for (int i = 0; i < sequenceSets.size(); i++) {
            int[] workingSequence = sequenceSets.get(i);
            for (int j = 0; j < ruleSets.size(); j++) {
                int[] workingRule = ruleSets.get(j);
                if (ruleNumbersPresent(workingSequence, workingRule)){
                    //
                }
            }
        }
        return viableUpdates;
    }

    public static boolean ruleNumbersPresent(int[] sequenceSet, int[] ruleSet){
        for (int i: sequenceSet){
            if (!(i == ruleSet[0])){
                return false;
            }
        }
        for (int i: sequenceSet){
            if (i == ruleSet[1]){
                return true;
            }
        }
        return true;
    }

    public static boolean checkRule(int[] sequenceSet, int[] ruleSet){
        int indexOfFirst = 0;
        int indexOfSecond = 0;
        for (int i = 0; i < sequenceSet.length; i++) {
            if (sequenceSet[i] == ruleSet[0]){
                indexOfFirst = i;
            }
            if (sequenceSet[i] == ruleSet[1]){
                indexOfSecond = i;
            }
        }

        return indexOfFirst < indexOfSecond;
    }
}
