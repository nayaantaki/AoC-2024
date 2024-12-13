import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class day13 {
    public static void main(String[] args) {
        ArrayList<String> data = getFileData("inputs/day13");
        System.out.println(data);

        String machineOne = data.get(0) + data.get(1) + data.get(2);
        String[] numbers = machineOne.split("[^0-9]+");
        System.out.println(Arrays.toString(numbers));


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

    public static int[] parseMachineValues(String machine){
        int[] machineVals = new int[6];
        return machineVals;
    }
}
