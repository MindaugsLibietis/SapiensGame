package com.example.demo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
    private Integer digit1;
    private Integer digit2;
    private Integer digit3;
    private Integer digit4;

    public List<Integer> generateNumber() {
        List<Integer> secretNum = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            secretNum.add(i);
        }
        //skaitlus mainu ar vietam un izdzesu liekos
        Collections.shuffle(secretNum);
        secretNum.remove(9);
        secretNum.remove(8);
        secretNum.remove(7);
        secretNum.remove(6);
        secretNum.remove(5);
        secretNum.remove(4);
        return secretNum;
    }

    public Attempt play(List<Integer> secretNum) {
        List<Integer> inputs = new ArrayList<>();
        inputs.add(digit1);
        inputs.add(digit2);
        inputs.add(digit3);
        inputs.add(digit4);
        int x = 0;
        int m = 0, p = 0;
        //pārbaudam vai skaitļi ir vienādi un atrodas konkrētajā pozīcijā
        for (int i = 0; i < secretNum.size(); i++) {
            if (secretNum.get(i).equals(inputs.get(i))) {
                p++;
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
/*        System.out.println("inputs: " + attempt.getInputs());
        System.out.println("secret: " + secretNum);*/
        return attempt;
    }
}

