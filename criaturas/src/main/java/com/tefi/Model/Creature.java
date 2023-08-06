package com.tefi.Model;

import java.util.Random;

import com.tefi.Enums.Gender;

public class Creature {
    protected String name;
    protected int health = 50;
    protected int attackPower;
    protected boolean healthPotion = true;
    protected boolean block = false;
    protected Gender gender;

    public Creature(String name, Gender gender){
        this.name = name;
        this.gender = gender;
    }

    public int getAttackPower(){
        Random randomNum = new Random();
        attackPower = randomNum.nextInt(20)+1;
        return attackPower;
    }

    public void getAttacked(int attackPower){
        if(block == true){
            int blockedPower = (int) Math.round(attackPower * 0.65);
            int blockedAttack = attackPower-blockedPower;
            if(health<blockedAttack){
                health = 0;
                System.out.println("Sadly " + blockedPower + " points were blocked. Sadder still, " + name + " still died.");
                block = false;
            }else{
                health -= blockedAttack;
                System.out.println("Sadly " + blockedPower + " points were blocked.");
                block = false;
            }
        }else{
            if(health<attackPower){
            health = 0;
        }else{
            health -= attackPower;
        }
    } 
}

    public void blockAttack(){
        System.out.println(name + " is ready to block an attack.");
        block = true;
    }

    public void attack(Creature enemy){
        System.out.println(name + " attacks " + enemy.name + " for " + attackPower + " points.");
        enemy.getAttacked(attackPower);
        }

    public void showHealth(){
        System.out.println("-> " + name + "'s health is: " + health);
    }

    public void drinkPotion(){ //esto debería cambiar con la salud
        if(healthPotion == true && health <= 40){
            health += 10;
            healthPotion = false;
            System.out.println(name + " drinks a potion, 'Ahhhh, refreshing!'.");
        }else if(healthPotion == true && health > 40){
            health = 50;
            healthPotion = false;
            System.out.println(name + " drinks a potion even though it wasn't really all that necessary.");
        }else{
            System.out.println(name + " doesn't have any health potions available");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public String toString() {
        return name + "(" + gender + ")";
    }

    public Gender getGender() {
        return gender;
    }

    public void setHealthPotion(boolean healthPotion) {
        this.healthPotion = healthPotion;
    }

}
