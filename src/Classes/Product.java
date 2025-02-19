class Product {
    String category,name,model,manufacturer;
    float price;
    int stock,discount,modelyear;
    Product (String category,float price, int stock,String model,String name,String manufacturer, int modelyear){
        this.category = category;
        this.price = price;
        this.stock = stock;
        this.model = model;
        this.name = name;
        this.manufacturer=manufacturer;
        this.modelyear=modelyear;
    }
    public int getDiscount() {
        return discount;
    }
    public String getCategory() {
        return category;
    }
    public float getPrice() {
        return price;
    }
    public int getStock() {
        return stock;
    }
    public String getModel() {
        return model;
    }
    public String getName() {
        return name;
    }
    public String getManufacturer() {
        return manufacturer;
    }
    public int getModelyear() {
        return modelyear;
    }
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
    public void setModelyear(int modelyear) {
        this.modelyear = modelyear;
    }
    public void setPrice(float price) {
        this.price = price;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public void setName(String name) {
        this.name = name;
    }
}