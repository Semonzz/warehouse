public class User {
    private String name;
    private Point location;

    public User(String name, Point location){
        this.name = name;
        this.location = location;
    }

    public Point getLocation() {
        return location;
    }
}
