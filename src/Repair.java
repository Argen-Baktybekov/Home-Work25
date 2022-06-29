import java.util.Random;

public class Repair extends State{
    @Override
    public void changeDriver(Truck truck, Driver driver) throws Exception{
        throw new Exception("Нельзя сменить водителя");
    }

    @Override
    public void startDriving(Truck truck, Driver driver) throws Exception{
        int rnd = new Random().nextInt(2);
        if (truck.getDriver().equals("unknown")){
            throw new Exception("Грузовик без водителя не может выехать");
        }
        if (rnd == 1){
            truck.setStateStatus(new Rote());
            truck.setState("rote");
            System.out.println("успешно вышли на маршрут");
        }else {
            truck.setStateStatus(new Base());
            truck.setState("base");
            System.out.println("отправлен на базу");
        }
    }

    @Override
    public void startRepair(Truck truck, Driver driver) throws Exception{
        throw new Exception("Уже в ремонте");
    }
}
