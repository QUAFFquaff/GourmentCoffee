package gui;

import io.DataSave;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import system.*;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by 63263 on 2016/12/27.
 */
public class HomePageControler {

    private ObservableList<DownloadCoffeeData> data = FXCollections.observableArrayList();
    private ObservableList<DownloadCoffeeData> data2;
    private ObservableList<DownloadCoffeeData> data3 = FXCollections.observableArrayList();
    private ArrayList<Product> ps;
    private Stage stage;
    private Store store;
    @FXML Text gp00;
    @FXML Text gp01;
    @FXML Text gp02;
    @FXML Text gp10;
    @FXML Text gp11;
    @FXML Text gp12;
    @FXML Text gp30;
    @FXML Text gp31;
    @FXML Text gp32;
    @FXML Text gp40;
    @FXML Text gp41;
    @FXML Text gp42;
    @FXML Button addMember;
    @FXML Button addProduction;
    @FXML Button exit;
    @FXML Button showInvoices;
    @FXML Button buy;
    @FXML Button confirm;
    @FXML Button remove;
    @FXML MenuItem about;
    @FXML MenuItem close;
    @FXML MenuItem delete;
    @FXML MenuItem web;
    @FXML TextField buyCode;
    @FXML TableView<DownloadCoffeeData> productsTable;
    @FXML TableColumn<DownloadCoffeeData, String> productsCode;
    @FXML TableColumn<DownloadCoffeeData, Double> productsPrise;
    @FXML TableColumn<DownloadCoffeeData, String> productDescription;
    @FXML TableView<DownloadCoffeeData> enrollProductsTable2;
    @FXML TableColumn<DownloadCoffeeData, String> enrollCode;
    @FXML TableColumn<DownloadCoffeeData, Double> enrollPrise;
    @FXML TableColumn<DownloadCoffeeData, String> enrollDescription;
    @FXML TableView<DownloadCoffeeData> memberTable3;
    @FXML TableColumn<DownloadCoffeeData, String> memberCode;
    @FXML TableColumn<DownloadCoffeeData, Double> memberAccount;

    /**
     * exit system, save data
     */
    public void handleExit(){

        DataSave.saveProduct(store);
        System.exit(0);
    }

    /**
     * handle close button, close program and save data
     */
    public void handleClose(){
        this.handleExit();
    }

    /**
     * handle about button
     * @throws IOException
     */
    public void handleAbout() throws IOException {
        Stage sta=new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("about.fxml"));
        Parent root = loader.load();
        aboutController controller = loader.getController();

        controller.setStageAndsetListener(sta);
        Scene scene = new Scene(root, 550, 260);
        sta.initStyle(StageStyle.DECORATED);
        sta.setScene(scene);
        sta.setTitle("About");
        sta.setResizable(false);
        sta.show();
    }

    /**
     * handle visit Visit official website button
     * @throws IOException
     */
    public void handleWeb() throws IOException {
        Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler file:///D:/Users/lenovo/Documents/!ProgramZone/Java/GourmentCoffee1.0/src/Gourment%20coffee/index.html");
    }

    /**
     * handle delete menu bar
     * @throws IOException
     */
    public void handleDelete() throws IOException {
        Stage sta=new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("delete.fxml"));
        Parent root = loader.load();
        deleteController controller = loader.getController();

        controller.setStageAndsetListener(sta);
        Scene scene = new Scene(root, 550, 260);
        sta.initStyle(StageStyle.DECORATED);
        sta.setScene(scene);
        sta.setTitle("delete");
        sta.setResizable(false);
        sta.show();
    }

    /**
     * add member
     * @throws IOException
     */
    public void handleAddMember() throws IOException {
        System.out.println("add member");
        Stage sta=new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AddMember.fxml"));
        Parent root = loader.load();
        AddMemberController controller = loader.getController();

        controller.setStageAndsetListener(sta,this.store,this);
        Scene scene = new Scene(root, 970, 450);
        sta.initStyle(StageStyle.DECORATED);
        sta.setScene(scene);
        sta.setTitle("Add Member");
        sta.setResizable(false);
        sta.show();
    }

    /**
     * add product in system
     * @throws IOException
     */
    public void handleAddProduction() throws IOException {
        System.out.println("add production");
        Stage sta=new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AddProduction.fxml"));
        Parent root = loader.load();
        AddProductionController controller = loader.getController();

        controller.setStageAndsetListener(sta,this.store,this);
        Scene scene = new Scene(root, 970, 450);
        sta.initStyle(StageStyle.DECORATED);
        sta.setScene(scene);
        sta.setTitle("Add production");
        sta.setResizable(false);
        sta.show();
    }

    /**
     * print invoice
     */
    public void handleShowInvoiice(){

    }

    /**
     * handle remove button, remove product
     */
    public void handleRemoveButton(){
        for (Product p:ps ) {
            if(p.getCode().equals(buyCode.getText())){
                ps.remove(p);
                refreshList2();
                System.out.println("Refresh");
                return;
            }
        }
        System.out.println("no SUCH CODE");

    }

    /**
     * handle buy button
     */
    public void handleBuyButton(){
        try{
            String str = buyCode.getText();
            this.ps.add(store.getWarehouse().getProducts().get(str));
            refreshList2();
            refreshList();
        }catch (Exception e){
            System.out.println("check what you want!");
        }

    }

    /**
     * handle with confirm button, implement but
     */
    public void handleConfirmButton(){
        Invoice inv = new Invoice(ps);
        this.store.addInv(inv);
        DataSave.saveInvoice(this.store);

        ps = new ArrayList<>();
        refreshList2();
        refreshList();
    }
    public void setStageAndsetListener(Stage stage, Store store){
        this.stage=stage;
        this.store = store;
    }

    /**
     * if click table view, do..
     * @param event
     */
    public void handleProductsTable(MouseEvent event){
        String str0,str1;
        try{
            str0 = productsTable.getSelectionModel().getSelectedItem().getCode();
            buyCode.setText(str0);
            gp00.setText(str0);
            writeInformation(str0);
        }catch (Exception x){
            System.out.println("no such data");
        }
    }

    /**
     * write information on GridPane
     * @param code clicked code
     */
    public void writeInformation(String code){
        switch(code.substring(0,1)) {
            case "":
                break;
            case "C"://Coffee
                write0(code);
                break;
            case "B"://CoffeeBrewer
                write2(code);
                break;
            case "A"://Coffee Accessory
                write1();
                break;
            case "M":
                break;
            default:
                break;
        }
    }

    /**
     * write in GridPane
     * @param s code
     */
    public void write0(String s){
        gp00.setText("origin");gp10.setText(store.getWarehouse().getCoffees().get(s).getOrigin());
        gp01.setText("roast");gp11.setText(store.getWarehouse().getCoffees().get(s).getRoast());
        gp02.setText("flavor");gp12.setText(store.getWarehouse().getCoffees().get(s).getFlavor());

        gp30.setText("Aroma");gp40.setText(store.getWarehouse().getCoffees().get(s).getAroma());
        gp31.setText("Acidity");gp41.setText(store.getWarehouse().getCoffees().get(s).getAcidity());
        gp32.setText("Body");gp42.setText(store.getWarehouse().getCoffees().get(s).getBody());
    }

    /**
     * write Accessory in GridPane
     */
    public void write1(){
        gp00.setText(" ");gp10.setText(null);
        gp01.setText(" ");gp11.setText(null);
        gp02.setText(" ");gp12.setText(null);

        gp30.setText(" ");gp40.setText(null);
        gp31.setText(" ");gp41.setText(null);
        gp32.setText(" ");gp42.setText(null);
    }

    /**
     * write brewer in GridPane
     * @param s brewer code
     */
    public void write2(String s){
        gp00.setText("Model");gp10.setText(store.getWarehouse().getBrewers().get(s).getModelOfBrewer());
        gp01.setText("WaterSupply");gp11.setText(store.getWarehouse().getBrewers().get(s).getWaterSupply());
        gp02.setText("Capacity");gp12.setText(String.valueOf(store.getWarehouse().getBrewers().get(s).getCapacity()));

        gp30.setText(" ");gp40.setText(null);
        gp31.setText(" ");gp41.setText(null);
        gp32.setText(" ");gp42.setText(null);
    }
    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public HomePageControler(){
        ps = new ArrayList<>();
    }

    @FXML public void initialize() {
        // Association
        productsCode.setCellValueFactory(new PropertyValueFactory<>("code"));
        productsPrise.setCellValueFactory(new PropertyValueFactory<>("prise"));
        productDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        enrollCode.setCellValueFactory(new PropertyValueFactory<>("code"));
        enrollPrise.setCellValueFactory(new PropertyValueFactory<>("prise"));
        enrollDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        memberCode.setCellValueFactory(new PropertyValueFactory<>("code"));
        memberAccount.setCellValueFactory(new PropertyValueFactory<>("prise"));
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                refreshList();
                refreshList3();
            }
        });
    }

    /**
     * write data in table1
     */
    private void refreshList() {
        // Fill the observable array list with course data.
        ArrayList<DownloadCoffeeData> list = new ArrayList<>();
        for(String str: store.getWarehouse().getProducts().keySet() ){
            list.add(new DownloadCoffeeData(store.getWarehouse().getProducts().get(str)));
//            System.out.println(list.get(0).getCode());
        }
        data = FXCollections.observableArrayList();
        data.addAll(list);
        // Refresh the counter label
        productsTable.setItems(data);
        productsTable.refresh();
    }

    /**
     * write data to table2
     * @param
     */
    private void refreshList2() {
        // Fill the observable array list with course data. = FXCollections.observableArrayList();
        ArrayList<DownloadCoffeeData> courseList = new ArrayList<>();
        for(Product p:ps){
            courseList.add(new DownloadCoffeeData(p));
        }
        data2 = FXCollections.observableArrayList();
        data2.addAll(courseList);
        // Refresh the counter label
        enrollProductsTable2.setItems(data2);
    }
    /**
     * write data in table2->grade of student
     */
    private void refreshList3() {
        // Fill the observable array list with course data.
        ArrayList<DownloadCoffeeData> courseList = new ArrayList<>();
        for(String s:store.getManager().getMembers().keySet()){
            courseList.add(new DownloadCoffeeData(store.getManager().getMembers().get(s)));
        }
        data3 = FXCollections.observableArrayList();
        data3.addAll(courseList);
        memberTable3.setItems(data3);
    }

    public void refersh(){
        refreshList();
        refreshList2();
        refreshList3();
    }


}
