package system;

/**
 * Created by 63263 on 2016/12/23.
 */
public class Coffee extends Product{
    private String origin;
    private String roast;
    private String flavor;
    private String aroma;
    private String acidity;
    private String body;


    public Coffee(String code, double prise, String description, String origin, String roast,String flavor, String aroma, String acidity, String body){
        setCode(code);
        setPrice(prise);
        setDescription(description);
        setOrigin(origin);
        setRoast(roast);
        this.flavor = flavor;
        this.aroma = aroma;
        this.acidity = acidity;
        this.body = body;//9
    }
    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public String getAroma() {
        return aroma;
    }

    public void setAroma(String aroma) {
        this.aroma = aroma;
    }

    public String getAcidity() {
        return acidity;
    }
    public void setAcidity(String acidity) {
        this.acidity = acidity;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getRoast() {
        return roast;
    }

    public void setRoast(String roast) {
        this.roast = roast;
    }

    public String returnString(){
        String s = "\r";
        System.out.println("Saving!!");
        String str = getCode() + s + getPrice() + s+ getDescription() +s+getOrigin()+s+getRoast()+s+getFlavor()+s+getAroma()+s+getAcidity()+s+getBody() ;
//               ;
//                ;
        System.out.println(str);
        return str;
    }
}
