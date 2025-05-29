package org.y2022.day7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Day7 {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new FileReader("lib/src/main/java/org/y2022/resources/day7.txt"));

        DirectoryEntry rootDirectory = new DirectoryEntry(null,"/");
        DirectoryEntry currentDirectory = rootDirectory;

        List<DirectoryEntry> allDirectories = new ArrayList<>();

        String line;
        while ((line = br.readLine()) != null) {
            String[] linearr = line.split(" ");
            if ("$".equals(linearr[0])) {
                if ("cd".equals(linearr[1])) {
                    if ("/".equals(linearr[2])) {
                        currentDirectory = rootDirectory;
                    } else if ("..".equals(linearr[2])) {
                        currentDirectory = currentDirectory.getParent();
                    } else {
                        currentDirectory = currentDirectory.getDir(linearr[2]);
                    }
                }
            } else if ("dir".equals(linearr[0])) {
                DirectoryEntry de = new DirectoryEntry(currentDirectory, linearr[1]);
                currentDirectory.addFile(de);
                allDirectories.add(de);
            } else {
                currentDirectory.addFile(new FileEntry(linearr[1], Long.parseLong(linearr[0])));
            }
        }

        int total = 0;
        for (DirectoryEntry dir : allDirectories){
            if (dir.size() < 100000){
                total += dir.size();
            }
        }

        long sizeOfRoot = rootDirectory.size();
        long spaceLeft = 70000000 - sizeOfRoot;
        long spaceToRemove = 30000000 - spaceLeft;

        List<DirectoryEntry> candidates = new ArrayList<>();

        long count = 0;
        for (DirectoryEntry de : allDirectories) {
            if (de.size() > spaceToRemove) {
                candidates.add(de);
            }
        }

        candidates.add(rootDirectory);

        candidates.sort((a, b) -> (int)(a.size() - b.size()));

        System.out.println(total);
        System.out.println(candidates.get(0).size());
    }
}