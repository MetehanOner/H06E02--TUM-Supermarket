package de.tum.in.ase;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;

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

        for(int i = 0; i < checkouts.length-1; i++){


                if (checkouts[i].customerQueueLength() > checkouts[i+1].customerQueueLength())
                {
                    c = checkouts[i+1];
                    //cheapPhone = getPhoneList().get(i);
                    //getPhoneList().set(i, getPhoneList().get(i+1));
                    //getPhoneList().set(i+1, cheapPhone);
                }

        }
        return c;
    }

    public void closeCheckout(int index) {

        if(index < 0 || index >= checkouts.length) {
            throw new IllegalArgumentException();
        }

        Checkout[] neuCheckouts = new Checkout[checkouts.length-1];
        LinkedStack<Customer> stack = new LinkedStack<>();

        for (int i = 0, k = 0; i < checkouts.length; i++) {

            if (i == index) {

                int kalas = checkouts[i].getCustomers().size();
                for(int p = 0; p < kalas; p++) {
                    stack.push(checkouts[i].getCustomers().dequeue());
                }
                continue;
            }

            neuCheckouts[k++] = checkouts[i];
        }

        this.checkouts = neuCheckouts;

        int kiris = stack.size();
        for(int v=0; v<kiris; v++) {
            Checkout c = getCheckoutWithSmallestQueue();
            c.getCustomers().enqueue(stack.pop());
        }

    }

    public void serveCustomers() {

        for (Checkout c: checkouts) {
            c.serveNextCustomer();
        }

    }

    public Checkout[] getCheckouts() {
        return checkouts;
    }

}
