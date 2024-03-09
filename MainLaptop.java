import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.HashMap;






public class MainLaptop {



        public static void main(String[] args) {
            Set<Laptop> laptops = new HashSet<>();
            laptops.add(new Laptop(8, 512, "Windows", "Black"));
            laptops.add(new Laptop(16, 1024, "Windows", "Silver"));
            laptops.add(new Laptop(8, 256, "macOS", "Space Gray"));
            laptops.add(new Laptop(8, 256, "macOS", "Space Gray"));

            for (Laptop laptop : laptops){
                System.out.println(laptop);
    
            }
    
            Map<Integer, Object> filters = new HashMap<>();
            Scanner scanner = new Scanner(System.in);
    
            System.out.println("Выберите критерии фильтрации:");
            System.out.println("1 - ОЗУ");
            System.out.println("2 - Объем ЖД");
            System.out.println("3 - Операционная система");
            System.out.println("4 - Цвет");
            System.out.print("Введите цифру, соответствующую критерию: ");
            int criterion = scanner.nextInt();
    
            switch (criterion) {
                case 1:
                    System.out.print("Введите минимальное количество ОЗУ: ");
                    int minRam = scanner.nextInt();
                    filters.put(1, minRam);
                    break;
                case 2:
                    System.out.print("Введите минимальный объем ЖД: ");
                    int minStorage = scanner.nextInt();
                    filters.put(2, minStorage);
                    break;
                case 3:
                    System.out.print("Введите операционную систему: ");
                    String os = scanner.next();
                    filters.put(3, os);
                    break;
                case 4:
                    System.out.print("Введите цвет: ");
                    String color2 = scanner.next();
                    filters.put(4, color2);
                    break;
                default:
                    System.out.println("Некорректный ввод");
                    return;
            }
        

        
        Set<Laptop> filteredLaptops = Laptop.filterLaptops(laptops, filters);

        System.out.println("Результаты фильтрации:");
        for (Laptop laptop : filteredLaptops) {
            System.out.println(laptop.getOZU() + "GB RAM, " + laptop.getGD() + "GB HDD, " + laptop.getOS() + ", " + laptop.getColor());
        }        

        
    }


}
