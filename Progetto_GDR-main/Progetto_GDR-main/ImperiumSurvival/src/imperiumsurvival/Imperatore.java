/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package imperiumsurvival;

/**
 *
 * @author onorati.nicolo
 */
public abstract class Imperatore implements java.io.Serializable{
    protected String nome;
    protected int salute;
    protected int malcontento;
    protected int dissenso;
    protected String pathImmagine;
    protected int turniProtezione = 0;
    protected boolean abilitaUsata = false;
    
    
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
    
    public boolean isAbilitaUsata() {
        return abilitaUsata;
    }
    public void setAbilitaUsata(boolean stato) {
        this.abilitaUsata = stato;
    }
    
    public String getPathImmagine() {
        return pathImmagine;
    }
    
    public abstract void usaAbilita();
    
    
    public void aggiornaStstusTurno(){
        if(turniProtezione > 0){
            turniProtezione--;
        }
        else{
            malcontento += 5;
            dissenso+=5;
        }
        
        
        
    }
    
    
    
    
    public void applicaEvento(Evento e){
              
        int modS = e.getModSalute();
        int modD = e.getModDissenso();
        int modM = e.getModMalcontento();


        if(turniProtezione > 0){
            if(modS < 0){
                modS /= 2;
            }
            if(modD > 0){
                modD /= 2;
            }
            if(modM > 0){
                modM /= 2;
            } 
        }
        
        this.salute += modS;
        this.dissenso += modD;
        this.malcontento += modM;
        
        if(salute > 130){
            salute=130;
        }
        if(malcontento < 0){
            malcontento = 0;
        }
        if(malcontento > 100){
            malcontento = 100;
        }
        if(dissenso > 100){
            dissenso = 100;
        }
        if(dissenso < 0){
            dissenso = 0;
        }
        
    }
}
