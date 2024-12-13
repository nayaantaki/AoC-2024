import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class day6 {
    public static void main(String[] args) {
        ArrayList<String> mapData = getFileData("inputs/day6_sample");
        convertMap(mapData);
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

    public static String[][] convertMap(ArrayList<String> data){
        String[][] mapDie1 = new String[data.size()][data.getFirst().length()];
        String[] mapDie2 = new String[data.getFirst().length()];
        System.out.println(Arrays.toString(mapDie1));
        return mapDie1;
    }
}
