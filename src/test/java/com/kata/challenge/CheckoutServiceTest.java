package com.kata.challenge;

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
    public void shouldApplyAppleOfferForListOfOnlyApples() {

        final List<String> order = createShoppingOrder("apple", "apple");

        final String outcome = sut.getPrice(order);

        assertThat(outcome).isEqualTo("£0.60");
    }

    @Test
    public void shouldApplyOrangeOfferForListOfOnlyOranges() {

        final List<String> order = createShoppingOrder("orange", "orange","orange");

        final String outcome = sut.getPrice(order);

        assertThat(outcome).isEqualTo("£0.50");
    }

    @Test
    public void shouldApplyAppleOfferForListOfApplesAndOranges() {

        final List<String> order = createShoppingOrder("apple","apple", "orange","apple");

        final String outcome = sut.getPrice(order);

        assertThat(outcome).isEqualTo("£1.45");
    }

    @Test
    public void shouldApplyOrangeOfferForListOfApplesAndOranges() {

        final List<String> order = createShoppingOrder("orange","orange", "orange","apple");

        final String outcome = sut.getPrice(order);

        assertThat(outcome).isEqualTo("£1.10");
    }

    @Test
    public void shouldApplyAppleAndOrangeOffersForListOfApplesAndOranges() {

        final List<String> order = createShoppingOrder("orange","orange", "orange","apple","apple");

        final String outcome = sut.getPrice(order);

        assertThat(outcome).isEqualTo("£1.10");
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
