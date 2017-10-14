package Model;

import static Model.Movimento.*;

/**
 * @author deniojunior
 */
public class Transicao {
    private Estado estado;
    private String write;
    private Movimento move;
    
    public Transicao(){
        estado = new Estado();
        write = "";
        move = S;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getWrite() {
        return write;
    }

    public void setWrite(String write) {
        this.write = write;
    }

    public Movimento getMove() {
        return move;
    }

    public void setMove(Movimento move) {
        this.move = move;
    }
}