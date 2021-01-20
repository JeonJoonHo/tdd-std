import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FrancTest {

    @Test
    public void testMultiplication() {
        Franc fiveFranc = new Franc(5);
        assertThat(fiveFranc.times(2)).isEqualTo(new Franc(10));
        assertThat(fiveFranc.times(3)).isEqualTo(new Franc(15));
    }

    @Test
    public void testEquals() {
        Dollar fiveDollar = new Dollar(5);
        assertThat(fiveDollar.equals(new Dollar(5))).isTrue();
        assertThat(fiveDollar.equals(new Dollar(6))).isFalse();
    }
}
