/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package csigaverseny;

import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author boroserika
 */
public class Jatek {
    
    private int verseny;
    private int kor;
    private String nyer;
    private int fogad;
    private double esely;
    private boolean csigagyorsito;
    
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

    public String isNyer() {
        return nyer;
    }

    public void setNyer(String nyer) {
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
        Random random = new Random();
        Csiga[] csigak = new Csiga[3];
        csigak[0] = new Csiga(Csiga.CSIGA_PIROS);
        csigak[1] = new Csiga(Csiga.CSIGA_ZOLD);
        csigak[2] = new Csiga(Csiga.CSIGA_KEK);
        Csiga nyercsiga = csigak[0];
        verseny=-1;
        
        System.out.println("Csigaverseny "+Csiga.CSIGA_PIROS+"@ "+Csiga.CSIGA_ZOLD+"@ "+Csiga.CSIGA_KEK+"@");
        System.out.println("Melyik csiga fog nyerni? 1-Piros, 2-Zöld, 3-Kék. Tippelj: ");
        
        fogad = scanner.nextInt();
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
            
        System.out.println("Start");
        
        for (Csiga csiga : csigak) {
            System.out.println(csiga.getSzin() + "@");
        }
                    
        for (int kor = 0; kor < 5; kor++) {
                
            System.out.println((kor+1)+". kör");
                
                for (Csiga csiga : csigak) {
                    csiga.randomSebesseg();
                    esely = random.nextDouble();
                    if (esely < 0.2) {
                        csigagyorsito = true;
                        csiga.setKap(csigagyorsito);
                        csiga.setSebesseg(csiga.getSebesseg() * 2);
                    }
                    csiga.setMessze(csiga.getMessze() + csiga.getSebesseg()); 
                
                    StringBuilder lepesPont = new StringBuilder();
                    for (int j = 0; j < csiga.getMessze(); j++) {
                    lepesPont.append(".");
                    }
                    
                    System.out.println(csiga.getSzin() + lepesPont.toString() + "@");

                    if (csiga.getMessze() > nyercsiga.getMessze()) {
                        nyercsiga = csiga;
                        nyer=csiga.getSzin();
                    }
                }
        }
        
        System.out.println("Vége");
        System.out.println(nyer + "A @ nyert!");
        for (int i = 0; i < csigak.length; i++) {
            if (csigak[i] == nyercsiga) {
                verseny=i+1;
                break;
            }
        }
        if (fogad == verseny) {
            System.out.println("Helyes volt a tipped.");
        }
        else {
            System.out.println("Rossz volt a tipped.");
        }
 
    }
}

