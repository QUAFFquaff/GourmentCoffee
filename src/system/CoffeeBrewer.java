package system;

/**
 * Created by 63263 on 2016/12/27.
 */
public class CoffeeBrewer extends Product{
    private String modelOfBrewer;
    private String waterSupply;
    private int capacity;

    public CoffeeBrewer(String code,double prise,String description,String modelOfBrewer,String waterSupply,int capacity){
        this.setCode(code);
        this.setPrice(prise);
        this.setDescription(description);
        this.modelOfBrewer = modelOfBrewer;
        this.waterSupply = waterSupply;
        this.capacity = capacity;
    }
    public String returnString(){
        String s = "\r";
        String str = getCode() + s +getPrice()+s+getDescription()+s+getModelOfBrewer()+s+getWaterSupply()+s+getCapacity();
        return str;

    }

    public String getModelOfBrewer() {
        return modelOfBrewer;
    }

    public void setModelOfBrewer(String modelOfBrewer) {
        this.modelOfBrewer = modelOfBrewer;
    }

    public String getWaterSupply() {
        return waterSupply;
    }

    public void setWaterSupply(String waterSupply) {
        this.waterSupply = waterSupply;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
