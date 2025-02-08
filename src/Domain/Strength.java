package Domain;

public class Strength extends Equipment{
    public enum muscle_group {legs, arms, core};
    private muscle_group muscle_group;
    private int motion;

    public Strength(int id, boolean maintenance, muscle_group muscle_group, int motion) {
        super(id, maintenance);
        this.muscle_group = muscle_group;
        this.motion = motion;
    }

    public String get_muscle_group() {
        return muscle_group.toString();
    }

    public int get_motion() {
        return motion;
    }

    public void set_motion(int motion) {
        this.motion = motion;
    }

    public void set_muscle_group(muscle_group mg) {
        this.muscle_group = mg;
    }

    public double getPrice(){
        if(muscle_group == muscle_group.legs || muscle_group == muscle_group.arms){
            return 600;
        }
        else if(muscle_group == muscle_group.core){
            return 800;
        }
        return 0;
    }

    public String toString(){
        return "The strength machine with the id: "+ getId() + " that works on the muscle groups "+muscle_group+" with the motion "+motion+" with the maintanance " + getMaintenance() + "and the price " + getPrice();
    }
}
