package com.tefi.Model;

import com.tefi.Enums.Gender;

public class Shaman extends Creature {
    private int mana = 20;

    public Shaman(String name) {
        super(name, Gender.MALE);
    }

    @Override
    public void attack (Creature enemy){
        attackPower = getAttackPower();
        if(mana > 0){
            System.out.println(name + " makes the earth tremble under " + enemy.name + " for " + attackPower + " points of magic damage.");
            enemy.getAttacked(attackPower);
            mana -=5;
        }else{
            System.out.println(name + " doesn't have any mana. He just throws some dirt hoping to damage " + enemy.name + "'s eyes.");
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
