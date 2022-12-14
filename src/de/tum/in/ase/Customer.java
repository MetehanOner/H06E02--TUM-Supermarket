package de.tum.in.ase;

public class Customer {
    //TODO Add attribute productsInBasket
    private String name;
    private double money;

    private Stack<Product> productsInBasket;

    public Customer(String name, double money) {
        //TODO initialize attributes, throw exceptions
        if(name==null){
            throw new IllegalArgumentException();
        } else {
            this.name = name;
        }

        if(money<0){
            throw new IllegalArgumentException();
        } else {
            this.money = money;
        }

        productsInBasket = new LinkedStack<>();
    }

    public String getName() {
        return name;
    }

    public double getMoney() {
        return money;
    }

    //TODO implement methods
    public boolean hasMoney(){
        return money > 0;
    }

    public void addProductToBasket(Product product){

        productsInBasket.push(product);

    }

    public void placeAllProductsOnBand(Queue<Product> band){

        int corner = productsInBasket.size();

        for(int i = 0; i < corner; i++) {

            band.enqueue(productsInBasket.pop());

        }

    }

    public void takeAllProductsFromBand(Queue<Product> band){

        int corner = band.size();

        for(int i = 0; i < corner; i++) {

            productsInBasket.push(band.dequeue());

        }

    }

    public void pay(double amount){

        if(amount > money || amount < 0) {
            throw new UnsupportedOperationException();
        }

        money = money - amount;

    }

    public void goToCheckout(TUMSupermarket supermarket){

        if(supermarket==null) {
            throw new IllegalArgumentException();
        }

        Checkout c = supermarket.getCheckoutWithSmallestQueue();

        c.getCustomers().enqueue(this);

    }

    // TODO uncomment this method after you implemented all attributes

    @Override
    public String toString() {
        return "Customer: " + name + ", money: " + money + "\n" + productsInBasket;
    }

    public Stack<Product> getProductsInBasket() {
        return productsInBasket;
    }

}
