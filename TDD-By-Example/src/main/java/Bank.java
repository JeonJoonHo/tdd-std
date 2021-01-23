public class Bank {

    public Bank() {

    }

    public Money reduce(Expression source, String to) {
        return source.reduce(to);
    }
}
