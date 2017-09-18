package system;

import java.util.ArrayList;

/**
 * Created by 63263 on 2016/12/30.
 */
public class Store {
    private Warehouse warehouse;
    private Manager manager;

    private ArrayList<Invoice> invoices;
    public Store(){
        warehouse = new Warehouse();
        manager = new Manager();
        invoices = new ArrayList<>();
    }

    public void addInv(Invoice inv){
        invoices.add(inv);
    }
    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public ArrayList<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(ArrayList<Invoice> ins) {
        this.invoices = ins;
    }
}
