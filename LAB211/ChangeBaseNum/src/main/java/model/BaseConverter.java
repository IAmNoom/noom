package model;

import java.math.BigInteger;

public class BaseConverter {

    // Convert value (string) from inBase to outBase, supports bases 2,10,16
    public static String convert(String value, int inBase, int outBase) {
        if (value == null || value.trim().isEmpty()) 
            throw new IllegalArgumentException("Empty input");
        String v = value.trim();

        // validate input according to inBase
        switch (inBase) {
            case 2:
                if (!v.matches("[01]+")) throw new IllegalArgumentException("Binary must contain only 0 or 1");
                break;
            case 10:
                if (!v.matches("\\d+")) throw new IllegalArgumentException("Decimal must contain only digits");
                break;
            case 16:
                if (!v.matches("[0-9A-Fa-f]+")) throw new IllegalArgumentException("Hex must contain 0-9 or A-F");
                break;
            default:
                throw new IllegalArgumentException("Unsupported base: " + inBase);
        }

        BigInteger big = new BigInteger(v, inBase);
        return big.toString(outBase).toUpperCase();
    }
}
