package org.Pharmacy;

import java.util.ArrayList;

public class Standard extends Order{

    public Standard(ArrayList<String> orderItems, double quantity, double totalPrice) {
        super(orderItems, quantity, totalPrice);
    }

    @Override
    void makaOrder() {

    }

    @Override
    void verifyOrder() {

    }
}
