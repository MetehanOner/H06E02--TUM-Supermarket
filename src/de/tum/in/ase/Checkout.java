package de.tum.in.ase;

public class Checkout {

    private Queue<Customer> customers;
    public Queue<Product> bandBeforeCashier;
    public Queue<Product> bandAfterCashier;

    public Checkout(){

        customers = new LinkedQueue<>();
        bandBeforeCashier = new LinkedQueue<>();
        bandAfterCashier = new LinkedQueue<>();

    }

    public int customerQueueLength(){
        return customers.size();
    }

    public void serveNextCustomer(){

        if(customers.isEmpty()){
            throw new UnsupportedOperationException();
        }

        Customer nCustomer = customers.dequeue();

        nCustomer.placeAllProductsOnBand(bandBeforeCashier);

        /*for(int i = nCustomer.getProductsInBasket().size(); i == 0; i--){

            bandBeforeCashier.enqueue(nCustomer.getProductsInBasket().pop());

        }*/

        double sum = 0;
        for(int i = 0; i < bandBeforeCashier.size(); i++){

            Product next = bandBeforeCashier.dequeue();
            sum = sum + next.getPrice();
            bandAfterCashier.enqueue(next);
        }

        nCustomer.takeAllProductsFromBand(bandAfterCashier);
        nCustomer.pay(sum);

    }

    public Queue<Customer> getCustomers() {
        return customers;
    }

    public Queue<Product> getBandAfterCashier() {
        return bandAfterCashier;
    }

    public Queue<Product> getBandBeforeCashier() {
        return bandBeforeCashier;
    }
}
