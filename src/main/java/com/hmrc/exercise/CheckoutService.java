package com.hmrc.exercise;

import java.util.List;

/**
 * Created by Carlos.Cornejo on 12/07/2015.
 */
public interface CheckoutService {

    String getPrice(List<String> products);
}
