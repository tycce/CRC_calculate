package com.tycce;

public class Message {
    private final boolean[] vector;

    public Message(String message) {
        vector = new boolean[message.length()];
        for (int i = 0; i < vector.length; i++) {
            vector[i] = message.charAt(i) == '1';
        }
    }

    public Message(boolean[] vector) {
        this.vector = vector;
    }

    public boolean[] getVector() { return vector; }

    public int length() { return vector.length; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (boolean b : getVector()) {
            sb.append(b ? "1" : "0");
        }
        return sb.toString();
    }
}
