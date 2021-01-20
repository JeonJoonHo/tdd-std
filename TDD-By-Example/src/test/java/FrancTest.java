import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FrancTest {

    @Test
    public void testMultiplication() {
        Money fiveFranc = Money.franc(5);
        assertThat(fiveFranc.times(2)).isEqualTo(Money.franc(10));
        assertThat(fiveFranc.times(3)).isEqualTo(Money.franc(15));
    }

    @Test
    public void testEquals() {
        Money fiveFranc = Money.franc(5);
        assertThat(fiveFranc.equals(Money.franc(5))).isTrue();
        assertThat(fiveFranc.equals(Money.franc(6))).isFalse();
    }
}
