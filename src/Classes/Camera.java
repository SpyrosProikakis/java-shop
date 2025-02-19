class Camera extends VideoAndSound{
    int digitalzoom,screensize,megapixels;
    double physicalzoom;
    String type;
    Camera (String category,float price, int stock,String model,String name, String type, double physicalzoom,
    int digitalzoom, int megapixels,int screensize,String manufacturer,int modelyear){
        super(category, price, stock,model,name, manufacturer,modelyear);
        this.type = type;
        this.digitalzoom = digitalzoom;
        this.physicalzoom = physicalzoom;
        this.screensize =screensize;
        this.megapixels = megapixels;
    }
    public int getDigitalzoom() {
        return digitalzoom;
    }
    public double getPhysicalzoom() {
        return physicalzoom;
    }
    public String getType() {
        return type;
    }
    public int getMegapixels() {
        return megapixels;
    }
    public int getScreensize() {
        return screensize;
    }
    public String toString() {
        return "Product: "+ name
                +"\tCategory: "+ category
                +"\tModel: "+ model
                +"\tModel Year: "+ modelyear
                +"\tManufacturer: "+ manufacturer
                +"\tType: "+ type
                +"\tDigital Zoom: " +digitalzoom + "x"
                +"\tPhysical Zoom: " +physicalzoom + "x"
                +"\tMegapixels: " +megapixels
                +"\tScreen Size: " +screensize +"\""
                +"\tPrice: "+ price
                +"\tStock: "+ stock;
    }
}