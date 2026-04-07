/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package imperiumsurvival;

/**
 *
 * @author onorati.nicolo
 */
public class Evento {
    private String titolo;
    private String logMessaggio;
    private int modSalute;
    private int modMalcontento;
    private int modDissenso;
    private String pahtImmagine;

    public Evento(String titolo, String logMessaggio, int modSalute, int modDissenso, int modMalcontento, String pahtImmagine) {
        this.titolo = titolo;
        this.logMessaggio = logMessaggio;
        this.modSalute = modSalute;
        this.modMalcontento = modMalcontento;
        this.modDissenso = modDissenso;
        this.pahtImmagine = pahtImmagine;
    }

    public String getLogTitolo() {
        return titolo;
    }

    public String getLogMessaggio() {
        return logMessaggio;
    }

    public String getPahtImmagine() {
        return pahtImmagine;
    }

    public int getModSalute() {
        return modSalute;
    }

    public int getModMalcontento() {
        return modMalcontento;
    }

    public int getModDissenso() {
        return modDissenso;
    }
    
    
    
    
}
