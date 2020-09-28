package com.techelevator;

public class Workstation {

    public static void main(String[] args) {

        FruitTree myFruitTree = new FruitTree("apple", 5);
        myFruitTree.pickFruit(3);
        myFruitTree.pickFruit(1);

        System.out.println(myFruitTree.getPiecesOfFruitLeft());
        System.out.println(myFruitTree);
        }


   }
