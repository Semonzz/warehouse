public class Courier extends Worker{

    public Courier(int id, String name){
        super(id, name);
    }

    public void deliver(Point location){
        System.out.println("Courier get supplies and start delivering....");
        double timeTmp = 2;
        double dist = this.warehouse.getLocation().distanceTo(location);
        timeTmp += dist;
        inWork += timeTmp;
        System.out.println("\nCourier delivered and back for " + timeTmp + " minutes");
        checkTimeWork();
    }

}
