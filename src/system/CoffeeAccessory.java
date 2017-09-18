package system;

/**
 * Created by 63263 on 2016/12/27.
 */
public class CoffeeAccessory extends Product {

    public CoffeeAccessory(String code,double prese,String description){
        setCode(code);
        setPrice(prese);
        this.setDescription(description);
    }

    public String returnString(){
        return getCode()+"\r"+getPrice()+"\r"+getDescription();
    }
}
