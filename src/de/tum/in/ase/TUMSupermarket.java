package de.tum.in.ase;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class TUMSupermarket {

    private Checkout[] checkouts;


    public TUMSupermarket(int number){

        if(number <= 0){
            throw new IllegalArgumentException();
        } else {
            this.checkouts = new Checkout[number];
            for(int i = 0; i < number; i++){

                Checkout c = new Checkout();
                checkouts[i] = c;

            }
        }

    }

    public Checkout getCheckoutWithSmallestQueue(){

        Checkout c = new Checkout();

        for(int x = 0; x < checkouts.length; x++){

            for (int i=0; i < checkouts.length - x - 1 ; i++) {
                if (checkouts[i].customerQueueLength() > checkouts[i+1].customerQueueLength())
                {
                    c = checkouts[i+1];
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

    public Checkout[] getCheckouts() {
        return checkouts;
    }
}
