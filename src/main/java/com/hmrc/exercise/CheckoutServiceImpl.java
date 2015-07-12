package com.hmrc.exercise;

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

        for (String product : products) {

            total += 0.65;
        }

        Double currencyAmount = new Double(total);

        return currencyFormatter.format(currencyAmount);
    }
}
