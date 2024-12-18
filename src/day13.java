import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class day13 {
    public static void main(String[] args) {
        ArrayList<String> data = getFileData("inputs/day13");
//        System.out.println(data);
        ArrayList<int[]> machines = parseMachineValues(data);

        for (int[] machine : machines){
            System.out.println(Arrays.toString(machine));
        }

        int tokens = solveButtonPresses(machines.get(1));


    }

    public static ArrayList<int[]> parseMachineValues(ArrayList<String> data){
        ArrayList<int[]> machines = new ArrayList<int[]>();

        for (int i = 0; i < data.size() - 2; i++) {
            String machineOne = "";
            if (data.get(i).contains("Button A")){
                machineOne = data.get(i) + data.get(i + 1) + data.get(i + 2);
                System.out.println(machineOne);
                String[] numbers = machineOne.split("[^0-9]+");

                int[] machineVals = new int[6];
                for (int j = 0; j < machineVals.length; j++) {
                    machineVals[j] = Integer.parseInt(numbers[j+1]);
                }

                machines.add(machineVals);
            }
        }

        return machines;
    }

    public static int solveButtonPresses(int[] machine){
        int aX = machine[0];
        int bX = machine[2];
        int prizeX = machine[4];

        int aY = machine[1];
        int bY = machine[3];
        int prizeY = machine[5];

        int a = (prizeX*bY-prizeY*bX)/(bY*aX-bX*aY);
        int b = (prizeX*aY-prizeY*aX)/(aY*bX-bY*aX);

        System.out.println("A Presses: " + a);
        System.out.println("B Presses: " + b);

        if (a > 100 || b > 100){
            return 0;
        } else{
            return (a*3) + b;
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
