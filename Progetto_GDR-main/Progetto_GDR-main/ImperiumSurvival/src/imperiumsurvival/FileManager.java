/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package imperiumsurvival;

import java.io.*;
import java.util.*;
/**
 *
 * @author onorati.nicolo
 */
public class FileManager {
    private String file = "eventi.txt";
    
    public List<Evento> leggiFile(){
        String riga;
        List<Evento> listaEventi = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            
            br.readLine();
            
            while((riga = br.readLine()) != null){
                String[] parti = riga.split(",");
                String nome = parti[0].trim();
                String messaggio = parti[1].trim();
                int salute = Integer.parseInt(parti[2].trim());
                int dissenso = Integer.parseInt(parti[3].trim());
                int malcontento = Integer.parseInt(parti[4].trim());
                String path = parti[5].trim();
                
                Evento e = new Evento(nome, messaggio, salute, dissenso, malcontento, path);
                listaEventi.add(e);
            }
            
        }
        catch(IOException e){
            System.out.println("Errore nella lettura del file");
        }
        //System.out.println("DEBUG: Ho letto " + listaEventi.size() + " eventi dal file."); // AGGIUNGI QUESTA RIGA
        return listaEventi;
    }
}
