package com.tycce;

public class CRC {
    private final boolean[] polynomialVector;
    private final int polynomialPower;

    public CRC(String polynomialString) {
        Polynomial polynomial = new Polynomial(polynomialString);
        polynomialVector = polynomial.getVector();
        polynomialPower = polynomial.getPower();
    }

    public Message encode(Message message) {
        boolean[] encoded = new boolean[message.length() + polynomialPower];
        for (int i = 0; i < message.length(); i++) {
            encoded[i] ^= message.getVector()[i];
            if (encoded[i]) {
                for (int j = 0; j < polynomialPower + 1; j++) {
                    encoded[i + j] ^= polynomialVector[j];
                }
            }
        }
        
        System.arraycopy(message.getVector(), 0, encoded, 0, message.length());
        return new Message(encoded);
    }
}
