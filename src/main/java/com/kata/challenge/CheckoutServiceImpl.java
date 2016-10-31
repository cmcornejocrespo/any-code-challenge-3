package com.kata.challenge;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import static java.text.NumberFormat.getCurrencyInstance;

/**
 * Created by Carlos.Cornejo on 12/07/2015.
 */
public class CheckoutServiceImpl implements CheckoutService {

    private final Locale enGBLocale =
            new Locale.Builder().setLanguage("en").setRegion("GB").build();

    private final NumberFormat currencyFormatter = getCurrencyInstance(enGBLocale);

    public String getPrice(List<String> products) {

        double total = 0.0;
        int apples = 0, oranges = 0;

        for (String product : products) {

            if (product.equals("apple")) {

                apples++;
            } else {

                oranges++;
            }
        }

        final String totalPrice = getPriceAfterOffers(apples, oranges);

        return totalPrice;
    }

    private String getPriceAfterOffers(int apples, int oranges) {

        final double applePrice = 0.60;
        final double orangePrice = 0.25;

        final boolean applyAppleOffer = apples % 2 == 0;
        double totalApples = (apples / 2) * applePrice;

        if (!applyAppleOffer) {

            totalApples += applePrice;
        }

        double totalOranges = oranges * orangePrice;

        totalOranges -= (oranges / 3) * orangePrice;

        Double currencyAmount = new Double(totalApples + totalOranges);

        return currencyFormatter.format(currencyAmount);
    }
}
