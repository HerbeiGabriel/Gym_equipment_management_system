package Domain;

public class Cardio extends Equipment{
    private int resistence;

    public Cardio(int id, boolean maintenance, int resistance){
        super(id, maintenance);
        this.resistence = resistance;
    }

    public int getResistance(){
        return resistence;
    }

    public void setResistence(int resistence){
        this.resistence = resistence;
    }

    public double getPrice(){
    if(resistence < 10){
        return 500;
    }
    else if(resistence >= 10){
        return 200;
    }
    return 0;
    }

    public String toString(){
        return "The cardio machine with the id: "+ getId() + " with the maintanance" + getMaintenance() + "and the resistance "+ getResistance()+" and the price" + getPrice();
    }
}
