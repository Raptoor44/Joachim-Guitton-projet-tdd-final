package org.example.service.verify;

import org.example.exceptions.InvalidCharacterException;
import org.example.exceptions.InvalidIsbnLenghtException;

public class IsbnValidator {

    /**
     * Cette méthode vérifie qu'un ISBN est valide
     *
     * @param isbn isbn à vérifier
     * @return true si l'isbn est valide et existe.
     */
    public boolean validateISBN(String isbn) throws InvalidIsbnLenghtException, InvalidCharacterException {

        int total = 0;

        int length = verifyLength(isbn);

        if (length == 10) {
            for (int i = 0; i < 10; i++) {
                char digit = isbn.charAt(i);
                if (i == 9 && digit == 'X') {
                    total += 10;
                } else if (Character.isDigit(digit)) {
                    total += Character.getNumericValue(digit) * (10 - i);
                } else {
                    throw new InvalidCharacterException();
                }
            }
            int modRes = total % 11;
            return modRes == 0;
        } else if (length == 13) {
            for (int i = 0; i < 13; i++) {
                char digit = isbn.charAt(i);
                if (Character.isDigit(digit)) {
                    total += Character.getNumericValue(digit) * ((i % 2 == 0) ? 1 : 3);
                } else {
                    throw new InvalidCharacterException();
                }
            }
            int modRes = total % 10;
            return modRes == 0;
        } else {
            throw new InvalidIsbnLenghtException();
        }
    }

    private int verifyLength(String isbn) {
        int length = isbn.length();
        if (length != 10 && length != 13) {
            throw new InvalidIsbnLenghtException();
        }
        return length;
    }
}
