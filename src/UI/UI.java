package UI;

import Domain.Cardio;
import Domain.Equipment;
import Domain.Strength;
import Domain.Strength.muscle_group;
import Repository.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;
import java.util.Scanner;

public class UI {
    Repository<Equipment> repo=new Repository();

    public void show_menu(){
        System.out.println("Welcome to the UI");
        System.out.println("Please choose one of the following options for your equipment: ");
        System.out.println("1. Add Equipment");
        System.out.println("2. Show all equipments");
        System.out.println("3. Filter the list of equipments by price and level");
        System.out.println("4. Write to file");
        System.out.println("0. Exit");
    }

    public void run() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            show_menu();
            System.out.println("Please enter an integer: ");
            int input = scanner.nextInt();
            if (input == 1) {
                System.out.println("Please enter the name of the equipment(Cardio/Strength): ");
                String name = scanner.next();
                System.out.println("Please enter the id of the equipment: ");
                int id = scanner.nextInt();
                System.out.println("Please enter if the equipment requires maintenance(true/false):");
                Boolean mentenance = scanner.nextBoolean();
                if (Objects.equals(name, "Cardio")) {
                    System.out.println("Please enter the resistance of the equipment: ");
                    int resistance = scanner.nextInt();
                    Cardio cardio = new Cardio(id, mentenance, resistance);
                    repo.add(cardio);
                } else if (Objects.equals(name, "Strength")) {
                    System.out.println("Please enter the muscle group of the equipment: ");
                    String mucGroup = scanner.next();
                    muscle_group mc = null;
                    try {
                        mc = muscle_group.valueOf(mucGroup);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid muscle group");
                    }
                    System.out.println("Please enter the motion of the equipment: ");
                    int motion=scanner.nextInt();
                    Strength strength = new Strength(id, mentenance, mc, motion);
                    repo.add(strength);
                }
            } else if (input == 2) {
                repo.print();
            }
            else if(input==3){
                System.out.println("PLease enter the price limit");
                int priceLimit = scanner.nextInt();
                System.out.println("Please enter the level limit: ");
                int limit = scanner.nextInt();
                repo.filtered_sorted_list(priceLimit, limit);
            }
            else if(input==4){
                Properties prop=new Properties();
                try {
                    prop.load(new FileReader("Settings properties"));
                    String RepoPath=prop.getProperty("path");
                    Repository_writing a=new Repository_writing(RepoPath, repo.getList());
                    a.writeToFile();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            else if(input==0){
                System.exit(0);
            }
        }
    }
}
