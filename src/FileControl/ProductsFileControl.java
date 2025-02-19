import java.util.*;
import java.io.*;

public class ProductsFileControl {
    public HashMap<Integer,Product> ReadProductsFile(){
        HashMap<Integer,Product> Stock = new HashMap<Integer,Product>();
        BufferedReader reader = null;
        String line,infogeter,category= null,name= null,model= null,manufacturer= null,type= null, CPU= null,
                 Graphics= null, Sound= null,energyclass= null,resolution= null,ports= null,format= null;
        int digitalzoom = 0,screensize = 0,megapixels = 0,stock = 0,storage = 0,freezercapacity = 0, normalcapacity = 0,rotation = 0,code = 0,modelyear = 0,size = 0;
        float price = 0,capacity = 0;
        double physicalzoom = 0;
        Product ob = null;
        try {
            reader = new BufferedReader(new FileReader("products.txt"));
            line = reader.readLine();
            while (line != null) {
                if (line.strip().toUpperCase().equals("ITEM")) {
                    line = reader.readLine();
                    if (line.strip().equals("{")) {
                        while(true){
                            line = reader.readLine();
                            infogeter = line.strip().toUpperCase();
                            if (infogeter.startsWith("ITEM_TYPE "))
                                name=line.substring(12).strip();
                            if (infogeter.startsWith("MODEL "))
                                model=line.substring(8).strip();
                            if (infogeter.startsWith("MODEL_YEAR "))
                                modelyear = Integer.parseInt(line.substring(13).strip());
                            if (infogeter.startsWith("MANUFACTURER "))
                                manufacturer=line.substring(15).strip();
                            if (infogeter.startsWith("PRICE "))
                                price=Float.parseFloat(line.substring(8).strip());
                            if (infogeter.startsWith("CAPACITY "))
                                capacity=Float.parseFloat(line.substring(11).strip());
                            if (infogeter.startsWith("PHYSICALZOOM "))
                                physicalzoom=Float.parseFloat(line.substring(15).strip());
                            if (infogeter.startsWith("DIGITALZOOM "))
                                digitalzoom=Integer.parseInt(line.substring(14).strip());
                            if (infogeter.startsWith("SCREENSIZE "))
                                screensize=Integer.parseInt(line.substring(13).strip());
                            if (infogeter.startsWith("MEGAPIXELS "))
                                megapixels=Integer.parseInt(line.substring(13).strip());
                            if (infogeter.startsWith("STOCK "))
                                stock=Integer.parseInt(line.substring(8).strip());
                            if (infogeter.startsWith("STORAGE "))
                                storage=Integer.parseInt(line.substring(10).strip());
                            if (infogeter.startsWith("FREEZER_CAPACITY "))
                                freezercapacity=Integer.parseInt(line.substring(19).strip());
                            if (infogeter.startsWith("NORMAL_CAPACITY "))
                                normalcapacity=Integer.parseInt(line.substring(17).strip());
                            if (infogeter.startsWith("ROTATION "))
                                rotation=Integer.parseInt(line.substring(11).strip());
                            if (infogeter.startsWith("CODE "))
                                code = Integer.parseInt(line.substring(7).strip());
                            if (infogeter.startsWith("SIZE "))
                                size = Integer.parseInt(line.substring(7).strip());
                            if (infogeter.startsWith("CATEGORY "))
                                category=line.substring(10).strip();
                            if (infogeter.startsWith("TYPE "))
                                type=line.substring(7).strip();
                            if (infogeter.startsWith("CPU "))
                                CPU=line.substring(6).strip();
                            if (infogeter.startsWith("GRAPHICS "))
                                Graphics=line.substring(11).strip();
                            if (infogeter.startsWith("SOUND "))
                                Sound=line.substring(7).strip();
                            if (infogeter.startsWith("ENERGY_CLASS "))
                                energyclass=line.substring(14).strip();
                            if (infogeter.startsWith("RESOLUTION "))
                                resolution=line.substring(13).strip();
                            if (infogeter.startsWith("PORTS "))
                                ports=line.substring(8).strip();
                            if (infogeter.startsWith("FORMAT "))
                                format=line.substring(9).strip();
                            if (line.contains("}")) break;
                        }
                            switch(name.toLowerCase()){
                            case "television":
                                ob = new TV(category, price, stock, type, size, model, name, resolution, ports,manufacturer,modelyear);
                                break;
                            case "camera":
                                ob = new Camera(category, price, stock, model, name, type, physicalzoom, digitalzoom, megapixels, screensize,manufacturer,modelyear);
                                break;
                            case "console":
                                ob = new Console(category, price, stock, type, model, name, CPU, Graphics, Sound, storage,manufacturer,modelyear);
                                break;
                            case "media device":
                                ob = new MediaDevice(category, price, stock, type, model, name, resolution, format,manufacturer,modelyear);
                                break;
                            case "fridge":
                                ob = new Fridge(category, price, stock, type, model, name, energyclass, freezercapacity, normalcapacity,manufacturer,modelyear);
                                break;
                            case "washing machine":
                                ob = new WashingMachine(category, price, stock, model, name, energyclass, capacity, rotation,manufacturer,modelyear);
                                break;
                        }
                        Stock.put(code, ob);
                    }
                }
            line = reader.readLine();
            }
        } // try
        catch (IOException e) {
            System.out.println("Error reading line ...");
        }
        return Stock;
    }

    public void CreateProductsFile(HashMap<Integer,Product>Stock) {
        FileWriter writer = null;
        String temp = "";
        try {
            writer = new FileWriter(new File("products.txt"));
            writer.write("ITEM_LIST"+"\n"+"{");
            if (!Stock.isEmpty()){
                for (int i : Stock.keySet()){
                    switch(Stock.get(i).getName().toLowerCase()){
                        case "television":
                            temp = "\n\t\tTYPE " + ((TV)Stock.get(i)).getType()
                                 + "\n\t\tSIZE " + ((TV)Stock.get(i)).getSize()
                                 + "\n\t\tRESOLUTION " + ((TV)Stock.get(i)).getResolution()
                                 + "\n\t\tPORTS " + ((TV)Stock.get(i)).getPorts();
                            break;
                        case "camera":
                            temp = "\n\t\tTYPE " + ((Camera)Stock.get(i)).getType()
                                 + "\n\t\tDIGITALZOOM " + ((Camera)Stock.get(i)).getDigitalzoom()
                                 + "\n\t\tPHYSICALZOOM " + ((Camera)Stock.get(i)).getPhysicalzoom()
                                 + "\n\t\tMEGAPIXELS " + ((Camera)Stock.get(i)).getMegapixels()
                                 + "\n\t\tSCREENSIZE " + ((Camera)Stock.get(i)).getScreensize();
                            break;
                        case "media device":
                            temp = "\n\t\tTYPE " + ((MediaDevice)Stock.get(i)).getType()
                                 + "\n\t\tRESOLUTION " + ((MediaDevice)Stock.get(i)).getResolution()
                                 + "\n\t\tFORMAT " + ((MediaDevice)Stock.get(i)).getFormat();
                            break;
                        case "console":
                            temp = "\n\t\tTYPE " + ((Console)Stock.get(i)).getType()
                                 + "\n\t\tCPU " + ((Console)Stock.get(i)).getCPU()
                                 + "\n\t\tGRAPHICS " + ((Console)Stock.get(i)).getGraphics()
                                 + "\n\t\tSOUND " + ((Console)Stock.get(i)).getSound()
                                 + "\n\t\tSTORAGE " + ((Console)Stock.get(i)).getStorage();
                            break;
                        case "fridge":
                            temp = "\n\t\tTYPE " + ((Fridge)Stock.get(i)).getType()
                                 + "\n\t\tENERGY_CLASS " + ((Fridge)Stock.get(i)).getEnergyclass()
                                 + "\n\t\tFREEZER_CAPACITY " + ((Fridge)Stock.get(i)).getFreezercapacity()
                                 + "\n\t\tNORMAL_CAPACITY " + ((Fridge)Stock.get(i)).getNormalcapacity();
                            break;
                        case "washing machine":
                            temp = "\n\t\tENERGY_CLASS " + ((WashingMachine)Stock.get(i)).getEnergyclass()
                                 + "\n\t\tROTATION " + ((WashingMachine)Stock.get(i)).getRotation()
                                 + "\n\t\tCAPACITY " + ((WashingMachine)Stock.get(i)).getCapacity();
                            break;
                    }
                    writer.write("\n\tITEM\n\t{"
                    + "\n\t\tCODE " + i
                    + "\n\t\tITEM_TYPE " + Stock.get(i).getName()
                    + "\n\t\tCATEGORY " + Stock.get(i).getCategory()
                    + "\n\t\tMODEL "+ Stock.get(i).getModel()
                    + temp
                    + "\n\t\tMANUFACTURER " + Stock.get(i).getManufacturer()
                    + "\n\t\tMODEL_YEAR " + Stock.get(i).getModelyear()
                    + "\n\t\tPRICE " + Stock.get(i).getPrice()
                    + "\n\t\tSTOCK " + Stock.get(i).getStock()
                    + "\n"+"\t"+"}");
                }
                writer.write("}");
                writer.close();
            }
        } // try
        catch (IOException e) {
            System.err.println("Error writing file.");
        }
    }
}

