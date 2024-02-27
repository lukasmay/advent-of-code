import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day13{

    public static void main(String[] args) {

    		part1();
    		//part2();
    	}

        public static String[] getSection(String packet){
            String section = "";
            
            long count = packet.chars().filter(ch -> ch == '[').count();
            String[] answer = new String[(int) count];


            long emptyN = packet.chars().filter(ch -> ch == ',').count();
            if (emptyN == 0){
                for (int i = 0; i < count; i++){
                    //answer[i] = packet.substring(packet.indexOf("[")+1, the correct end bracket);
                }
            }

            for (int i = 0; i < count; i++){
            section = packet.substring(0, packet.indexOf(","));
            
            packet = section.substring(section.indexOf("]")+1);
            }
            return answer;
        }

        public static void part1(){
            String line = "";
            String packet1 = "";
            String packet2 = "";
            int lineCounter = 0;
            int solution = 0;
            try {
                Scanner scanner = new Scanner(new File("/Users/lukasmay/Documents/Github/AdventOfCode/2022/input/day13.txt"));
                while (scanner.hasNextLine()) {
                    line = scanner.nextLine();
                    if (line.trim().equals("")){
                        lineCounter = -1;

                        getSection(packet1);
                        //System.out.println(packet1);
                        
                    } else {
                        if (lineCounter == 0){
                            packet1 = line;
                        } else {
                            packet2 = line;
                        }
                    }
                    lineCounter++;
                }
                scanner.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
}