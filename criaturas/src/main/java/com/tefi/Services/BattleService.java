package com.tefi.Services;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.tefi.Model.Creature;
import com.tefi.Enums.Gender;

public class BattleService {
    Creature [] selectedCharacters;
    private MenuService menuServices;
    private Scanner scanner = new Scanner(System.in);
    private int option;

    private String endOption;

    public BattleService(Creature[] selectedCharacters, MenuService menuServices) {
        this.selectedCharacters = selectedCharacters;
        this.menuServices = menuServices;
    }

    public void introToTheFight(){
        System.out.println();
        System.out.println("Now that you have chosen your characters... let's make them fight!");
        System.out.println("ON THIS MATCH: " + selectedCharacters[0].getName() + " AGAINST " + selectedCharacters[1].getName());
        System.out.println();
        printBattleMenu();
    }

    public void printInstructions(){
        System.out.println("_______________________");
        System.out.println("These are your options:");
        System.out.println("1. Attack: if you have the resources your attack will be stronger. If not, you'll do your best.");
        System.out.println("2. Block: how much you block depends on how strong is the attack.");
        System.out.println("3. Drink a healing potion. You only have one.");
        System.out.println("_______________________");
        System.out.println();
    }
   
    public void printBattleMenu(){
        Creature firstCharacter = selectedCharacters[0];
        Creature secondCharacter = selectedCharacters[1];
        
        do{
            try {
                printInstructions();
                System.out.println("Type in your choice for " + firstCharacter.getName() + ":");
                option = scanner.nextInt();
                scanner.nextLine();
                switchBattleMenu1(firstCharacter, secondCharacter);
            
                if(secondCharacter.getHealth()>0){
                    boolean validChoice = false;
                    do{
                        try{
                            printInstructions();
                            System.out.println("Type in your choice for " + secondCharacter.getName() + ":");
                            option = scanner.nextInt();
                            scanner.nextLine();
                            switchBattleMenu2(firstCharacter, secondCharacter);
                            validChoice=true;
                        }catch (InputMismatchException e) {
                            System.out.println("You're supposed to type in a number here. Try again.");
                            scanner.nextLine();
                        } 
                    }while(!validChoice);
                }
            } catch (InputMismatchException e) {
            System.out.println("You're supposed to type in a number here. Try again.");
            scanner.nextLine();
        } 
    }while(bothAreAlive(firstCharacter, secondCharacter));
    do{
        endGame();
    }while(refactorOption() == 0);
}

    public boolean bothAreAlive(Creature firstCharacter, Creature secondCharacter){
        if(firstCharacter.getHealth() >= 0 && secondCharacter.getHealth() <= 0){
            System.out.println();
            System.out.println(firstCharacter.getName() + winningWithGenderSceneryOne() + secondCharacter.getName()+"'s corpse.");
            return false;
        }else if((firstCharacter.getHealth() <= 0 && secondCharacter.getHealth() >= 0)){
            System.out.println();
            System.out.println(secondCharacter.getName() + winningWithGenderSceneryTwo() + firstCharacter.getName()+"'s corpse.");
            return false;
        }else{
            return true;
        }
    }

    public String winningWithGenderSceneryOne(){
        if(selectedCharacters[0].getGender()== Gender.FEMALE){
            return " has won and she's dancing on ";
        }else if(selectedCharacters[0].getGender() == Gender.FLUID){
            return " has won and they're dancing on ";
        }
        else{
            return " has won and he's dancing on ";
        }
    }

    public String winningWithGenderSceneryTwo(){
        if(selectedCharacters[1].getGender() == Gender.FEMALE){
            return " has won and she's pointing and laughing at ";
        }else if(selectedCharacters[1].getGender() == Gender.FLUID){
            return " has won and they're dancing on ";
        }else{
            return " has won and he's pointing and laughing at ";
        }
    }

    public void switchBattleMenu1(Creature firstCharacter, Creature secondCharacter){
        switch(option){
            case 1 ->{
               firstCharacter.attack(secondCharacter);
               secondCharacter.showHealth(); 
            } 
            case 2 ->{
                firstCharacter.blockAttack();
            }
            case 3 ->{
                firstCharacter.drinkPotion();
                firstCharacter.showHealth();
            } 
            default -> System.out.println("You haven't selected a valid option.");         
        }
    }

    public void switchBattleMenu2(Creature firstCharacter, Creature secondCharacter){
        switch(option){
            case 1 ->{
               secondCharacter.attack(firstCharacter);
               firstCharacter.showHealth(); 
            } 
            case 2 ->{
                secondCharacter.blockAttack();
            }
            case 3 ->{
                secondCharacter.drinkPotion();
                secondCharacter.showHealth();
            } 
            default -> System.out.println("You haven't selected a valid option.");         
        }    
    }

    public void endGame(){
        System.out.println();
        System.out.println("Thanks for playing!");
        System.out.println("Wanna play again?, if so type in YES. If not type in NO:");
        endOption = scanner.nextLine();
        switchReDo();
    }

    public int refactorOption(){
        endOption = endOption.toUpperCase();
        if(endOption.equals("YES") ){
            return 1;
        }else if(endOption.equals("NO") ){
            return 2;
        }else{
            return 0;
        }
    }

    public void switchReDo(){
        switch(refactorOption()){
            case 1 -> {
                resetCharacters();
                menuServices.printStartGameMenu();
            }
            case 2 -> System.out.println("We'll see you again, we're not worried.");
            default-> System.out.println("You haven't selected a valid option.");
        }
    }

    public void resetCharacters(){
        for (int i = 0; i < selectedCharacters.length; i++) {
            selectedCharacters[i].setHealth(50);
            selectedCharacters[i].setHealthPotion(true);
        }
    }
    
}
