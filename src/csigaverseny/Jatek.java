/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package csigaverseny;

import java.util.Scanner;
import java.util.Random;
import java.util.InputMismatchException;


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
    private Csiga nyercsiga;
    
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
       
        
        Random random = new Random();
        Csiga[] csigak = new Csiga[3];
        csigak[0] = new Csiga(Csiga.CSIGA_PIROS);
        csigak[1] = new Csiga(Csiga.CSIGA_ZOLD);
        csigak[2] = new Csiga(Csiga.CSIGA_KEK);
        nyercsiga = csigak[0];
        verseny=-1;
        
        fogad = fogadas();
        setFogad(fogad);
        kezdes(csigak);
        korok(csigak, random);
        eredmeny(csigak);
    }
    
    public int fogadas() {
        
        Scanner scanner = new Scanner(System.in);
           
        System.out.println("Csigaverseny "+Csiga.CSIGA_PIROS+"@ "+Csiga.CSIGA_ZOLD+"@ "+Csiga.CSIGA_KEK+"@");
            
        while (fogad < 1 || fogad > 3) {
            try {
                System.out.println("Melyik csiga fog nyerni? 1-Piros, 2-Zöld, 3-Kék. Tippelj: ");
                fogad = scanner.nextInt();
                setFogad(fogad);
            
                if (fogad < 1 || fogad > 3) {
                    System.out.println("Nincs ilyen @. Kérlek, válassz 1 és 3 közötti számot!");
                }
            }   
            catch (InputMismatchException e) {
                System.out.println("Hiba! Kérlek, csak 1 és 3 közötti számot írj be.");
                scanner.next();
                }
            }
            
        String fogadas = "";
            
        switch (fogad) {
            case 1:
                fogadas = Csiga.CSIGA_PIROS+"A piros @-ra fogadtál!";
                break;
            case 2:
                fogadas = Csiga.CSIGA_ZOLD+"A zöld @-ra fogadtál!";
                break;
            case 3:
                fogadas = Csiga.CSIGA_KEK+"A kék @-ra fogadtál!";
                break;
        }
        
        System.out.println(fogadas);
           
        return fogad;
    }
    
    public void kezdes (Csiga[] csigak) {
    
        System.out.println("Start");
        
        for (Csiga csiga : csigak) {
            System.out.println(csiga.getSzin() + "@");
        }
    }
    
    private void korok (Csiga[] csigak, Random random) {
        
        for (int kor = 0; kor < 5; kor++) {
                
            System.out.println((kor+1)+". kör");
                
            // Helyzet csigagyorsítóval, ha kap
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
                    
                // a legnagyobb távolságú csiga a nyertes
                if (csiga.getMessze() >= nyercsiga.getMessze()) {
                    nyercsiga = csiga;
                    nyer=csiga.getSzin();
                }
            }
        }
    }
    
    public void eredmeny (Csiga[] csigak) {
        
        //Döntetlen-e
        boolean dontetlen = false;
        for (Csiga csiga : csigak) {
            if (csiga.getMessze() == nyercsiga.getMessze() && csiga != nyercsiga){
                dontetlen = true;
            }
        }
        
        System.out.println("Vége");
        
        if (!dontetlen) {
            System.out.println(nyer + "A @ nyert!");
            }
        else {
            System.out.println("Döntetlen az eredmény!");
        }
        
        // Eredmény kijelzése
        for (int i = 0; i < csigak.length; i++) {
            if (csigak[i].equals(nyercsiga)) {
                verseny=i+1;
                break;
            }
        }
        
        if (fogad == verseny) {
            System.out.println("Helyes volt a tipped.");
        }
        else if (dontetlen) {
            System.out.println("Részben jó volt a tipped.");
        }
        else {
            System.out.println("Rossz volt a tipped.");
        }
    }    
}