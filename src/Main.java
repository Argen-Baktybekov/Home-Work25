public class Main {
    public static void main(String[] args) {
        run();
    }

    static Truck[] trucks = FileService.readFileTrucks();
    static Truck truck;
    static Driver[] drivers = FileService.readFileDriver();
    static Driver driver;

    public static void run() {
        boolean cycle = true;
        boolean cycleSwitch = true;
        while (cycle) {
            truck.printTrusks(trucks);
            int numTruck = FileService.tryGetInteger("number of Truck");
            truck = Truck.chooseTruck(trucks, numTruck);
            while (cycleSwitch) {
                System.out.println(" как изменить состояние грузовика:");
                System.out.printf("|%2s |%30s|\n", 1, "Сменить водителя");
                System.out.printf("|%2s |%30s|\n", 2, "Отправить на маршрут");
                System.out.printf("|%2s |%30s|\n", 3, "Отправить на ремонт");
                System.out.printf("|%2s |%30s|\n", 4, "Сменить грузовик");
                System.out.printf("|%2s |%30s|\n", 5, "Выход из программы");


                int command = FileService.tryGetInteger("command");
                switch (command) {
                    case 1:
                        try {
                            driver.printDrivers(drivers);
                            int numDriver = FileService.tryGetInteger("number");
                            driver = driver.chooseDriver(drivers, numDriver);
                            truck.getStateStatus().changeDriver(truck, drivers[numDriver - 1]);
                            break;
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            run();
                        }
                        break;
                    case 2:
                        try {
                            truck.getStateStatus().startDriving(truck, driver);
                            break;
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            run();
                        }
                        break;
                    case 3:
                        try {
                            truck.getStateStatus().startRepair(truck, driver);
                            break;
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            run();
                        }
                        break;
                    case 4:
                        cycleSwitch = false;
                        break;
                    case 5:
                        cycle=false;
                    default:
                        run();
                        break;
                }
                FileService.writeFile(trucks);
                System.out.println(truck);
            }
        }
    }
}
