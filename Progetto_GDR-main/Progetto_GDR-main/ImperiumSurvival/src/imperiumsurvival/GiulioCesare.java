/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package imperiumsurvival;

/**
 *
 * @author onorati.nicolo
 */
public class GiulioCesare extends Imperatore {

    public GiulioCesare() {
        // Ora il "super" trova il costruttore corrispondente in Imperatore
        super("Giulio Cesare", 100, 30, 10); 
        
        this.pathImmagine = "/imperiumsurvival/Giulio_Cesare.png"; 
    }

    @Override
    public void usaAbilita() {
        // Alea Iacta Est: Azzera il Malcontento, ma +20 Dissenso Militare.
        this.malcontento = 0;
        this.dissenso += 20;
    }
    
    
}
