import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.*;

public class day4 {
    public static void main(String[] args){
        ArrayList<String> data = getFileData("inputs/day4_sample");
        System.out.println(data);

//        System.out.println(horizontal(data.get(0)));

//        System.out.println(vertical(data));
        diagonal(data);
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

    public static int horizontal(String line){
        Pattern pattern = Pattern.compile("XMAS|SAMX");
        Matcher matcher = pattern.matcher(line);
        if (matcher.find()){
            return 1;
        }
        return 0;
    }

    public static int vertical(ArrayList<String> puzzle){
        int counter = 0;
        for (int r = 0; r < puzzle.size() - 4; r++) {
            for (int c = 0; c < puzzle.get(0).length(); c++) {
                String bitChecking = String.valueOf(puzzle.get(r).charAt(c)) + String.valueOf(puzzle.get(r + 1).charAt(c)) + String.valueOf(puzzle.get(r + 2).charAt(c)) + String.valueOf(puzzle.get(r + 3).charAt(c));
                System.out.println(bitChecking);
                counter += horizontal(bitChecking);
            }
        }
        return counter;
    }

    public static int diagonal(ArrayList<String> puzzle){
        for (int r = 0; r < puzzle.size() - 3; r++) {
            for (int c = 0; c < puzzle.get(0).length() - 3; c++) {
                String bitChecking = String.valueOf(puzzle.get(r).charAt(c)) + String.valueOf(puzzle.get(r + 1).charAt(c + 1)) + String.valueOf(puzzle.get(r + 2).charAt(c + 2)) + String.valueOf(puzzle.get(r + 3).charAt(c + 3));
//                System.out.println(bitChecking);
            }
        }

        //goes out of bounds towards the end
        for (int r = puzzle.size() - 3; r > 0; r--) {
            for (int c = 0; c < puzzle.get(0).length() - 3; c++) {
                String bitChecking = String.valueOf(puzzle.get(r).charAt(c)) + String.valueOf(puzzle.get(r - 1).charAt(c + 1)) + String.valueOf(puzzle.get(r - 2).charAt(c + 2)) + String.valueOf(puzzle.get(r - 3).charAt(c + 3));
                System.out.println(bitChecking);
            }
        }
        return 0;
    }
}
