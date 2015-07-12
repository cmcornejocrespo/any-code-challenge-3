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

        final List<String> order = new ArrayList<String>();
        order.add("apple");
        order.add("apple");

        final String outcome = sut.getPrice(order);

        assertThat(outcome).isEqualTo("£1.30");
    }
}
