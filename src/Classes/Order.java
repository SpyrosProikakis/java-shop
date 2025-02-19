public class Order {
    private String Manufacturer;
    private int orderCode;
    private String devicename;
    private String deviceModel;
    private String customerName;
    private String customerPhone;
    private String orderDate;
    private String expectedArrivalDate;
    private double finalCost;
    private String orderStatus;
    public Order(){

    }
    public Order(int orderCode,String devicename, String deviceModel, String customerName, String customerPhone,
                String orderDate, String expectedArrivalDate, double finalCost, String orderStatus,String Manufacturer) {
        this.devicename = devicename;
        this.Manufacturer=Manufacturer;
        this.orderCode = orderCode;
        this.deviceModel = deviceModel;
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.orderDate = orderDate;
        this.expectedArrivalDate = expectedArrivalDate;
        this.finalCost = finalCost;
        this.orderStatus = orderStatus;
    }
    public String getManufacturer(){
        return Manufacturer;
    }
    public String getDevicename() {
        return devicename;
    }
    public int getOrderCode() {
        return orderCode;
    }
    public String getDeviceModel() {
        return deviceModel;
    }
    public String getOrderStatus() {
        return orderStatus;
    }
    public String getCustomerName() {
        return customerName;
    }
    public double getFinalCost() {
        return finalCost;
    }
    public String getCustomerPhone() {
        return customerPhone;
    }
    public String getExpectedArrivalDate() {
        return expectedArrivalDate;
    }
    public String getOrderDate() {
        return orderDate;
    }
    public void setDevicename(String devicename) {
        this.devicename = devicename;
    }
    public void setOrderCode(int orderCode) {
        this.orderCode = orderCode;
    }
    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }
    public void setExpectedArrivalDate(String expectedArrivalDate) {
        this.expectedArrivalDate = expectedArrivalDate;
    }
    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }
    public void setFinalCost(double finalCost) {
        this.finalCost = finalCost;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
    public void setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel;
    }
    public void setManufacturer(String manufacturer) {
        Manufacturer = manufacturer;
    }
    public String toMyString() {
        return "Order Code: " + orderCode +
                "\tDevice Model: " + deviceModel +
                "\tManufacturer: " + Manufacturer +
                "\tCustomer Name: " + customerName +
                "\tCustomer Phone: " + customerPhone +
                "\tOrder Date: " + orderDate +
                "\nExpected Arrival Date: " + expectedArrivalDate +
                "\tFinal Cost: " + finalCost +
                "\tOrder Status: " + orderStatus;
    }
}