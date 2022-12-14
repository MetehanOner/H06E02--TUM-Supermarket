package de.tum.in.ase;

public class Checkout {

    private Queue<Customer> customers;
    private Queue<Product> bandBeforeCashier;
    private Queue<Product> bandAfterCashier;

    public Checkout() {

        customers = new LinkedQueue<>();
        bandBeforeCashier = new LinkedQueue<>();
        bandAfterCashier = new LinkedQueue<>();

    }

    public int customerQueueLength() {
        return customers.size();
    }

    public void serveNextCustomer() {

        if(customers.isEmpty()) {
            throw new UnsupportedOperationException();
        }

        Customer currentCustomer = customers.dequeue();

        currentCustomer.placeAllProductsOnBand(bandBeforeCashier);

        double sum=0;
        int corner = bandBeforeCashier.size();
        for(int i=0; i<corner; i++) {
            Product temp = bandBeforeCashier.dequeue();
            sum = sum + temp.getPrice();
            bandAfterCashier.enqueue(temp);
        }

        currentCustomer.pay(sum);
        currentCustomer.takeAllProductsFromBand(bandAfterCashier);

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

    /*public static void main(String[] args) {
        Customer c0 = new Customer("feli", 1500);
        Customer c1 = new Customer("mete", 1750);
        Customer c2 = new Customer("freiheit", 5000);

        Product p1 = new Product("yağ", 1000);
        Product p2 = new Product("yağ", 100);
        Product p3 = new Product("yağ", 20);
        Product p4 = new Product("yağ", 50);
        Product p5 = new Product("yağ", 60);

        c0.addProductToBasket(p1);
        c0.addProductToBasket(p2);
        c0.addProductToBasket(p3);

        c1.addProductToBasket(p3);
        c1.addProductToBasket(p4);
        c1.addProductToBasket(p5);

        c2.addProductToBasket(p1);
        c2.addProductToBasket(p4);
        c2.addProductToBasket(p2);

        Checkout checkout = new Checkout();
        checkout.customers.enqueue(c0);
        checkout.customers.enqueue(c1);
        checkout.customers.enqueue(c2);

        checkout.serveNextCustomer();
        checkout.serveNextCustomer();
        checkout.serveNextCustomer();

    }*/
}
