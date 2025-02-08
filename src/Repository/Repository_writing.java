package Repository;

import Domain.Equipment;
import Repository.Repository;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Repository_writing extends Repository {
    protected String filename;

    public Repository_writing(String filename,ArrayList<Equipment> list) {
        this.filename = filename;
        this.list = list;
    }

    public void writeToFile() {
        ArrayList<Equipment> list1=list;
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(this.filename))) {
        for(Equipment e:list1) {
            bw.write(e.toString()+"\n");
        }
        }
        catch (IOException e) {
        throw new RuntimeException(e);
    }
    }
}
