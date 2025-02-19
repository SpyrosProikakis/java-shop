import java.util.*;
import java.io.*;
public class OrdersFileControl {

    public HashMap<Integer,Order> ReadOrdersFile(HashMap<Integer,Product>Stock){
        HashMap<Integer,Order> Orders = new HashMap<Integer,Order>();
        BufferedReader reader = null;
        String line,infogeter,Manufacturer= null,deviceModel= null,customerName= null,orderDate= null,expectedArrivalDate= null,orderStatus= null,customerPhone= null,devicename= null;
        int orderCode = 0;
        double finalCost= 0;
        boolean found;
        try {
            reader = new BufferedReader(new FileReader("orders.txt"));
            line = reader.readLine();
            while (line != null) {
                if (line.strip().toUpperCase().equals("ORDER")) {
                    found = false;
                    line = reader.readLine();
                    if (line.strip().equals("{")) {
                        while(true){
                            line = reader.readLine();
                            infogeter = line.strip().toUpperCase();
                            if (infogeter.startsWith("MANUFACTURER "))
                                Manufacturer=line.strip().substring(15).strip();
                            if (infogeter.startsWith("ITEM_TYPE "))
                                devicename=line.substring(12).strip();
                            if (infogeter.startsWith("MODEL "))
                                deviceModel=line.substring(8).strip();
                            if (infogeter.startsWith("ORDERCODE "))
                                orderCode=Integer.parseInt(line.substring(12).strip());
                            if (infogeter.startsWith("NAME "))
                                customerName=line.substring(7).strip();
                            if (infogeter.startsWith("PHONE "))
                                customerPhone=line.substring(8).strip();
                            if (infogeter.startsWith("ORDERDATE "))
                                orderDate=line.substring(12).strip();
                            if (infogeter.startsWith("EXPECTEDARRIVALDATE "))
                                expectedArrivalDate=line.substring(22).strip();
                            if (infogeter.startsWith("FINALCOST "))
                                finalCost=Double.parseDouble(line.substring(12).strip());
                            if (infogeter.startsWith("STATUS "))
                                orderStatus=line.substring(9).strip();
                            if (line.contains("}")){
                                if (!Stock.isEmpty()){
                                    for (Product item : Stock.values()) {
                                        if (item.getManufacturer().equals(Manufacturer) && item.getModel().equals(deviceModel) && item.getName().equals(devicename)){
                                            Order obb = new Order(orderCode,devicename,deviceModel,customerName,customerPhone,orderDate,expectedArrivalDate,finalCost,orderStatus,Manufacturer);
                                            Orders.put(orderCode,obb);
                                        }
                                    }
                                    if (!found) System.out.println("Item does not exist");
                                }
                                break;
                            }
                        }
                    } // order
                } // Sale_list
                line = reader.readLine();
            } // while
            reader.close();
        } // try
        catch (IOException e) {
            System.out.println("Error reading line ...");
        }
        return Orders;
    } // ReadFile


    public void CreateOrdersFile(HashMap<Integer,Order>Orders) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(new File("orders.txt"));
            writer.write("ORDER_LIST"+"\n"+"{");
            if (!Orders.isEmpty()){
                for (Order order: Orders.values()){
                    writer.write("\n\tORDER\n\t{" 
                    + "\n\t\tITEM_TYPE " +order.getDevicename()
                    + "\n\t\tMANUFACTURER "+ order.getManufacturer()
                    + "\n\t\tORDERCODE " + order.getOrderCode()
                    + "\n\t\tMODEL " + order.getDeviceModel()
                    + "\n\t\tNAME " + order.getCustomerName()
                    + "\n\t\tORDERDATE " + order.getOrderDate()
                    + "\n\t\tPHONE " + order.getCustomerPhone()
                    + "\n\t\tEXPECTEDARRIVALDATE " + order.getExpectedArrivalDate()
                    + "\n\t\tFINALCOST " + order.getFinalCost()
                    + "\n\t\tSTATUS " + order.getOrderStatus()
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
