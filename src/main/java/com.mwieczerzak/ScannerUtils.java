package com.mwieczerzak;

import java.util.Scanner;

public class ScannerUtils {

    private Scanner scanner;

    public ScannerUtils(Scanner scanner) {
        this.scanner = scanner;
    }

    public int readInt(int max) {
        while (true) {
            try {
                int menuPosition = Integer.parseInt(scanner.nextLine());
                if (menuPosition >= 1 && menuPosition <= max) {
                    return menuPosition;
                }
            } catch (NumberFormatException e) {
            }
            System.out.println("You have to type number from 1 to " + max + ".");
        }
    }
}
