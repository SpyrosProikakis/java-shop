public class Sale { 
    int saleId;
    String deviceModel ,customerName, customerPhone, saleDate,manufacturer,deviceName;
    double finalCost;
 

    Sale(){
        
    }
    Sale(String deviceModel, String customerName, String customerPhone,
        String saleDate, double finalCost,int saleId,String manufacturer,String deviceName) {
        this.saleId = saleId;
        this.deviceModel = deviceModel;
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.saleDate = saleDate;
        this.finalCost = finalCost;
        this.manufacturer = manufacturer;
        this.deviceName = deviceName;
    }
    
    public int getSaleId() {
        return saleId;
    }
    public String getDeviceModel() {
        return deviceModel;
    }
    public double getFinalCost() {
        return finalCost;
    }
    public String getCustomerName() {
        return customerName;
    }
    public String getSaleDate() {
        return saleDate;
    }
    public String getCustomerPhone() {
        return customerPhone;
    }
    public String getDeviceName() {
        return deviceName;
    }
    public String getManufacturer() {
        return manufacturer;
    }
    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }
    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }
    public void setSaleDate(String saleDate) {
        this.saleDate = saleDate;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public void setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel;
    }
    public void setFinalCost(double finalCost) {
        this.finalCost = finalCost;
    }
    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String toString() {
        return "Sale ID: " + saleId +
                "\tDevice Model: " + deviceModel +
                "\tCustomer Name: " + customerName +
                "\tCustomer Phone: " + customerPhone +
                "\nSale Date: " + saleDate +
                "\tFinal Cost: " + finalCost;
    }
}
