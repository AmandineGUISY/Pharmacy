package org.Pharmacy;

import java.io.Serializable;

public abstract class Order implements Serializable {

    abstract public void makaOrder(Stock stock);
    abstract public void confirmOrder(Stock stock);
}
