package app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import entities.LogEntry;

public class Main {

    public static void main(String[] args) {
        
        String path = "/home/lucas/eclipse-workspace/set1-java/input.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(path))){
            
            Set<LogEntry> set = new HashSet<>();

            String line = br.readLine();
            while (line != null) {
                String[] fields = line.split(" ");
                String username = fields[0];
                Date moment = Date.from(Instant.parse(fields[1]));

                set.add(new LogEntry(username, moment));

                line = br.readLine();
            }

            System.out.println("Total users: " + set.size());

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}