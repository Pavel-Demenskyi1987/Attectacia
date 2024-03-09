import java.util.HashSet;

import java.util.Map;
import java.util.Objects;
import java.util.Set;





public class Laptop {

    private int OZU;
    private int GD;
    private String OS;
    private String color;

    public Laptop(int OZU, int GD, String OS, String color) {
        this.OZU = OZU;
        this.GD = GD;
        this.OS = OS;
        this.color = color;
    }

    public int getOZU() {
        return OZU;
    }

    public int getGD() {
        return GD;
    }

    public String getOS() {
        return OS;
    }

    public String getColor() {
        return color;
    }

    public void setOZU(int OZU) {
        this.OZU = OZU;
    }

    public void setGD(int GD) {
        this.GD = GD;
    }

    public void setOS(String OS) {
        this.OS = OS;
    }

    public void setColor(String color) {
        this.color = color;
    }

 


    

    public static Set<Laptop> filterLaptops(Set<Laptop> laptops, Map<Integer, Object> filters) {
        Set<Laptop> filteredLaptops = new HashSet<>();

        for (Laptop laptop : laptops) {
            boolean passed = true;
            for (Map.Entry<Integer, Object> entry : filters.entrySet()) {
                switch (entry.getKey()) {
                    case 1:
                        if (laptop.getOZU() < (int) entry.getValue()) {
                            passed = false;
                        }
                        break;
                    case 2:
                        if (laptop.getGD() < (int) entry.getValue()) {
                            passed = false;
                        }
                        break;
                    case 3:
                        if (!laptop.getOS().equalsIgnoreCase((String) entry.getValue())) {
                            passed = false;
                        }
                        break;
                    case 4:
                        if (!laptop.getColor().equalsIgnoreCase((String) entry.getValue())) {
                            passed = false;
                        }
                        break;
                }
            }
            if (passed) {
                filteredLaptops.add(laptop);
            }
        }

        return filteredLaptops;
    }




    @Override
    public int hashCode() {

        return Objects.hash(OZU,GD,OS,color);
    }

    public boolean equals(Object obj) {
        if(this == obj) 
            return true;

        if(obj == null || getClass() != obj.getClass())
            return false;

        Laptop laptop = (Laptop) obj;

        return  OZU == laptop.OZU &&
                GD == laptop.GD &&
                OS.equals(laptop.OS) &&
                color.equals((laptop.color));
    }








    @Override
    public String toString() {
        return "Озу: " + OZU + ", " +
                "ЖД: " + GD + ", " +
                "Операционная система: " + OS + ", " +
                "Цвет: " + color + ", ";
    }


}