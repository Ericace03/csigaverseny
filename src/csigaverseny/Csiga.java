/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package csigaverseny;

/**
 *
 * @author boroserika
 */
public class Csiga {
    
    private int messze;
    private boolean kap;
    private int sebesseg;
    
    public static final String CSIGA_PIROS = "\033[31m@";
    public static final String CSIGA_ZOLD = "\033[32m@";
    public static final String CSIGA_KEK = "\033[34m@";

    public Csiga() {
  
        this.messze = 0;
        this.kap = false;
        this.sebesseg = 0;
    }

    public int isMessze() {
        return messze;
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

    public int getSebesseg() {
        return sebesseg;
    }

    public void setSebesseg(int sebesseg) {
        this.sebesseg = sebesseg;
    }
}
