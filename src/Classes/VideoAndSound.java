public class VideoAndSound extends Product{
    static int discount = 0;
    VideoAndSound (String category,float price, int stock,String model,String name, String manufacturer,int modelyear){
        super(category, price, stock,model,name, manufacturer,modelyear);
    }
    public int getDiscount() {
        return discount;
    }
}
