/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package imperiumsurvival;

/**
 *
 * @author onorati.nicolo
 */
public abstract class Imperatore {
    private int salute;
    private int malcontento;
    private int dissenso;

    public int getSalute() {
        return salute;
    }

    public int getMalcontento() {
        return malcontento;
    }

    public int getDissenso() {
        return dissenso;
    }
    
    public abstract void usaAbilita();
    public void aggiornaStstusTurno(){
        
    }
    
    public void applicaEvento(Evento e){
        
    }
}
