package com.tefi.Services;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.tefi.Model.Creature;

public class MenuService {
    ArrayList<Creature> characterList = new ArrayList<>();
    Creature [] selectedCharacters = new Creature [2];
    private static Scanner scanner = new Scanner(System.in);
    private static int option;

    public void startGameMenu(){
        System.out.println("HELLO! Welcome to the creature game!");
        printStartGameMenu();     
    }

    public void printStartGameMenu(){
        boolean validInput = false;
        do{ 
            System.out.println("These are your options: ");
            System.out.println("1. Create a hero:");
            System.out.println("2. Choose a hero:");
            System.out.println("0. Quit");
            System.out.println("Type in your choice:");
            try {
                option = scanner.nextInt();
                scanner.nextLine();
                switchStart();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("You're supposed to type in a number here. Try again.");
                scanner.nextLine();
            }
        }while(option <0 || option >2 || !validInput);   
    }

    public void switchStart(){
        switch(option){
            case 1 -> caracterCreationMenu();
            case 2 -> storedCharactersMenu();
            case 0 -> System.out.println("See you later buddy.");
            default -> System.out.println("You haven't entered a valid option.");
        }
    }

    public void caracterCreationMenu(){
        boolean validInput = false;
        do{
            System.out.println("CREATE A NEW HERO:");
            System.out.println("If you care about that sort of stuff... Archers and Mages are females. Warriors and Shamans are male. And Summoners are gender fluid.");
            System.out.println("1. Warrior");
            System.out.println("2. Mage");
            System.out.println("3. Shaman");
            System.out.println("4. Archer");
            System.out.println("5. Summoner");
            System.out.println("0. Quit");
            System.out.println("Type in your choice:");
            try{
                option = scanner.nextInt();
                scanner.nextLine();
                switchCaracterCreation();
                if(option == 0){
                    break;
                }
                printStartGameMenu();
                validInput = true;
            }catch(InputMismatchException e){
                System.out.println("You're supposed to type in a number here. Try again.");
                scanner.nextLine();
            }    
        } while(option <= 0 || option >5 || !validInput);
    }

    public void switchCaracterCreation(){
        switch (option){
            case 1 -> CreateCharacterService.characterCreationWarrior(characterList);
            case 2 -> CreateCharacterService.characterCreationMage(characterList);
            case 3 -> CreateCharacterService.characterCreationShaman(characterList);
            case 4 -> CreateCharacterService.characterCreationArcher(characterList);
            case 5 -> CreateCharacterService.characterCreationSummoner(characterList);
            case 0 -> System.out.println("See you later buddy.");
            default -> System.out.println("You haven't entered a valid option.");
        }
    }

    public void storedCharactersMenu(){
        boolean validInput = false;
        if(characterList.size()<2){
            System.out.println("You need to create characters before you can choose them, oh wise one.");
            caracterCreationMenu();
        }else{
            int selectedCharacterIndex = 0;
            do{
                System.out.println("AVAILABLE HEROES:");
                printCharacterNames();
                System.out.println("0. Quit");
                System.out.println("Select the character you want for this match from the tavern:");
                try{
                    option = scanner.nextInt();
                    scanner.nextLine();
                    if (option >= 1 && option <= characterList.size()) {
                        addCharacterFromTavern(selectedCharacterIndex);
                        selectedCharacterIndex++;
                    }
                    validInput = true;
                }catch(InputMismatchException e){
                    System.out.println("You're supposed to type in a number here. Try again.");
                    scanner.nextLine();
                }
                
            }while(option >= 1 && selectedCharacterIndex < selectedCharacters.length && option!=0 || !validInput); 
            checkFighters();
        }
    }

    public void printCharacterNames(){
            for (int i = 0; i < characterList.size(); i++) {
            Creature character = characterList.get(i);
            System.out.println((i+1) + ". " + character.getName() + " " + "(" + character.getClass().getSimpleName() + ")");//acá podría agregar que se vea con qué tipo de spell fue creado por ej.
        }
    }


    public void addCharacterFromTavern(int selectedCharacterIndex) {
        int indexArrayList = option - 1;
        if (indexArrayList >= 0 && indexArrayList < characterList.size()) {
            selectedCharacters[selectedCharacterIndex] = characterList.get(indexArrayList);
            System.out.println("You have selected " + selectedCharacters[selectedCharacterIndex].getName());
        }
    }

    public void checkFighters(){
        if(selectedCharacters[0] != null && selectedCharacters[1] != null){
            BattleService battleServices = new BattleService(selectedCharacters, this);
            battleServices.introToTheFight();
        }else{
            storedCharactersMenu();
        }
    }
}

