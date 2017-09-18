package gui;

import io.DataLoad;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import system.Store;

/**
 * Groument Coffee 1.0
 * Created by 63263 on 2016/12/27.
 */
public class Start extends Application {

    private Store store;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage sta) throws Exception {
        store = new Store();
        DataLoad.readFileByLines(this.store);
        System.out.println(store.getWarehouse().getProducts().toString());
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Homepage.fxml"));
        Parent root = loader.load();
        HomePageControler controller = loader.getController();
        controller.setStageAndsetListener(sta,this.store);
        Scene scene = new Scene(root, 1090, 890);
        sta.initStyle(StageStyle.DECORATED);
        sta.setScene(scene);
        sta.setTitle("Groument Coffee");
        sta.setResizable(false);
        sta.show();
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }
}

