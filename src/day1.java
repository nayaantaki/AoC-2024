import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;
import java.util.Scanner;

public class day1 {
    public static void main(String[] args) {
        ArrayList<String> data = getFileData("inputs/day1");

        ArrayList<Integer> leftNumbers = new ArrayList<Integer>();
        ArrayList<Integer> rightNumbers = new ArrayList<Integer>();

        for (String datum : data) {
            leftNumbers.add(Integer.parseInt(datum.substring(0, 5)));
            rightNumbers.add(Integer.parseInt(datum.substring(8)));
        }

        leftNumbers.sort(Comparator.naturalOrder());
        rightNumbers.sort(Comparator.naturalOrder());

        System.out.println(totalDistance(leftNumbers, rightNumbers));

        System.out.println(simScore(leftNumbers, rightNumbers));

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

    private static int totalDistance(ArrayList<Integer> leftNumbers, ArrayList<Integer> rightNumbers){
        int distances = 0;
        for (int i = 0; i < leftNumbers.size(); i++) {
            distances += Math.abs((leftNumbers.get(i) - rightNumbers.get(i)));
        }
        return distances;
    }

    private static int simScore(ArrayList<Integer> leftNumbers, ArrayList<Integer> rightNumbers){
        int simScore = 0;
        for (int i = 0; i < leftNumbers.size(); i++) {
            int counter = 0;
            for (int j = 0; j < rightNumbers.size(); j++) {
                if (Objects.equals(leftNumbers.get(i), rightNumbers.get(j))){
                    counter++;
                }
            }
            simScore += ((leftNumbers.get(i)) * counter);
        }
        return simScore;
    }
}