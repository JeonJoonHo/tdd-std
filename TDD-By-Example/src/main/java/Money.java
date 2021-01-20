abstract class Money {
    protected int amount;

    abstract Money times(int multiplier);

    static Money dollar(int amount) {
        return new Dollar(amount);
    }

    static Money franc(int amount) {
        return new Franc(amount);
    }

    public boolean equals(Object object) {
        Money money = (Money) object;
        return this.amount == money.amount
                && money.getClass().equals(this.getClass());
    }
}
