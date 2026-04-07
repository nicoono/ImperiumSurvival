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
                int salute = Integer.parseInt(parti[2].replaceAll("[^0-9-]", ""));
                int dissenso = Integer.parseInt(parti[3].replaceAll("[^0-9-]", ""));
                int malcontento = Integer.parseInt(parti[4].replaceAll("[^0-9-]", ""));
                String path = parti[5].trim();
                
                Evento e = new Evento(nome, messaggio, salute, dissenso, malcontento, path);
                listaEventi.add(e);
            }
            
        }
        catch(IOException e){
            System.out.println("Errore nella lettura del file");
        }
        
        return listaEventi;
    }
    
    public void salvaPartitaCSV(GameManager gm , String nomeFile){
        Imperatore imp = gm.getImperatore();
        int turno = gm.getTurno();
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(nomeFile + ".csv"))){
            bw.write("Nome,Salute,Malcontento,Dissenso,TurniScudo,TurnoAttuale");
            bw.newLine();
            bw.write(imp.nome + "," + imp.salute + "," + imp.malcontento + "," + imp.dissenso + "," + imp.turniProtezione + "," + turno + "," + imp.isAbilitaUsata());
            System.out.println("Salvataggio CSV creato");
        }
        catch(IOException e){
            System.out.println("Errore salvataggio CSV");
        }
    }
    public Imperatore caricaPartitaCSV(String nomeFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(nomeFile + ".csv"))) {
            br.readLine();
            String riga = br.readLine();

            if (riga != null) {
                String[] dati = riga.split(",");
                String nome = dati[0];
                int salute = Integer.parseInt(dati[1]);
                int malcontento = Integer.parseInt(dati[2]);
                int dissenso = Integer.parseInt(dati[3]);
                int protezione = Integer.parseInt(dati[4]);
                int turno = Integer.parseInt(dati[5]);
                boolean usata = Boolean.parseBoolean(dati[6]); 
                
                
                Imperatore caricato = null;
                caricato.setAbilitaUsata(usata);

                if (nome.equals("Augusto")) {
                    caricato = new Augusto();
                } else if (nome.equals("Giulio Cesare")) {
                    caricato = new GiulioCesare();
                } else if (nome.equals("Nerone")) {
                    caricato = new Nerone();
                } else if (nome.equals("Marco Aurelio")) {
                    caricato = new MarcoAurelio();
                }

                if (caricato != null) {
                    caricato.salute = salute;
                    caricato.dissenso = dissenso;
                    caricato.malcontento = malcontento;
                    caricato.turniProtezione = protezione;
                }
                return caricato;
            }

        } catch (IOException | NumberFormatException e) {
            System.out.println("Errore nel caricamento CSV");
        }
        return null;
    }
    
    public void salvaPartitaSER(GameManager gm, String nomeFile){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomeFile+ ".ser"))){
            oos.writeObject(gm);
            System.out.println("salvataggio SER creato");
        }
        catch(IOException e){
            System.out.println("Errore salvataggio SER");
        }
    }
    
    public GameManager caricaPartitaSer(String nomeFile){
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomeFile+ ".ser"))){
            GameManager caricato = (GameManager) ois.readObject();
            return caricato;
        }
        catch(IOException | ClassNotFoundException e){
            System.out.println("Errore caricamento SER");
            return null;
        }
    }
}
