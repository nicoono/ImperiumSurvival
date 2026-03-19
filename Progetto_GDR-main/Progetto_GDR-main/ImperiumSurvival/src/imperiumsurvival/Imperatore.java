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
    protected String nome;
    protected int salute;
    protected int malcontento;
    protected int dissenso;
    protected String pathImmagine;
    
    public Imperatore(String nome, int salute, int malcontento, int dissenso) {
        this.nome = nome;
        this.salute = salute;
        this.malcontento = malcontento;
        this.dissenso = dissenso;
    }

    public int getSalute() {
        return salute;
    }

    public int getMalcontento() {
        return malcontento;
    }

    public int getDissenso() {
        return dissenso;
    }
    
    
    public String getPathImmagine() {
        return pathImmagine;
    }
    
    public abstract void usaAbilita();
    
    
    public void aggiornaStstusTurno(){
        malcontento += 5;
        dissenso+=5;
    }
    
    
    
    
    public void applicaEvento(Evento e){
        
        if(salute > 100){
            salute=100;
        }
        if(malcontento < 0){
            malcontento = 0;
        }
        if(dissenso < 0){
            dissenso = 0;
        }
        
    }
}
