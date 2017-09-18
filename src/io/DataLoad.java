package io;

import system.*;

import java.io.*;
/**
 * Created by 63263 on 2016/12/27.
 */
public class DataLoad {
//    public static void readFileByChars(){
//        File file = new File("Data.txt");
//        Reader reader = null;
//        try{
//            System.out.println("write into file");
//            reader = new InputStreamReader(new FileInputStream(file));
//            int tempchar;
//            while((tempchar = reader.read())!=){
//                if((char)tempchar !='\r'){
//                    System.out.println((char));
//                }
//            }
//        }catch(FileNotFoundException e1) {
//            e1.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    /**
     * read products and members from file
     * @param store
     */
    public static void readFileByLines(Store store){
        File file = new File("Data.txt");
        BufferedReader reader = null;
        try{
            System.out.println();
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            while ((tempString = reader.readLine())!=null){
                System.out.println("line"+line+": "+tempString);
                switch(tempString.substring(0,1)) {
                    case "\r":
                        break;
                    case "C"://Coffee
                        Coffee c = new Coffee(tempString,Double.valueOf(reader.readLine()),reader.readLine(),reader.readLine(),reader.readLine(),reader.readLine(),reader.readLine(),reader.readLine(),reader.readLine());

                        store.getWarehouse().add(c);
                        break;
                    case "B"://CoffeeBrewer
                        CoffeeBrewer cb = new CoffeeBrewer(tempString,Double.valueOf(reader.readLine()),reader.readLine(),reader.readLine(),reader.readLine(),Integer.valueOf(reader.readLine()));

                        store.getWarehouse().add(cb);
                        break;
                    case "A"://Coffee Accessory
                        CoffeeAccessory ca = new CoffeeAccessory(tempString,Double.valueOf(reader.readLine()),reader.readLine());
                        store.getWarehouse().add(ca);
                        break;
                    case "M":
                        Member m = new Member(reader.readLine(),reader.readLine(),Double.valueOf(reader.readLine()),reader.readLine());
                        store.getManager().getMembers().put(m.getUsename(),m);
                        break;
                    default:
                        System.out.println("Data error"+tempString+tempString.substring(0,1));
                        break;
                }
                line++;
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(reader != null){
                try{
                    reader.close();
                }catch(IOException e1){

                }
            }
        }
    }


}
