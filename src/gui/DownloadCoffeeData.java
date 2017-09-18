package gui;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import system.Member;
import system.Product;

/**
 *
 * @author Leo Lv(632633)
 */
public final class DownloadCoffeeData {
    private final SimpleStringProperty code = new SimpleStringProperty();
    private final SimpleStringProperty description = new SimpleStringProperty();
    private final SimpleDoubleProperty price = new SimpleDoubleProperty();
    private final SimpleStringProperty counterOfOrigin = new SimpleStringProperty();
    private final SimpleStringProperty roast = new SimpleStringProperty();
    private final SimpleStringProperty flavor = new SimpleStringProperty();
    private final SimpleStringProperty aroma = new SimpleStringProperty();
    private final SimpleStringProperty acidity = new SimpleStringProperty();
    private final SimpleStringProperty body = new SimpleStringProperty();



    public DownloadCoffeeData(Product coffee) {
        setCode(String.valueOf(coffee.getCode()));
        setDescription(coffee.getDescription());
        setPrice(coffee.getPrice());
//        setRoast(coffee.getRoast());
//        setCounterOfOrigin(coffee.getOrigin());
//        setFlavor(coffee.getFlavor());
//        setAroma(String.valueOf(coffee.getAroma()));
//        setAcidity(coffee.getAcidity());
//        setBody(coffee.getBody());
    }

    public DownloadCoffeeData(Member m){
        setCode(m.getUsename());
        setPrice(m.getAccount());
    }

    public String getCode() {
        return code.get();
    }

    public SimpleStringProperty codeProperty() {
        return code;
    }

    public void setCode(String code) {
        this.code.set(code);
    }

    public String getDescription() {
        return description.get();
    }

    public SimpleStringProperty descriptionProperty() {
        return description;
    }

    public void setDescription(String description) {
        this.description.set(description);
    }

    public String getCounterOfOrigin() {
        return counterOfOrigin.get();
    }

    public SimpleStringProperty counterOfOriginProperty() {
        return counterOfOrigin;
    }

    public void setCounterOfOrigin(String counterOfOrigin) {
        this.counterOfOrigin.set(counterOfOrigin);
    }

    public void setFlavor(String flavor) {
        this.flavor.set(flavor);
    }

    public String getFlavor() {
        return flavor.get();
    }

    public SimpleStringProperty flavorProperty() {
        return flavor;
    }

    public String getAroma() {
        return aroma.get();
    }

    public SimpleStringProperty aromaProperty() {
        return aroma;
    }

    public void setAroma(String aroma) {
        this.aroma.set(aroma);
    }

    public String getAcidity() {
        return acidity.get();
    }

    public SimpleStringProperty acidityProperty() {
        return acidity;
    }

    public void setAcidity(String acidity) {
        this.acidity.set(acidity);
    }

    public String getBody() {
        return body.get();
    }

    public SimpleStringProperty bodyProperty() {
        return body;
    }

    public void setBody(String body) {
        this.body.set(body);
    }

    public double getPrice() {
        return price.get();
    }

    public SimpleDoubleProperty priseProperty() {
        return price;
    }

    public void setPrice(double price) {
        this.price.set(price);
    }

    public String getRoast() {
        return roast.get();
    }

    public SimpleStringProperty roastProperty() {
        return roast;
    }

    public void setRoast(String roast) {
        this.roast.set(roast);
    }


}