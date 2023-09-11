package org.example.inlamning1;



public class Main {
    public static void main(String[] args) {

        MenuSystem menuSystem = MenuSystem.getInstance();

        while(true){
            menuSystem.execute();
        }
    }
}
