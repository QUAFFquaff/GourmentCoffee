package system;

import java.util.HashMap;

/**
 * Created by 63263 on 2016/12/27.
 */
public class Warehouse {
    private HashMap<String,Coffee> coffees;
    private HashMap<String,CoffeeBrewer> brewers;
    private HashMap<String,CoffeeAccessory> accessorys;
    private HashMap<String,Product> products;
    public Warehouse(){
        coffees = new HashMap<>();
        brewers = new HashMap<>();
        accessorys = new HashMap<>();
        products = new HashMap<>();
    }
    public void add(Coffee coffee){
        products.put(coffee.getCode(),coffee);
        coffees.put(coffee.getCode(),coffee);
    }
    public void add(CoffeeBrewer cb){
        products.put(cb.getCode(),cb);
        brewers.put(cb.getCode(),cb);
    }
    public void add(CoffeeAccessory coffeeAccessory){
        products.put(coffeeAccessory.getCode(),coffeeAccessory);
        accessorys.put(coffeeAccessory.getCode(),coffeeAccessory);
    }

    public HashMap<String, Product> getProducts() {
        return products;
    }

    public HashMap<String, Coffee> getCoffees() {
        return coffees;
    }

    public void setCoffees(HashMap<String, Coffee> coffees) {
        this.coffees = coffees;
    }

    public HashMap<String, CoffeeBrewer> getBrewers() {
        return brewers;
    }

    public void setBrewers(HashMap<String, CoffeeBrewer> brewers) {
        this.brewers = brewers;
    }

    public HashMap<String, CoffeeAccessory> getAccessorys() {
        return accessorys;
    }

    public void setAccessorys(HashMap<String, CoffeeAccessory> accessorys) {
        this.accessorys = accessorys;
    }

    public void setProducts(HashMap<String, Product> products) {
        this.products = products;
    }
}
