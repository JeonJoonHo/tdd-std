import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DollarTest {

    @Test
    public void testMultiplication() {
        Money fiveDollar = Money.dollar(5);
        assertThat(fiveDollar.times(2)).isEqualTo(Money.dollar(10));
        assertThat(fiveDollar.times(3)).isEqualTo(Money.dollar(15));
    }

    @Test
    public void testEquals() {
        Money fiveDollar = Money.dollar(5);
        assertThat(fiveDollar.equals(Money.dollar(5))).isTrue();
        assertThat(fiveDollar.equals(Money.dollar(6))).isFalse();
    }
}
