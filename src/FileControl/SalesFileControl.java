import java.util.*;
import java.io.*;

class SalesFileControl {
    public HashMap<Integer,Sale> ReadSalesFile(HashMap<Integer,Product> Stock) {
        HashMap<Integer,Sale> Sold = new HashMap<Integer,Sale>();
        BufferedReader reader = null;
        String line,type= null,model= null,manufacturer= null,name= null,date= null,infogeter,phone = null;
        int code= 0;
        double cost= 0;
        boolean found;
        try {
            reader = new BufferedReader(new FileReader("sales.txt"));
            line = reader.readLine();
            while (line != null) {
                if (line.strip().toUpperCase().equals("SALE")) {

                    found = false;
                    line = reader.readLine();
                    if (line.strip().equals("{")) {
                        do{
                            line = reader.readLine();
                            infogeter = line.strip().toUpperCase();
                            if (infogeter.startsWith("ITEM_TYPE "))
                                type=line.strip().substring(12).strip();
                            if (infogeter.startsWith("MODEL "));
                                model=line.substring(8).strip();
                            if (infogeter.startsWith("MANUFACTURER "))
                                manufacturer=line.substring(15).strip();
                            if (infogeter.startsWith("SALES_NUMBER "))
                                code=Integer.parseInt(line.substring(15).strip());
                            if (infogeter.startsWith("NAME "))
                                name=line.substring(7).strip();
                            if (infogeter.startsWith("PHONE "))
                                phone=line.substring(8).strip();
                            if (infogeter.startsWith("DATE "))
                                date=line.substring(7).strip();
                            if (infogeter.startsWith("COST "))
                                cost=Double.parseDouble(line.substring(7).strip());
                            if (line.contains("}")){
                                if (!Stock.isEmpty()){
                                    for (Product item : Stock.values()) {
                                        if (item.getManufacturer().equals(manufacturer) && item.getModel().equals(model) && item.getName().equals(type)){
                                            Sale obb = new Sale(model,name,phone,date,cost,code,manufacturer,type);
                                            Sold.put(code,obb);
                                            found = true;
                                        }
                                    }
                                    if (!found) System.out.println("Item does not exist"); 
                                }
                                break;
                            }
                        }while(!line.strip().equals("}"));
                    } // Sale
                } // Sale_list
                line = reader.readLine();
            } // while
            reader.close();
        } // try
        catch (IOException e) {
            System.out.println("Error reading line ...");
        }
        return Sold;
    } // ReadFile

    public void CreateSalesFile(HashMap<Integer,Sale>Sold) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(new File("sales.txt"));
            writer.write("SALE_LIST\n{");
            if (!Sold.isEmpty()){
                for (Sale sale: Sold.values()){
                    writer.write("\n\tSALE\n{"
                    + "\n\t\tITEM_TYPE " +sale.getDeviceName()
                    + "\n\t\tMODEL "+ sale.getDeviceModel()
                    + "\n\t\tMANUFACTURER " + sale.getManufacturer()
                    + "\n\t\tSALES_NUMBER " + sale.getSaleId()
                    + "\n\t\tNAME " + sale.getCustomerName()
                    + "\n\t\tPHONE " + sale.getCustomerPhone()
                    + "\n\t\tDATE " + sale.getSaleDate()
                    + "\n\t\tCOST " + sale.getFinalCost()
                    + "\n\t}");
                }
            }
            writer.close();
        } // try

        catch (IOException e) {
            System.err.println("Error writing file.");
        }
    }
}
