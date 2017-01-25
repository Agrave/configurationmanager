package utils;


public class RandomValue {
    public static String getString(String alphabet, int length) {

        StringBuilder randomString = new StringBuilder("");
        for (int i = 0; i < length; i++) {
            int index = getInt(alphabet.length());
            randomString.append(alphabet.charAt(index));
        }
        return randomString.toString();

    }

    public static String getString(Alphabet alphabet, int length) {
        return getString(alphabet.getAlphabet(), length);
    }

    public static int getInt() {
        return getInt(0, Integer.MAX_VALUE);
    }

    public static int getInt(int lowerBound, int uperBound) {
        if (lowerBound > uperBound) throw new IllegalArgumentException("UperBound must be greater than LowerBound");
        return (int) (lowerBound + Math.random() * (uperBound - lowerBound));
    }

    public static int getInt(int uperBound) {
        return getInt(0, uperBound);
    }
}
