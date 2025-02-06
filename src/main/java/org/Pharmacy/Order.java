package org.Pharmacy;

import java.util.ArrayList;

public abstract class Order {

    abstract public void makaOrder(Stock stock);
    abstract public void confirmOrder(Stock stock);
}
