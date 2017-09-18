package system;

import com.sun.corba.se.spi.ior.ObjectKey;

/**
 * Created by 63263 on 2016/12/27.
 */
public class Product {
    private String code;
    private String description;
    private double price;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
