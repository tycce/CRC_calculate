package com.tycce;

public class Main {

    private static final String MESSAGE = "101";
    private static final String POLYNOMIAL = "x4+x+1";

    public static void main(String[] args) {
	    Message message = new Message(MESSAGE); // Сообщение в битовом представлении
	    CRC crc = new CRC(POLYNOMIAL); // Полином

	    Message encodeMessage = crc.encode(message);
        System.out.println(encodeMessage);
    }
}
