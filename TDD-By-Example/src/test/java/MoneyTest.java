import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MoneyTest {

    @Test
    public void testEquality() {
        assertThat(Money.dollar(5).equals(Money.dollar(5))).isTrue();
        assertThat(Money.dollar(5).equals(Money.dollar(6))).isFalse();
        assertThat(Money.franc(5).equals(Money.franc(5))).isTrue();
        assertThat(Money.franc(5).equals(Money.franc(6))).isFalse();
        assertThat(Money.dollar(5).equals(Money.franc(5))).isFalse();
    }

    @Test
    public void testDifferentClassEquality() {
        assertThat(new Money(10, "CHF").equals(new Franc(10, "CHF"))).isTrue();
    }
}
