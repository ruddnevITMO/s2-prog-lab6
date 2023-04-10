package ru.rudXson.base;

import ru.rudXson.datatype.Flat;
import ru.rudXson.exceptions.NoPermission;

import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class CLIController {

    private String fileName;
    private PriorityQueue<Flat> flats;
    private Scanner scanner;

    public CLIController(String[] args) throws IOException, NoPermission {
        this.scanner = new Scanner(System.in);
        // check if argument is provided
        if (args.length < 1) {
            System.out.println("No file name provided.");
            System.out.print("Please enter file name: ");
            this.fileName = scanner.nextLine();
        } else {
            this.fileName = args[0];
        }

        // Check if file exists and has write access
        FileValidator.checkFile(this.fileName);

        // Deserialize the file and store the data in a priority queue
        this.flats = Deserializer.deserialize(this.fileName);
        //TODO Error on this (ask for another file)
    }

    // getters and setters
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public PriorityQueue<Flat> getFlats() {
        return flats;
    }

    public void setFlats(PriorityQueue<Flat> flats) {
        this.flats = flats;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }
}
