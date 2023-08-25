import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;

public class Day16{
    public static ArrayList<String[]> possiblePermutation = new ArrayList<>();
    public static int counter = 0;
    public static void main(String[] args) {
            
    		part1();
    		//part2();
    	}

        public static void part1(){
            String line = "";
            ArrayList<Valve> valves = new ArrayList<>();
            
            try {
                Scanner scanner = new Scanner(new File("/Users/lukasmay/Documents/Github/AdventOfCode/2022/input/day16.txt"));
                while (scanner.hasNextLine()) {
                    line = scanner.nextLine();
                    valves.add(new Valve(Integer.valueOf(line.substring(23, line.indexOf(";"))), line.substring(6, 8), line.substring(line.indexOf(",")-2).split(",")));

                }
            scanner.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            

            /*  First I need to find all permutations of my choices for a length of 30 options
             *  Then find all of those that are possible in this situation
             *  Then Calculate the total releaf presures of all the options
             *      This can be done in a for loop that loops for each option and then 30 times for the cinario
             *     
             *  
             */
            String[] s = new String[valves.size()];
            for (int i = 0; i < valves.size(); i++){
                s[i] = valves.get(i).getName();
            }
            printAllRecursive(s.length, s, ' ');
            System.out.println("Done");
            //Checks if posibility possible


            //Calculates the possible releaf presurers




        }

        public static <T> void printAllRecursive(int n, T[] elements, char delimiter) {
          
              if(n == 1) {
                  printArray(elements, delimiter);
              } else {
                    for(int i = 0; i < n-1; i++) {
                        printAllRecursive(n - 1, elements, delimiter);
                        if(n % 2 == 0) {
                            swap(elements, i, n-1);
                        } else {
                            swap(elements, 0, n-1);
                        }
                    }
                    counter++;
                  
                    printAllRecursive(n - 1, elements, delimiter);
                  
            }
          }

          private static <T> void swap(T[] elements, int a, int b) {
            T tmp = elements[a];
            elements[a] = elements[b];
            elements[b] = tmp;
        }

        private static <T> void printArray(T[] elements, char delimiter) {
            String delimiterSpace = delimiter + " ";
            for(int i = 0; i < elements.length; i++) {
                //System.out.print(elements[i] + delimiterSpace);
                //Change this to check if it is possible
                    //If possible change add to array
                
            }
            //System.out.print('\n');
        }
        
}