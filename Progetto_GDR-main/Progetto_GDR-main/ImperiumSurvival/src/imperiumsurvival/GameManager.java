/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package imperiumsurvival;

import java.util.*;

/**
 *
 * @author onorati.nicolo
 */
public class GameManager {
    private int turno;
    private Imperatore giocatore;
    private List<Evento> eventiDisponibili;
    private CampoDaGioco gui;

    public GameManager(int turno, Imperatore giocatore, List<Evento> eventiDisponibili, CampoDaGioco GIU) {
        this.turno = 1;
        this.giocatore = giocatore;
        this.eventiDisponibili = eventiDisponibili;
        this.gui = gui;
    }
    
    public void inizializzaGiovo(){
        FileManager fm = new FileManager();
        this.eventiDisponibili = fm.leggiFile();
        
        
        if(eventiDisponibili.isEmpty()){
            System.err.println("Nessun evento caricato nel file");
        }
        
    }
    
    
    public void cliccaMArcia(){
        Random r = new Random();
        Evento estratto = eventiDisponibili.get(r.nextInt(eventiDisponibili.size()));
        turno++;
        
        giocatore.applicaEvento(estratto);
        
        giocatore.aggiornaStstusTurno();
        
        controllaGameOver();
    }
    
    
    public void cliccaAbilita(){
        giocatore.usaAbilita();
        controllaGameOver();
    }
    
    public void controllaGameOver(){
        boolean perso=false;
        if(giocatore.getSalute() <= 0){
            perso = true;
        }
        else if(giocatore.getMalcontento() >= 100){
            perso=true;
        }
        else if(giocatore.getDissenso() >= 100){
            perso = true;
        }
    }
}
