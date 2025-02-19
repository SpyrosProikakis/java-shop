/*
 Autors:
 Spyros Prwikakhs 
 Veliko Nikola Vreko 
 Adreas Vagenas 
 */


import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
public class mainApp {
    public static void main(String[] args) {
        SalesFileControl SalesFile = new SalesFileControl();
        OrdersFileControl OrdersFile = new OrdersFileControl();
        ProductsFileControl ProductsFile = new ProductsFileControl();
        int code2 = 0, code3 = 0;
        int c6,count = 0;
        HashMap<Integer,Product> Stock = ProductsFile.ReadProductsFile();
        System.out.println("Reading products file...");
        HashMap<Integer,Order> Orders = OrdersFile.ReadOrdersFile(Stock);
        System.out.println("Reading orders file...");
        HashMap<Integer,Sale> Sold = SalesFile.ReadSalesFile(Stock);
        System.out.println("Reading sales file...");
        Scanner in = new Scanner(System.in);
        boolean done=false;
        String answer,c3,c1,c2,c4,c5;
        Gaming.discount = 20;
        HouseAppl.discount = 15;
        VideoAndSound.discount = 10;
        while (!done){
            System.out.println("--------------------------");
            System.out.println("0. View Available Items");
            System.out.println("1. View Orders");
            System.out.println("2. View Sales");
            System.out.println("3. Exit");
            System.out.println("--------------------------");
            System.out.print(">");
            answer = in.nextLine();
            switch (answer) {
                case "0":
                    //--------------------View Stock----------------------
                    System.out.println("--- View Available Items --- ");
                    for (Integer i : Stock.keySet()) {
                        System.out.println("Item Id: "+ i +" "+ Stock.get(i).toString());
                        System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
                    }
                    System.out.println("-----------Pick an item------------ ");
                    System.out.print("Category: ");
                    c1 = in.nextLine();
                    System.out.print("Product: ");
                    c2 = in.nextLine();
                    System.out.print("Model: ");
                    c3 = in.nextLine();
                    count = 0;
                    for (Product i : Stock.values()) {
                        if (i.getCategory().toLowerCase().equals(c1.toLowerCase()) && i.getName().toLowerCase().equals(c2.toLowerCase()) && i.getModel().toLowerCase().equals(c3)){
                            System.out.println(i.toString());
                            System.out.print("Sale?(1.Yes/2.No): ");
                            c4 = in.nextLine();
                            if (c4.equals("1")){
                                if (i.getStock() == 0){
                                    System.out.println("No Requested Items Available!");
                                    System.out.print("Whould you like to order?(1.Yes/2.No) ");
                                    c5 = in.nextLine();
                                    if (c5.equals("1")){
                                        System.out.println("Enter the other elements of the order: ");
                                        code2++;
                                        Order OrderObject = OrderCreation(code2,(i.getPrice()*(1 - i.getDiscount()/100.0)));
                                        Orders.put(code2,OrderObject);
                                        System.out.println("Starting price: " + i.getPrice());
                                        System.out.println("Discount: "+i.getDiscount()+"% / "+
                                                            (i.getPrice()*i.getDiscount()/100.0));
                                        System.out.println("Final price: "+(i.getPrice()*(1 - i.getDiscount()/100.0)));
                                    }
                                } else {
                                    i.setStock(i.getStock() - 1);
                                    System.out.println("Enter the other elements of the sale: ");
                                    code3++;
                                    Sale SaleObject = SaleCreation(code3,i.getPrice()*(1-i.getDiscount()/100.0));
                                    Sold.put(code3,SaleObject);
                                    System.out.println("Starting cost: " + i.getPrice());
                                    System.out.println("Discount: "+i.getDiscount()+"% / "+
                                                        (i.getPrice()*i.getDiscount()/100.0));
                                    System.out.println("Final cost: "+(i.getPrice()*(1 - i.getDiscount()/100.0)));
                                }
                            }
                            break;
                        } else 
                            count++;
                    }
                    if (count == Stock.size())
                    System.out.println("Item Requested Doesn't Exist");
                    break;
                case "1":
                    // -----------------View Orders -------------------------
                    if (!Orders.isEmpty()){
                        System.out.println("--- View Orders --- ");
                        for (Integer i : Orders.keySet()) {
                            System.out.println(Orders.get(i).toString());
                            System.out.println("----------------------------------------------------------------------------------------");
                        }
                        System.out.print("Choose an order(id): ");
                        c6 = Integer.parseInt(in.nextLine());
                        System.out.println(Orders.get(c6).toString());
                        System.out.println("Has the order arrived? (1.Yes/2.No)");
                        if (in.nextLine().equals("1")){
                            Orders.get(c6).setOrderStatus("Completed");
                            Sale ob = new Sale();
                            Order selectedorder = Orders.get(c6);
                            code3++;
                            ob.setSaleId(code3);
                            ob.setDeviceName(selectedorder.getDevicename());
                            ob.setCustomerName(selectedorder.getCustomerName());
                            ob.setCustomerPhone(selectedorder.getCustomerPhone());
                            ob.setDeviceModel(selectedorder.getDeviceModel());
                            ob.setFinalCost(selectedorder.getFinalCost());
                            ob.setManufacturer(selectedorder.getManufacturer());
                            LocalDateTime d = LocalDateTime.now();
                            DateTimeFormatter date = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                            String fdate = d.format(date);
                            ob.setSaleDate(fdate);
                            Sold.put(code3,ob);
                        }
                    } else {
                        System.out.println("No pending orders!");
                    }
                    break;
                case "2":
                    // ----------------- View Sales --------------------------
                    System.out.println("--- View Sales --- ");
                    for (Integer i : Sold.keySet()) {
                        System.out.println(Sold.get(i).toString());
                        System.out.println("------------------------------------------------------------------------------------------------");
                    }
                    if (Sold.isEmpty()){
                        System.out.println("No sales made yet!");
                    }
                    break;
                case "3":
                    SalesFile.CreateSalesFile(Sold);
                    OrdersFile.CreateOrdersFile(Orders);
                    ProductsFile.CreateProductsFile(Stock);
                    done = true;
                    break;
                default:
                    System.out.println("Try again");
                    break;
            }
        }
        in.close();
    }
    static Order OrderCreation(int code,double price){
        Scanner in = new Scanner(System.in);
        Order ob = new Order();
        String datecheck;
        ob.setOrderCode(code);
        System.out.print("Give name: ");
        ob.setCustomerName(in.nextLine());
        System.out.print("Give phone: ");
        ob.setCustomerPhone(in.nextLine());
        System.out.print("Give model: ");
        ob.setDeviceModel(in.nextLine().toUpperCase());
        System.out.print("Give product type(camera,television...): ");
        ob.setDevicename(in.nextLine());
        System.out.print("Give manufacturer: ");
        ob.setManufacturer(in.nextLine());
        System.out.print("Give Status:(Pending,Completed) ");
        ob.setOrderStatus(in.nextLine());
        LocalDateTime d = LocalDateTime.now();
        DateTimeFormatter date = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fdate = d.format(date);
        ob.setOrderDate(fdate);
        while(true){
            System.out.print("Give Expected Arrival date:(dd/mm/yyyy) ");
            datecheck = in.nextLine();
            if (datecheck.compareTo(fdate) >= 0){
                ob.setExpectedArrivalDate(datecheck);
                break;
            } else {
                System.out.println("Expected arrival date must not be before current date!");
            }
        }
        ob.setFinalCost(price);
        return ob;
    }
    static Sale SaleCreation(int code,double price){
        Scanner in = new Scanner(System.in);
        Sale ob = new Sale();
        ob.setSaleId(code);
        System.out.print("Give name: ");
        ob.setCustomerName(in.nextLine());
        System.out.print("Give phone: ");
        ob.setCustomerPhone(in.nextLine());
        System.out.print("Give model: ");
        ob.setDeviceModel(in.nextLine().toUpperCase());
        System.out.print("Give product type(camera,television...): ");
        ob.setDeviceName(in.nextLine());
        System.out.print("Give manufacturer: ");
        ob.setManufacturer(in.nextLine());
        LocalDateTime d = LocalDateTime.now();
        DateTimeFormatter date = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fdate = d.format(date);
        ob.setSaleDate(fdate);
        ob.setFinalCost(price);
        return ob;     
    }   
}