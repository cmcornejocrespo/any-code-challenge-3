package com.hmrc.exercise;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.StrictAssertions.assertThat;

/**
 * Created by Carlos.Cornejo on 12/07/2015.
 */
public class CheckoutServiceTest {

    private CheckoutServiceImpl sut;

    @Before
    public void setUp() {
        sut = new CheckoutServiceImpl();
    }

    @Test
    public void shouldCalculateExpectedAmountForListOfOnlyApples() {

        final List<String> order = createShoppingOrder("apple", "apple");

        final String outcome = sut.getPrice(order);

        assertThat(outcome).isEqualTo("£1.20");
    }

    @Test
    public void shouldCalculateExpectedAmountForListOfOnlyOranges() {

        final List<String> order = createShoppingOrder("orange", "orange");

        final String outcome = sut.getPrice(order);

        assertThat(outcome).isEqualTo("£0.40");
    }

    @Test
    public void shouldCalculateExpectedAmountForListOfApplesAndOranges() {

        final List<String> order = createShoppingOrder("orange", "orange","apple");

        final String outcome = sut.getPrice(order);

        assertThat(outcome).isEqualTo("£1.00");
    }

    // test helpers
    private List<String> createShoppingOrder(String... items) {

        final List<String> order = new ArrayList<String>();

        for (String item : items) {

            order.add(item);
        }

        return order;
    }
}
