import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class day3 {
    public static void main(String[] args) {
        ArrayList<String> data = getFileData("inputs/day3");
//        System.out.println(data);

        ArrayList<String> clear = new ArrayList<String>();

        for (int i = 0; i < data.size(); i++) {
            data.set(i, cutOut(data.get(i)));
        }
        String regex = "mul\\(\\d+,\\d+\\)";

//        System.out.println(data.get(0));
//        data.set(0, cutOut(data.get(0)));
//        System.out.println(data.get(0));

        for (int i = 0; i < data.size(); i++) {
            Matcher matcher = Pattern.compile(regex).matcher(data.get(i));

            while (matcher.find()){
                clear.add(matcher.group());
            }
        }

        System.out.println(totalProducts(clear));

//        System.out.println(clear);
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

    public static int totalProducts(ArrayList<String> data){
        int total = 0;
        for (int i = 0; i < data.size(); i++) {
            int numOne = Integer.parseInt(data.get(i).substring(data.get(i).indexOf("(") + 1, data.get(i).indexOf(",")));
            int numTwo = Integer.parseInt(data.get(i).substring((data.get(i).indexOf(",") + 1), data.get(i).indexOf(")")));
            total += (numOne * numTwo);
        }
        return total;
    }

    public static String cutOut(String datum){
        String dont = "don't()";
        String doo = "do()";
        for (int i = 0; i < datum.length() - 7; i++) {
            if (datum.substring(i, i+7).equals(dont)){
//                System.out.println(datum.substring(i, i+7));
                datum = datum.replace((datum.substring(i+7, datum.indexOf(doo))), "");
                //figure out the character it breaks at ^^
//                System.out.println(datum);
            }
        }
        return datum;
    }
}
