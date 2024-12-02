import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class day2 {
    public static void main(String[] args) {
        int safeReports = 0;
        ArrayList<String> dataStr = getFileData("inputs/day2_sample");
        System.out.println(dataStr);

        for (int i = 0; i < dataStr.size(); i++) {
            ArrayList<Integer> report = toIntList(dataStr.get(i));
            for (int j = 0; j < report.size() - 1; j++) {
                int distance = Math.abs(report.get(j+1) - report.get(j));
                if (levelsSequential(report) && ((distance > 3 || distance < 1))){
                    safeReports++;
                }
            }
        }

        System.out.println(safeReports);
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

    private static ArrayList<Integer> toIntList(String numSet){
        ArrayList<Integer> intList = new ArrayList<Integer>();

        String[] strArr = numSet.split("\\s");

        for (int i = 0; i < strArr.length; i++) {
            intList.add(Integer.parseInt(strArr[i]));
        }

        return intList;
    }

    private static boolean levelsSequential(ArrayList<Integer> report){
        if (report.get(0) > report.get(1)){
            for (int i = 0; i < report.size() - 1; i++) {
                if (!(report.get(i) > report.get(i+1))){
                    return false;
                }
            }
        }
        if (report.get(0) < report.get(1)){
            for (int i = 0; i < report.size() - 1; i++) {
                if (!(report.get(i) < report.get(i+1))){
                    return false;
                }
            }
        }
        return true;
    }
}
