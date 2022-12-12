package de.tum.in.ase;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class TUMSupermarket {

    private List<Checkout> checkouts = new ArrayList<>();


    public TUMSupermarket(int a){

        if(a <= 0){
            throw new IllegalArgumentException();
        } else {
            this.checkouts = new ArrayList<>();
            Checkout checkout = new Checkout();
            checkouts.add(checkout);
        }

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

    public List<Checkout> getCheckouts() {
        return checkouts;
    }
}
