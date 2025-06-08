import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {


    public static void main(String[] args) {

        int[] stockLevels = {10,20,30,40,50};
        for (int i = 0; i < stockLevels.length; i++) {
            System.out.println(
                    "Produkt č.: " + i + " má na skladě " + stockLevels[i] + " kusů.");
        }

        System.out.println("celkový počet kusů: " + Arrays.stream(stockLevels).sum());

        System.out.println(updateStock(stockLevels, 1, 100));

        List<String> productNames = new ArrayList<>(Arrays.asList("Laptop","Telefon", "Monitor", "Klávesnice", "Myš"));
        productNames.add("Sluchátka");
        for (String product : productNames) {
            System.out.println(
                    "Produkt na pozici č. " + productNames.indexOf(product) +
                            " je: " + product);
        }

        System.out.println(findProduct(productNames,"Telefon"));
        System.out.println(findProduct(productNames,"blabla"));

        productNames.remove(productNames.indexOf("Monitor"));

        for (String product : productNames) {
            System.out.println(
                    "Produkt na pozici č. " + productNames.indexOf(product) +
                            " je: " + product);
        }

        System.out.println(getStockStatusByName(productNames, stockLevels, "Monitor")); //nenalezen produkt
        System.out.println(getStockStatusByName(productNames, stockLevels, "Telefon")); //OK
        productNames.add("Tiskárna");
        System.out.println(getStockStatusByName(productNames, stockLevels, "Tiskárna")); //nenalezena skladová zásoba
    }
    public static String findProduct (List<String> stringArray, String product) {

        if (stringArray.contains(product)) {
            return "Produkt " + product + " se nachází na pozici č.: "
                    + stringArray.indexOf(product);
        }
        return "Položka : " + product + " nebyla nalezena";
    }

    public static String updateStock (int[] inputList, int index, int newStockLevel)  {
                if (inputList.length < index) {
            return "Index položky je mimo rozsah pole";
        }
        else {
            String output = "";
            inputList[index]=newStockLevel;
                for (int i = 0; i < inputList.length; i++) {
                    output += "Produkt č.: " + i + " má na skladě " + inputList[i] + " kusů. \n";
                }
                return  output;
        }
    }

    public static String getStockStatusByName (List<String> productNames, int[] stockLevels, String name) {
        if (productNames.contains(name)) {
            int helpIndex = productNames.indexOf(name);
            if (helpIndex >= stockLevels.length) {
                return "Pro položku " + name + " na pozici č. " + helpIndex + " nebyla nalezena hodnota skladové zásoby";
            }
            else {
            return "Produkt " + name + " se nachází na pozici č.: "
                    + helpIndex + " a jeho skladová zásoba je: " + stockLevels[helpIndex] + " ks.";
            }
        }
        return "Hledaná položka: " + name + " nebyla nalezena";}

    }
