import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DollarTest {

    @Test
    public void testMultiplication() {
        Dollar fiveDollar = new Dollar(5);
        fiveDollar.times(2);
        assertThat(fiveDollar.amount).isEqualTo(10);
    }
}
