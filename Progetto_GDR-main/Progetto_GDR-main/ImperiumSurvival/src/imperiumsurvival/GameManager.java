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
public class GameManager implements java.io.Serializable {

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

    public void inizializzaGiovo() {
        FileManager fm = new FileManager();
        this.eventiDisponibili = fm.leggiFile();

        if (eventiDisponibili.isEmpty()) {
            System.err.println("Nessun evento caricato nel file");
        }

    }

    public void cliccaMArcia() {
        /*if (eventiDisponibili == null || eventiDisponibili.isEmpty()) {
        System.err.println("ERRORE: Nessun evento disponibile! Controlla il file .txt");
        return;
        }*/
        Random r = new Random();
        Evento estratto = eventiDisponibili.get(r.nextInt(eventiDisponibili.size()));
        this.ultimoEvento = estratto;

        turno++;
        giocatore.aggiungiMonete(1);

        giocatore.applicaEvento(estratto);

        giocatore.aggiornaStstusTurno();

        controllaGameOver();
    }

    public Evento getUltimoEvento() {
        return ultimoEvento;
    }

    public Imperatore getImperatore() {
        return this.giocatore;
    }

    public void cliccaAbilita() {
        giocatore.usaAbilita();
        giocatore.setAbilitaUsata(true);
        controllaGameOver();
    }

    public int controllaGameOver() {
        boolean perso = false;
        if (giocatore.getSalute() <= 0) {
            perso = true;
            JOptionPane.showMessageDialog(null, "Sei caduto in battaglia o per malattia. L'Impero piange il suo leader");
            return 1;
        } else if (giocatore.getMalcontento() >= 100) {
            perso = true;
            JOptionPane.showMessageDialog(null, "Il popolo ha dato fuoco al palazzo. La tua testa viene portata in trionfo per le strade di Roma");
            return 1;
        } else if (giocatore.getDissenso() >= 100) {
            perso = true;
            JOptionPane.showMessageDialog(null, "Le legioni ti hanno tradito. I Pretoriani sono entrati nelle tue stanze... le Idi di Marzo sono tornate");
            return 1;
        } else {
            return 0;
        }
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public void pagaPopolo() {
        if (giocatore.getMonete() >= 3) {
            giocatore.setMonete(giocatore.getMonete() - 3);

            int nuovoMalcontento = giocatore.getMalcontento() - 15;
            giocatore.setMalcontento(Math.max(0, nuovoMalcontento));
            JOptionPane.showMessageDialog(null, "Hai distribuito pane e giochi. Il malcontento scende!");

        } else {
            JOptionPane.showMessageDialog(null, "Le casse dello Stato sono vuote! Non puoi pagare il popolo.");
        }
    }
    
    public void pagaEsercito() {
        if (giocatore.getMonete() >= 3) {
            giocatore.setMonete(giocatore.getMonete() - 3);

            int nuovoDissenso = giocatore.getDissenso() - 15;
            giocatore.setDissenso(Math.max(0, nuovoDissenso));
            JOptionPane.showMessageDialog(null, "Hai pagato il Donativo alle Legioni. Il dissenso cala vistosamente!");

        } else {
            JOptionPane.showMessageDialog(null, "Le casse dello Stato sono vuote! Non puoi pagare l'esercito.");
        }
    }

}
