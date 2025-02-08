package Repository;
import Domain.*;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;
import java.util.*;

public class Repository<T extends Equipment> {
    protected ArrayList<T> list = new ArrayList<T>();

    public void add(T equipment) {
        list.add(equipment);
    }

    public void remove(T equipment) {
        list.remove(equipment);
    }

    public void print(){
        for(int i=0; i<list.size(); i++){
            System.out.println(list.get(i));
        }
    }

    public void filtered_sorted_list(double price_limit, int level_limit){
        list.stream().filter(e->e.getPrice()>price_limit).filter(e->((e instanceof Cardio)&&((Cardio)e).getResistance()>level_limit)
            ||((e instanceof Strength)&&((Strength)e).get_motion()>level_limit)).sorted((e1, e2)->Integer.compare(e2.getId(), e1.getId()))
            .forEach(System.out::println);
    }

    public ArrayList<T> getList(){
        return list;
    }

}
