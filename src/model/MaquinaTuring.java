package Model;

import java.util.ArrayList;

/**
 * @author deniojunior
 */
public class MaquinaTuring {
    private String simboloInicioFita;
    private String simboloBraco;
    private ArrayList<String> alfabeto;
    private ArrayList<String> alfabetoAux;
    private ArrayList<Estado> estados;
    
    public MaquinaTuring(){
        simboloBraco = "β";
        simboloInicioFita = "¤";
        alfabeto = new ArrayList<>();
        alfabetoAux = new ArrayList<>();
        estados = new ArrayList<>();
    }

    public String getSimboloInicioFita() {
        return simboloInicioFita;
    }

    public void setSimboloInicioFita(String simboloInicioFita) {
        this.simboloInicioFita = simboloInicioFita;
    }

    public String getSimboloBraco() {
        return simboloBraco;
    }

    public void setSimboloBraco(String simboloBraco) {
        this.simboloBraco = simboloBraco;
    }

    public ArrayList<String> getAlfabeto() {
        return alfabeto;
    }

    public void setAlfabeto(ArrayList<String> alfabeto) {
        this.alfabeto = alfabeto;
    }

    public ArrayList<String> getAlfabetoAux() {
        return alfabetoAux;
    }

    public void setAlfabetoAux(ArrayList<String> alfabetoAux) {
        this.alfabetoAux = alfabetoAux;
    }

    public ArrayList<Estado> getEstados() {
        return estados;
    }

    public void setEstados(ArrayList<Estado> estados) {
        this.estados = estados;
    }
}
