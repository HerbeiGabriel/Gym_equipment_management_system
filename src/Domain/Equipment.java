package Domain;

public abstract class Equipment {
    private int id;
    private boolean maintenance;

    public Equipment(int id, boolean maintenance) {
        this.id = id;
        this.maintenance = maintenance;
    }

    public int getId(){
        return id;
    }

    public boolean getMaintenance(){
        return maintenance;
    }

    public void setMaintenance(boolean maintenance){
        this.maintenance = maintenance;
    }

    public void setId(int id) {
        this.id = id;
    }

    public abstract double getPrice();

    public abstract String toString();
}
