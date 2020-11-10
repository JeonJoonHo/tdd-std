import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DollarTest {

    @Test
    public void testMultiplication() {
        Dollar fiveDollar = new Dollar(5);
        Dollar product = fiveDollar.times(2);
        assertThat(product.amount).isEqualTo(10);

        product = fiveDollar.times(3);
        assertThat(product.amount).isEqualTo(15);
    }
}
