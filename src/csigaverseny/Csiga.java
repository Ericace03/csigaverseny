/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package csigaverseny;

import java.util.Random;

/**
 *
 * @author boroserika
 */
public class Csiga {
    
    private int messze;
    private boolean kap;
    private String szin;
    private int sebesseg;
    private static Random random = new Random();
    
    public static final String CSIGA_PIROS = "\033[31m";
    public static final String CSIGA_ZOLD = "\033[32m";
    public static final String CSIGA_KEK = "\033[34m";

    public Csiga(String szin) {
  
        this.kap = false;
        this.szin = szin;
        this.sebesseg = 0;
    }

    public int getMessze() {
        return messze;
    }
    
    public void setMessze(int messze) {
        this.messze = messze;
    }

    public void setKap(int messze) {
        this.messze = messze;
    }

    public boolean isKap() {
        return kap;
    }

    public void setKap(boolean kap) {
        this.kap = kap;
    }
    
    public String getSzin() {
        return szin;
    }

    public void setSzin(String szin) {
        this.szin = szin;
    }

    public int getSebesseg() {
        return sebesseg;
    }

    public void setSebesseg(int sebesseg) {
        this.sebesseg = sebesseg;
    }
    
    public void randomSebesseg() {
        this.sebesseg = random.nextInt(4);
    }
}
