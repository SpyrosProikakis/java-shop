class MediaDevice extends VideoAndSound {
    String type,format,resolution;
    MediaDevice (String category,float price, int stock, String type,
    String model,String name, String resolution,String format,String manufacturer,int modelyear){
        super(category,price,stock,model,name, manufacturer,modelyear);
        this.resolution = resolution;
        this.format = format;
        this.type = type;
    }
    public String getFormat() {
        return format;
    }
    public String getResolution() {
        return resolution;
    }
    public String getType() {
        return type;
    }

    public String toString() {
        return "Product: "+name
                +"\tCategory: "+ category
                +"\tModel: "+ model
                +"\tModel Year: "+ modelyear
                +"\tManufacturer: "+ manufacturer
                +"\tType: "+ type
                +"\tResolution: " +resolution
                +"\tPlayback Format: " +format
                +"\tPrice: "+ price
                +"\tStock: "+ stock;
    }
}
