public class Rote extends State{
    @Override
    public void changeDriver(Truck truck, Driver driver) throws Exception{
        throw new Exception("Грузовик в пути, невозможно сменить водителя");
    }

    @Override
    public void startDriving(Truck truck, Driver driver) throws Exception{
        throw new Exception("Грузовик уже в пути");
    }

    @Override
    public void startRepair(Truck truck, Driver driver) {
        truck.setStateStatus(new Repair());
        truck.setState("repair");
        System.out.println("отправлен на ремонт");
    }
}
