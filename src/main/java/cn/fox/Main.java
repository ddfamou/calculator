package cn.fox;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        Calculator cal = new Calculator();
        Scanner sc = new Scanner( System.in );
        String line = sc.nextLine();
        while (!line.equals("quit")) {
            cal.run(line);
            System.out.println(cal.output());
            line = sc.nextLine();
        }

    }

}
