package com.tefi.Model;

import com.tefi.Enums.Gender;

public class Archer extends Creature {
    private int stamina = 40;

    public Archer(String name) {
        super(name, Gender.FEMALE);
    }

    @Override
    public void attack (Creature enemy){
        attackPower = getAttackPower();
        if(stamina > 0){
            System.out.println(name + " throws an arrow the size of a tree to " + enemy.name + " for " + attackPower + " points of physical damage.");
            enemy.getAttacked(attackPower);
            stamina -=10; 
        }else{
            System.out.println(name + " doesn't have enough stamina to throw a tree so she just throws a stick.");
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
