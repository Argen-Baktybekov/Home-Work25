public class Truck {
    private int id;
    private String name;
    private String driver;
    private String state;
    private transient State stateStatus = new Base();


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public State getStateStatus() {
        switch (state) {
            case "base":
                return new Base();
            case "rote":
                return new Rote();
            case "repair":
                return new Repair();
        }
        return new Base();
    }

    public void setStateStatus(State stateStatus) {
        this.stateStatus = stateStatus;
    }

    @Override
    public String toString() {
        String truck = String.format("|%2s |%-15s|%10s |%10s|", id, name, driver, state);
        return truck;
    }

    public static void printTrusks(Truck[] trucks) {
        String a = String.format("|%2s |%-15s|%10s |%10s|\n", "id", "name", "Dtriver", "state");
        System.out.print(a);
        for (Truck t : trucks) {
            System.out.println(trucks.length);
        }
        System.out.println();
    }

    public static Truck chooseTruck(Truck[] trucks, int num) {
        return trucks[num - 1];
    }

}
