package utils;

/**
 * Created by Rabot'aga on 03.01.2017.
 */
public enum Alphabet {
    ALPHA("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"),
    NUMERIC("0123456789"),
    ALPHANUMERIC(ALPHA.getAlphabet() + NUMERIC.getAlphabet());

    private String alphabet;

    Alphabet(String alphabet) {
        this.alphabet = alphabet;
    }

    public String getAlphabet() {
        return alphabet;
    }
}
