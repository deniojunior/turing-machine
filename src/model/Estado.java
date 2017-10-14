package Model;

import static Model.TipoEstado.INTERMEDIARIO;

/**
 * @author deniojunior
 */
public class Estado {
    private String nome;
    private int id;
    private TipoEstado tipo;
    
    public Estado(){
        nome = "";
        tipo = INTERMEDIARIO;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public String getNome(){
        return nome;
    }
    
    public void setTipo(TipoEstado tipo){
        this.tipo = tipo;
    }
    
    public TipoEstado getTipo(){
        return tipo;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public int getId(){
        return id;
    }   
}