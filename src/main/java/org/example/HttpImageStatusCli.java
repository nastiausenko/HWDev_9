package org.example;

import java.util.Scanner;

public class HttpImageStatusCli {
    private final HttpStatusImageDownloader downloader = new HttpStatusImageDownloader();
    public void askStatus() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter HTTP status code:");
        while (true) {
            if (scanner.hasNextInt()) {
                int code = scanner.nextInt();
                try {
                    downloader.downloadStatusImage(code);
                    break;
                } catch (Exception e) {
                    System.out.println("There is not image for HTTP status " + code);
                    System.out.println("Please enter valid number: ");
                }
            } else {
                System.out.println("Please enter valid number: ");
                scanner.next();
            }
        }
        scanner.close();
    }
}
