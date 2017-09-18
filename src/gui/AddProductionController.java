package gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import system.*;

import java.io.IOException;

/**
 * Created by 63263 on 2016/12/30.
 */
public class AddProductionController {

    @FXML Button submit;
    @FXML TextField code;
    @FXML TextField prise;
    @FXML TextArea description;
    @FXML TextField origin;
    @FXML TextField roast;
    @FXML TextField flavor;
    @FXML TextField aroma;
    @FXML TextField acidity;
    @FXML TextField body;
    @FXML TextField model;
    @FXML TextField waterSupply;
    @FXML TextField capacity;

    private Stage stage;
    private Store store;
    private HomePageControler h;


    public void handleSubmitButton() throws IOException {
        handleData();
        this.stage.hide();
        h.refersh();
    }

    public void setStageAndsetListener(Stage stageAndsetListener,Store store,HomePageControler h) {
//        this.old = oldStage;
        this.h = h;
        this.stage = stageAndsetListener;
        this.store = store;
    }
    public void handleData(){
        String str = code.getText();
        System.out.println(str.substring(0,1));
        switch(str.substring(0,1)) {
            case "C":
                addCoffee();
                break;
            case "A":
                addCoffeeAccessory();
                break;
            case "B":
                addCoffeeBrewer();
                break;
            default:
                alert();
                System.out.println("Error!!");
                break;
        }

    }

    public void addCoffee(){
        Coffee coffee = new Coffee(code.getText(),Double.valueOf(prise.getText()),description.getText(),origin.getText(),roast.getText(),flavor.getText(),aroma.getText(),acidity.getText(),body.getText());
        store.getWarehouse().add(coffee);
        System.out.println(coffee.getCode());
    }

    public void addCoffeeAccessory(){
        CoffeeAccessory ca = new CoffeeAccessory(code.getText(),Double.valueOf(prise.getText()),description.getText());
        store.getWarehouse().add(ca);
        System.out.println(ca.getCode());
    }

    public void addCoffeeBrewer(){
        CoffeeBrewer cb = new CoffeeBrewer(code.getText(),Double.valueOf(prise.getText()),description.getText(),model.getText(),waterSupply.getText(),Integer.valueOf(capacity.getText()));
        store.getWarehouse().add(cb);
        System.out.println(cb.getCode());
    }

    public void alert(){

    }

}
