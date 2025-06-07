public class Courier extends Worker{

    public Courier(int id, String name, Warehouse warehouse){
        super(id, name, warehouse);
        this.warehouse.couriers.add(this);
    }

    public void deliver(Point location){
        double timeTmp = 2;
        double dist = this.warehouse.getLocation().distanceTo(location);
        timeTmp += dist;
        inWork += timeTmp;
        System.out.println("\nCourier delivered and back for " + timeTmp + " minutes");
        checkTimeWork();
    }

}
