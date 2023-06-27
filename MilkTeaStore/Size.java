package MilkTeaStore;

public class Size {
    public static String getDescription(Object o) {
        if(o instanceof Small) {
            return "size S";
        }
        else if(o instanceof Medium) {
            return "size M";
        }
        else if(o instanceof Large) {
            return "size L";
        }
        return null;

    }
    public static double getPrice(Object o) {
        if(o instanceof Small) {
            return 1;
        }
        else if(o instanceof Medium) {
            return 1.2;
        }
        else if(o instanceof Large) {
            return 1.5;
        }
        return 0;
    }
}