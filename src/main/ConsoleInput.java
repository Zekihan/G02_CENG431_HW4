package main;

import java.util.Scanner;

public class ConsoleInput implements Input{

    private Scanner scanner;

    public ConsoleInput(Scanner scanner){
        this.scanner = scanner;
    }

    @Override
    public String readString() {
        return scanner.nextLine();
    }

    @Override
    public int readInt() {
        return scanner.nextInt();
    }

    @Override
    public void closeInputStream(){
        scanner.close();
    }
}
