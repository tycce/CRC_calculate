package com.tycce;

import java.util.Arrays;
import java.util.Collections;

public class Polynomial {
    private final int power;
    private final boolean[] vector;

    public Polynomial(String polynomialString) {
        String[] terms = polynomialString.split("\\+");
        for (int i = 0; i < terms.length; i++) {
            terms[i] = terms[i].trim().replace("x", "");
            terms[i] = terms[i].equals("") ? "1" : terms[i].equals("1") ? "0" : terms[i];
        }
        Arrays.sort(terms, Collections.reverseOrder());
        this.power = Integer.parseInt(terms[0]);

        this.vector = new boolean[getPower() + 1];
        for (String term : terms) {
            vector[getPower() - Integer.parseInt(term)] = true;
        }
    }

    public Polynomial(boolean[] vector) {
        this.vector = vector;
        this.power = vector.length - 1;
    }

    public int getPower() {
        return this.power;
    }

    public boolean[] getVector() {
        return this.vector;
    }

}
