package com.tefi.Model;

import com.tefi.Enums.Gender;

public class Warrior extends Creature {
    private int stamina = 40;
    
    public Warrior(String name){
        super(name, Gender.MALE);
    }

    @Override
    public void attack (Creature enemy){
        attackPower = getAttackPower();
        if(stamina > 0){
            System.out.println(name + " throws a supercharged attack to " + enemy.name + " for " + attackPower + " points of physical damage.");
            enemy.getAttacked(attackPower);
            stamina -=10; 
        }else{
            System.out.println(name + " doesn't have enough stamina to make a supercharged attack. He just swings the sword tiredly.");
            if((attackPower-10)>0){
                enemy.getAttacked(attackPower-10);
                System.out.println(name + " attacked " + enemy.name + " for " + (attackPower - 10) + " points.");
            }else{
                System.out.println("The attack was dodged.");
            }
            
        }
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

}
