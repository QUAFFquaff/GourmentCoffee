package gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import system.Member;
import system.Store;

/**
 * Created by 63263 on 2017/1/2.
 */
public class AddMemberController {

    private Stage stage;
    private Store store;
    private HomePageControler h;
    @FXML Button submit;
    @FXML TextField code;
    @FXML TextField password;
    @FXML TextField address;
    @FXML TextField account;


    public void setStageAndsetListener(Stage stageAndsetListener,Store store,HomePageControler h) {
        this.h = h;
        this.stage = stageAndsetListener;
        this.store = store;
    }
    public void handleSubmitButton(){
        Member m = new Member(code.getText(),password.getText(),Double.valueOf(account.getText()),address.getText());
        store.getManager().getMembers().put(m.getUsename(),m);
        stage.hide();
        h.refersh();
    }
}
