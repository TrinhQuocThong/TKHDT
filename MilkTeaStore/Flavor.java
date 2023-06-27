package MilkTeaStore;

public class Flavor {
    private static double chocolatePrice = 5000;
    private static double mathcaPrice = 6000;
    private static double taroPrice = 7000;

    public static String getFlavorDescription(Object o) {
        if(o instanceof ChocolateFlavour) {
            return "Chocolate";
        }
        else if(o instanceof MatchaFlavour) {
            return "Matcha";
        }
        else if(o instanceof TaroFlavour) {
            return "Taro";
        }
        return "";
    }
    public static double getPrice(Object o) {
        if(o instanceof ChocolateFlavour) {
            return chocolatePrice;
        }
        else if(o instanceof MatchaFlavour) {
            return mathcaPrice;
        }
        else if(o instanceof TaroFlavour) {
            return taroPrice;
        }
        return 0;
    }

    public static void setChocolatePrice(double chocolatePrice) {
        Flavor.chocolatePrice = chocolatePrice;
    }

    public static void setMathcaPrice(double mathcaPrice) {
        Flavor.mathcaPrice = mathcaPrice;
    }

    public static void setTaroPrice(double taroPrice) {
        Flavor.taroPrice = taroPrice;
    }
}