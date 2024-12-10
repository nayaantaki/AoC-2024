import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class day5 {
    public static void main(String[] args) {
        ArrayList<String> rulesData = getFileData("inputs/day5_rules");
        ArrayList<String> sequencesData = getFileData("inputs/day5_sequences");

        ArrayList<String[]> ruleSets = new ArrayList<String[]>();
        for (int i = 0; i < rulesData.size(); i++) {
            String [] arrRule = rulesData.get(i).split("\\|");
            ruleSets.add(arrRule);
        }

        //parse the sequences as an arraylist of integer arrays

        ArrayList<int[]> sequenceSets = new ArrayList<int[]>();
        for (int i = 0; i < sequencesData.size(); i++) {
            String [] arrSequence = sequencesData.get(i).split(",");
            System.out.println(Arrays.toString(arrSequence));
            int [] intArrSequence = new int[arrSequence.length];
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
}
