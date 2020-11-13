import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DollarTest {

    @Test
    public void testMultiplication() {
        Dollar fiveDollar = new Dollar(5);
        assertThat(fiveDollar.times(2)).isEqualTo(new Dollar(10));
        assertThat(fiveDollar.times(3)).isEqualTo(new Dollar(15));
    }

    @Test
    public void testEquals() {
        Dollar fiveDollar = new Dollar(5);
        assertThat(fiveDollar.equals(new Dollar(5))).isTrue();
        assertThat(fiveDollar.equals(new Dollar(6))).isFalse();
    }
}
