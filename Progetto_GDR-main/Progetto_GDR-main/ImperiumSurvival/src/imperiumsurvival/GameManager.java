/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package imperiumsurvival;

import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author onorati.nicolo
 */
public class GameManager {
    private int turno;
    private Imperatore giocatore;
    private List<Evento> eventiDisponibili;
    private CampoDaGioco gui;
    private Evento ultimoEvento;
    

    public GameManager() {
    }

    public GameManager(Imperatore giocatore) {
        this.turno = 0;
        this.giocatore = giocatore;
        this.eventiDisponibili = new ArrayList<>();
        this.inizializzaGiovo();
    }
    
    public void inizializzaGiovo(){
        FileManager fm = new FileManager();
        this.eventiDisponibili = fm.leggiFile();
        
        if(eventiDisponibili.isEmpty()){
            System.err.println("Nessun evento caricato nel file");
        }
        
    }
    
    
    public void cliccaMArcia(){
        /*if (eventiDisponibili == null || eventiDisponibili.isEmpty()) {
        System.err.println("ERRORE: Nessun evento disponibile! Controlla il file .txt");
        return;
        }*/
        Random r = new Random();
        Evento estratto = eventiDisponibili.get(r.nextInt(eventiDisponibili.size()));
        this.ultimoEvento = estratto;
        
        turno++;
        
        giocatore.applicaEvento(estratto);
        
        giocatore.aggiornaStstusTurno();
        
        controllaGameOver();
    }
    
    public Evento getUltimoEvento(){
        return ultimoEvento;
    }
    
    
    public void cliccaAbilita(){
        giocatore.usaAbilita();
        controllaGameOver();
    }
    
    
    
    public int controllaGameOver(){
        boolean perso=false;
        if(giocatore.getSalute() <= 0){
            perso = true;
            JOptionPane.showMessageDialog(null, "Sei caduto in battaglia o per malattia. L'Impero piange il suo leader");
            return 1;
        }
        else if(giocatore.getMalcontento() >= 100){
            perso=true;
            JOptionPane.showMessageDialog(null, "Il popolo ha dato fuoco al palazzo. La tua testa viene portata in trionfo per le strade di Roma");
            return 1;
        }
        else if(giocatore.getDissenso() >= 100){
            perso = true;
            JOptionPane.showMessageDialog(null, "Le legioni ti hanno tradito. I Pretoriani sono entrati nelle tue stanze... le Idi di Marzo sono tornate");
            return 1;
        }
        else{
            return 0;
        }
    }
    
    
    public int getTurno(){
        return turno;
    }
}

