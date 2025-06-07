import java.util.Random;

abstract class Worker {
    protected Warehouse warehouse;
    private int id;
    private Random rand = new Random();
    private String name;
    private int hours;
    private double salary = 300;
    private boolean isShift = true;
    private boolean isBusy;
    protected double inWork = 0;



    public Worker(int id, String name){
        this.id = id;
        this.name = name;
        this.hours  = this.rand.nextInt(1, 10);
    }

    public void setWarehouse(Warehouse other){
        this.warehouse = other;
    }

    protected void checkTimeWork(){
        if(inWork >= hours * 60 || warehouse.getQueueSize()==0){
            isShift = false;
            setSalary();
        }
    }

    private void setSalary(){
        double result = (this.inWork / 60) * salary;
        System.out.println("\nWorker " + name + " ends work and get " + result + " money.");
    }

    public double getSalary(){
        return (this.inWork / 60) * salary;
    }

    public int getHours() {
        return hours;
    }

    public boolean getBusy(){
        return isBusy;
    }

    public void setBusy(boolean setting){
        this.isBusy = setting;
    }

    public boolean getShift(){
        return isShift;
    }

    public void setHours(int hours){
        this.hours = hours;
    }

    public double getInWork(){
        return inWork;
    }
}
