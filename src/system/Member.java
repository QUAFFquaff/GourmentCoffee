package system;

/**
 * Created by 63263 on 2016/12/23.
 */
public class Member {
    private String usename;
    private String password;
    private double account;
    private String address;

    public Member(String name, String password,double account,String address){
        this.usename = name;
        this.password = password;
        this.account = account;
        this.address = address;
    }
    public String returnString(){
        String str = "M" + "\r" + usename + "\r" + password + "\r" + account +"\r" +address;
        return str;
    }
    public String getUsename() {
        return usename;
    }

    public void setUsename(String usename) {
        this.usename = usename;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getAccount() {
        return account;
    }

    public void setAccount(double account) {
        this.account = account;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
