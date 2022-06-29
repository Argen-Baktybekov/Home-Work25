public class Base extends State{
    @Override
    public void changeDriver(Truck truck, Driver driver) {

        truck.setDriver(driver.getName());
        System.out.printf("Теперь грузовик <%s>, ведёт водитель <%s>",truck.getName(), driver.getName());
    }

    @Override
    public void startDriving(Truck truck, Driver driver) throws Exception{
        if (truck.getDriver().equals("unknown")){
            throw new Exception("Грузовик без водителя не может выехать");
        }
        truck.setStateStatus(new Rote());
        truck.setState("rote");
        System.out.println("успешно вышли на маршрут");

    }

    @Override
    public void startRepair(Truck truck, Driver driver) {
        truck.setStateStatus(new Repair());
        truck.setState("repair");
        System.out.println("отправлен на ремонт");
    }
}
