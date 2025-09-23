package model;

public enum Operator {
    ADD("+"), SUB("-"), MUL("*"), DIV("/"), POW("^"), EQUAL("=");

    private final String symbol;

    Operator(String symbol) {
        this.symbol = symbol;
    }

    public static Operator fromString(String s) {
        for (Operator op : values()) {
            if (op.symbol.equals(s)) return op;
        }
        return null;
    }
}
