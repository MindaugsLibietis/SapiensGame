package com.example.demo;
import java.util.Collections;
import java.util.List;

public class Attempt {
    int m;
    int p;
    List<Integer> inputs;

    public Attempt(int m, int p, List<Integer> inputs) {
        this.m = m;
        this.p = p;
        this.inputs = inputs;
    }
    public int getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
    }

    public int getP() {
        return p;
    }

    public void setP(int p) {
        this.p = p;
    }

    public List<Integer> getInputs() {
        return inputs;
    }

    public void setInputs(List<Integer> inputs) {
        this.inputs = inputs;
    }

    public void setInputs(int inputs) {
        this.inputs = Collections.singletonList(inputs);
    }
}
