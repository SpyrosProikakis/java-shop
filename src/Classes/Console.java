class Console extends Gaming {
    String type, CPU, Graphics, Sound;
    int storage;
    Console (String category,float price, int stock, String type,
    String model,String name, String CPU, String Graphics, String Sound, int storage,String manufacturer,int modelyear){
        super(category, price, stock,model,name, manufacturer,modelyear);
        this.type = type;
        this.CPU = CPU;
        this.Graphics = Graphics;
        this.storage = storage;
        this.Sound = Sound;
    }
    public String getCPU() {
        return CPU;
    }
    public String getGraphics() {
        return Graphics;
    }
    public String getSound() {
        return Sound;
    }
    public int getStorage() {
        return storage;
    }
    public String getType() {
        return type;
    }
    public String toString(){
        return "Product: "+name
                +"\tCategory: "+ category
                +"\tModel: "+ model
                +"\tModel Year: "+ modelyear
                +"\tManufacturer: "+ manufacturer
                +"\tType: "+ type
                +"\tCPU: " +CPU
                +"\tGraphics: " +Graphics
                +"\tSound: " +Sound
                +"\tStorage: " +storage +"GB"
                +"\tPrice: "+ price
                +"\tStock: "+ stock;
                
    }
}
