package com.tefi.Services;

import java.util.ArrayList;
import java.util.Scanner;

import com.tefi.Model.Archer;
import com.tefi.Model.Creature;
import com.tefi.Model.Mage;
import com.tefi.Model.Shaman;
import com.tefi.Model.Summoner;
import com.tefi.Model.Warrior;

public class CreateCharacterService {
    ArrayList<Creature> characterList;
    private static Scanner scanner = new Scanner(System.in);
    private static String name;


    public static String assignName(){
        System.out.println("Type in your name:");
        name = scanner.nextLine().toUpperCase();
        return name;
    }

    public static Warrior characterCreationWarrior(ArrayList<Creature> characterList){
        assignName();
        Warrior warrior = new Warrior(name); 
        System.out.println("You've created a warrior named "+ warrior.getName() + "!");
        characterList.add(warrior);
        return warrior;
    }

    public static Mage characterCreationMage(ArrayList<Creature> characterList){
        assignName();
        Mage mage = new Mage(name); 
        System.out.println("You've created a mage named " + mage.getName() + "!");
        characterList.add(mage);
        return mage; 
    }

    public static Shaman characterCreationShaman(ArrayList<Creature> characterList){
        assignName();
        Shaman shaman = new Shaman(name); 
        System.out.println("You've created a shaman named "+ shaman.getName() + "!");
        characterList.add(shaman);
        return shaman;
    }

    public static Archer characterCreationArcher(ArrayList<Creature> characterList){
        assignName();
        Archer archer = new Archer(name); 
        System.out.println("You've created an archer named "+ archer.getName() + "!");
        characterList.add(archer);
        return archer;
    }

    public static Summoner characterCreationSummoner(ArrayList<Creature> characterList){
        assignName();
        Summoner summoner = new Summoner(name); 
        System.out.println("You've created a summoner named "+ summoner.getName() + "!");
        characterList.add(summoner);
        return summoner;
    }
}
