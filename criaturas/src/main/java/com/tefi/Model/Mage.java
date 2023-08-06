package com.tefi.Model;

import com.tefi.Enums.Gender;

public class Mage extends Creature {
    private int mana = 20;

    public Mage(String name){
        super(name, Gender.FEMALE);
    }

    @Override
    public void attack (Creature enemy){
        attackPower = getAttackPower();
        if(mana > 0){
            System.out.println(name + " throws a spell to " + enemy.name + " for " + attackPower + " points of magic damage.");
            enemy.getAttacked(attackPower);
            mana -=5;
        }else{
            System.out.println(name + " doesn't have any mana. She just uses her staff as a club.");
            if((attackPower-10)>0){
                enemy.getAttacked(attackPower-10);
                System.out.println(name + " attacked " + enemy.name + " for " + (attackPower - 10) + " points.");
            }else{
                System.out.println("The attack was dodged.");
            } 
        }
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

}
