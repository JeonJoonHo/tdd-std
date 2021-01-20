abstract class Money {
    protected int amount;
    protected String currency;

    static Money dollar(int amount) {
        return new Dollar(amount, "USD");
    }

    static Money franc(int amount) {
        return new Franc(amount, "CHF");
    }

    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    String currency() {
        return currency;
    }

    abstract Money times(int multiplier);

    public boolean equals(Object object) {
        Money money = (Money) object;
        return this.amount == money.amount
                && money.getClass().equals(this.getClass());
    }
}
