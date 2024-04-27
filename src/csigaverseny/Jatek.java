/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package csigaverseny;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author boroserika
 */
public class Jatek {
    
    private int verseny;
    private int kor;
    private boolean nyer;
    private int fogad;
    private double esely;
    private boolean csigagyorsito;
    private static Random rnd = new Random();
    
    public Jatek() {      
        start();
    }
    
    public int isVerseny() {
        return verseny;
    }

    public void setVerseny(int verseny) {
        this.verseny = verseny;
    }
    
    public int getKor() {
        return kor;
    }

    public void setKor(int kor) {
        this.kor = kor;
    }

    public boolean isNyer() {
        return nyer;
    }

    public void setNyer(boolean nyer) {
        this.nyer = nyer;
    }

    public int getFogad() {
        return fogad;
    }

    public void setFogad(int fogad) {
        this.fogad = fogad;
    }

    public double getEsely() {
        return esely;
    }

    public void setEsely(double esely) {
        this.esely = esely;
    }

    public boolean isCsigagyorsito() {
        return csigagyorsito;
    }

    public void setCsigagyorsito(boolean csigagyorsito) {
        this.csigagyorsito = csigagyorsito;
    }
    
    public void start() {
       
        Scanner scanner = new Scanner(System.in);
        //Jatek jatek = new Jatek();
        
        System.out.println("Start");
        System.out.println(Csiga.CSIGA_PIROS+"@");
        System.out.println(Csiga.CSIGA_ZOLD+"@");
        System.out.println(Csiga.CSIGA_KEK+"@");
        System.out.println("Melyik csiga fog nyerni? 1-Piros, 2-Zöld, 3-Kék. Tippelj: ");
        
        int fogad = scanner.nextInt();
        setFogad(fogad);

        String fogadas = "Nincs ilyen @. Vége a játéknak!";
            switch (fogad) {
            case 1:
                fogadas = Csiga.CSIGA_PIROS+"A Piros @-ra fogadtál!";
                break;
            case 2:
                fogadas = Csiga.CSIGA_ZOLD+"A Zöld @-ra fogadtál!";
                break;
            case 3:
                fogadas = Csiga.CSIGA_KEK+"A Kék @-ra fogadtál!";
                break;
        }
            System.out.println(fogadas);
    }
}
    

