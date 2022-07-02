package com.example.demo;

import org.springframework.boot.SpringApplication;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TheGame {
    public Integer getDigit1() {
        return digit1;
    }

    public void setDigit1(Integer digit1) {
        this.digit1 = digit1;
    }

    public Integer getDigit2() {
        return digit2;
    }

    public void setDigit2(Integer digit2) {
        this.digit2 = digit2;
    }

    public Integer getDigit3() {
        return digit3;
    }

    public void setDigit3(Integer digit3) {
        this.digit3 = digit3;
    }

    public Integer getDigit4() {
        return digit4;
    }

    public void setDigit4(Integer digit4) {
        this.digit4 = digit4;
    }

    public List<Attempt> getAttempts() {
        return attempts;
    }

    private List<Integer> secretNum = new ArrayList<>();
    private List<Attempt> attempts = new ArrayList<>();
    private Integer digit1;
    private Integer digit2;
    private Integer digit3;
    private Integer digit4;

    public void play() {

        List<Integer> inputs = new ArrayList<>();
        inputs.add(digit1);
        inputs.add(digit2);
        inputs.add(digit3);
        inputs.add(digit4);
        int x = 0;
        boolean won = false;
        int m = 0, p = 0;
        //pārbaudam vai skaitļi ir vienādi un atrodas konkrētajā pozīcijā
        for (int i = 0; i < secretNum.size(); i++) {
            if (secretNum.get(i).equals(inputs.get(i))) {
                p++;
                if (p == 4) {
                    System.out.println("Congrats, you won");
                    won = true;
                    break;
                }
            }
        }
        for (int i = 0; i < secretNum.size(); i++) {
            for (int j = 0; j < inputs.size(); j++) {
                if (i == j) {
                    continue;
                } else if (secretNum.get(i).equals(inputs.get(j))) {
                    m++;
                }
            }
        }
        x++;
        Attempt attempt = new Attempt(m, p, inputs);
        System.out.println(attempt.getM());
        System.out.println(attempt.getP());
        System.out.println(attempt.getInputs());
        this.attempts.add(attempt);
        m = 0;
        p = 0;
//        inputs.removeAll(inputs);
    }

    public void generateNumber() {
        for (int i = 0; i < 10; i++) {
            secretNum.add(i);
        }
        //skaitlus mainam ar vietam un izdzesam liekos
        Collections.shuffle(secretNum);
        secretNum.remove(9);
        secretNum.remove(8);
        secretNum.remove(7);
        secretNum.remove(6);
        secretNum.remove(5);
        secretNum.remove(4);
    }
}
