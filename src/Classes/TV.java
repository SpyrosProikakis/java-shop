class TV extends VideoAndSound {
    String type,resolution,ports;
    int size;
    TV (String category,float price, int stock,String type,
    int size,String model,String name, String resolution,String ports,String manufacturer,int modelyear){
        super (category,price,stock,model,name, manufacturer,modelyear);
        this.type = type;
        this.size = size;
        this.resolution = resolution;
        this.ports = ports;
    }
    public String getPorts() {
        return ports;
    }
    public int getSize() {
        return size;
    }
    public String getType() {
        return type;
    }
    public String getResolution() {
        return resolution;
    }
    
    public String toString() {
        return "Product: "+name
                +"\tCategory: "+ category
                +"\tModel: "+ model
                +"\tModel Year: "+ modelyear
                +"\tManufacturer: "+ manufacturer
                +"\tType: "+ type
                +"\tSize: " +size + "\""
                +"\tResolution: " +resolution
                +"\tPorts: " +ports
                +"\tPrice: "+ price
                +"\tStock: "+ stock;
    }
}
