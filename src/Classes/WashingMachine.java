public class WashingMachine extends HouseAppl {
    String energyclass;
    int rotation;
    float capacity;
    WashingMachine(String category,float price, int stock,
    String model,String name, String energyclass,float capacity, int rotation,String manufacturer,int modelyear){
        super(category, price, stock,model,name, manufacturer,modelyear);
        this.energyclass = energyclass;
        this.capacity = capacity;
        this.rotation = rotation;

    }
    public float getCapacity() {
        return capacity;
    }
    public String getEnergyclass() {
        return energyclass;
    }
    public int getRotation() {
        return rotation;
    }

    public String toString() {
        return "Product: "+name
                +"\tCategory: "+ category
                +"\tModel: "+ model
                +"\tModel Year: "+ modelyear
                +"\tManufacturer: "+ manufacturer
                +"\tEnergy Class: "+energyclass
                +"\tRotations: "+rotation+"/m"
                +"\tCapacity: "+capacity +"L"
                +"\tPrice: "+ price
                +"\tStock: "+ stock;
    }
}
