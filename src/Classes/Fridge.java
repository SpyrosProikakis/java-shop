public class Fridge extends HouseAppl {
    String type;
    String energyclass;
    int freezercapacity, normalcapacity;
    Fridge(String category,float price, int stock,String type,
    String model,String name, String energyclass,int freezercapacity,int normalcapacity,String manufacturer,int modelyear){
        super(category, price, stock,model,name, manufacturer,modelyear);
        this.type = type;
        this.energyclass = energyclass;
        this.freezercapacity = freezercapacity;
        this.normalcapacity = normalcapacity;
    }
    public String getEnergyclass() {
        return energyclass;
    }
    public int getFreezercapacity() {
        return freezercapacity;
    }
    public int getNormalcapacity() {
        return normalcapacity;
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
                +"\tEnergy Class: " +energyclass
                +"\tFreezer Capacity: " +freezercapacity + "L"
                +"\tNormal Capacity: " +normalcapacity + "L"
                +"\tPrice: "+ price
                +"\tStock: "+ stock;
                
    }
}
