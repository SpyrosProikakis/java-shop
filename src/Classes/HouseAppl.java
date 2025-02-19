public class HouseAppl extends Product{
    static int discount = 0;
    HouseAppl (String category,float price, int stock,String model,String name,String manufacturer,int modelyear){
        super(category, price, stock,model,name, manufacturer,modelyear);
    }
    public int getDiscount() {
        return discount;
    }

}
