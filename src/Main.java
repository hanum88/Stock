import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {


    public static void main(String[] args) throws StockException {

        int[] stockLevels = {10,20,30,40,50};

        for (int i = 0; i < stockLevels.length; i++) {
            System.out.println(
                    "Produkt č.: " + i + " má na skladě " + stockLevels[i] + " kusů.");
        }

        System.out.println("celkový počet kusů: " + Arrays.stream(stockLevels).sum());

        try {
            System.out.println(updateStock(stockLevels, 10, 100));
        } catch (StockException e) {
            System.out.println("Došlo k chybě: " + e.getLocalizedMessage());
        }



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

    public static String updateStock (int[] inputList, int index, int newStockLevel) throws StockException {
        try {
            inputList[index] = newStockLevel;
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new StockException("chyba indexu: " + index + " - " + e.getLocalizedMessage());
        }

        String output = "";

            for (int i = 0; i < inputList.length; i++) {
                output += "Produkt č.: " + i + " má na skladě " + inputList[i] + " kusů. \n";
            }
            return output;
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
