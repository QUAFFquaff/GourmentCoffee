package system;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
/**
 * Created by 63263 on 2017/1/4.
 */
public class Invoice {
    private String data;
    private ArrayList<Product> ps;
    public Invoice(ArrayList<Product> ps){
        this.ps = ps;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//set layout
        System.out.println(df.format(new Date()));// new Date() get system time
        data = df.format(new Date());
    }
    public String returnString(Product p){
        String str = p.getCode()+"\t"+p.getPrice()+"\t"+p.getDescription();
        return str;
    }

    public ArrayList<Product> getPs() {
        return ps;
    }

    public void setPs(ArrayList<Product> ps) {
        this.ps = ps;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data+'\r';
    }
}
