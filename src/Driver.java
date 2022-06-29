public class Driver {
    private String id;
    private String name;

    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }


    public void setId(String id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        String a = String.format("|%2s |%-10s|%6s |", id,name, " ");
        return a;
    }

    public static void printDrivers(Driver[] drivers) {
        String d = String.format("|%2s |%-10s|%6s |\n", "#", "Driver", "Truck");
        System.out.print(d);
        for (Driver t :
                drivers) {
            System.out.println(t);
        }
        System.out.println();
    }
    public static Driver chooseDriver(Driver[] drivers, int num){
        return drivers[num-1];
    }



}
