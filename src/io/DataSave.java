package io;

import system.Invoice;
import system.Product;
import system.Store;

import java.io.*;

/**
 * Created by 63263 on 2016/12/29.
 */
public class DataSave {
        public static void saveProduct(Store store) {
            // TODO Auto-generated method stub
            File file = new File("data.txt");
            System.out.println("Saving");
            try {
                file.createNewFile(); //
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            byte bt[] = new byte[1024];
            try {
                FileOutputStream in = new FileOutputStream(file);
                try {

                    for(String s:store.getWarehouse().getProducts().keySet()){
                        System.out.println(s);
                        switch(s.substring(0,1)) {
                            case "C"://coffee
                                bt = store.getWarehouse().getCoffees().get(s).returnString().getBytes();
                                in.write(bt, 0, bt.length);in.write('\r');
                                break;
                            case "B"://CoffeeBrewer
                                bt = store.getWarehouse().getBrewers().get(s).returnString().getBytes();
                                in.write(bt, 0, bt.length);in.write('\r');
                                break;
                            case "A"://coffeeAccessory
                                bt = store.getWarehouse().getAccessorys().get(s).returnString().getBytes();
                                in.write(bt, 0, bt.length);in.write('\r');
                                break;
                            case "M":
                                bt = store.getManager().getMembers().get(s).returnString().getBytes();
                                in.write(bt,0,bt.length);in.write('\r');
                                break;
                            default:
                                System.out.println("error in saving data");
                                break;
                        }
                    }

                    for(String s:store.getManager().getMembers().keySet()){
                        bt = store.getManager().getMembers().get(s).returnString().getBytes();
                        in.write(bt,0,bt.length);in.write('\r');
                    }
                    in.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        public static void saveInvoice(Store store){

            File file = new File("invoices.txt");
            System.out.println("Saving invoices");
            try {
                file.createNewFile(); //
            } catch (IOException e) {
                e.printStackTrace();
            }

            byte bt[] = new byte[1024];
            String str = "=================================================\r";
            byte bt0[] = str.getBytes();
            try {
                FileOutputStream in = new FileOutputStream(file);
                try {
                    for(Invoice i: store.getInvoices()){
                        bt = i.getData().getBytes();


//                        bt = str.getBytes();
                        in.write(bt0,0,bt0.length);
                        in.write(bt,0,bt.length);in.write('\r');
                        for(Product p:i.getPs()){
                            str = "||" + i.returnString(p) + "||"+"\r";
                            bt = str.getBytes();
                            in.write(bt,0,bt.length);
                        }

                        in.write(bt0,0,bt0.length);in.write('\r');in.write('\r');
                    }

                    in.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }

}
