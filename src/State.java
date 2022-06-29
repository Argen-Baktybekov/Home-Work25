public abstract class State{
    public abstract void changeDriver(Truck truck, Driver driver) throws Exception;

    public abstract void startDriving(Truck truck, Driver driver) throws Exception;

    public abstract void startRepair(Truck truck, Driver driver) throws Exception;

}
