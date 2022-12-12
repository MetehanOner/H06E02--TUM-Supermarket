package de.tum.in.ase;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class TUMSupermarket {

    List<Checkout> checkouts;

    public TUMSupermarket(List<Checkout> checkouts){

        if(checkouts.size() <= 0){
            this.checkouts = new ArrayList<>();
            Checkout checkout = new Checkout();
            checkouts.add(checkout);
            throw new IllegalArgumentException();
        }

        this.checkouts = checkouts;

    }

    public Checkout getCheckoutWithSmallestQueue(){

        Checkout c = new Checkout();

        for(int x = 0; x < checkouts.size(); x++){

            for (int i=0; i < checkouts.size() - x - 1 ; i++) {
                if (checkouts.get(i).customerQueueLength() > checkouts.get(i+1).customerQueueLength())
                {
                    c = checkouts.get(i+1);
                    //cheapPhone = getPhoneList().get(i);
                    //getPhoneList().set(i, getPhoneList().get(i+1));
                    //getPhoneList().set(i+1, cheapPhone);
                }
            }
        }
        return c;
    }

    public void closeCheckout(int a){

    }

    public void serveCustomers(){

        for (Checkout c: checkouts) {
            c.serveNextCustomer();
        }

    }
}
