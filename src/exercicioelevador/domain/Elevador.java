package exercicioelevador.domain;
import exercicioelevador.exception.*;

public class Elevador {
    //Atributos
    private final int CAPACIDADE_TOTAl; // Uma vez inserido, constante
    private int passageirosPresentes = 0; //elevador vazio
    private int andarAtual = 0; //Inicia a partir térreo
    private final int TOTAL_ANDARES;

    //Construtor
    public Elevador(int CAPACIDADE_TOTAl, int TOTAL_ANDARES) {
        if (CAPACIDADE_TOTAl <= 0) {
            throw new IllegalArgumentException("A capacidade informada deve ser maior que zero");
        }

        if (TOTAL_ANDARES <= 0) {
            throw new IllegalArgumentException("O total de andares informado deve ser maior que zero");
        }

        this.CAPACIDADE_TOTAl = CAPACIDADE_TOTAl;
        this.TOTAL_ANDARES = TOTAL_ANDARES;
    }

    //Getters
    public int getAndarAtual() {return andarAtual;}
    public int getPassageirosPresentes() {return passageirosPresentes;}

    //Metodos
    public void subirUmAndar() {
        if (andarAtual < TOTAL_ANDARES) {
            andarAtual++;
        } else {
            throw new UltimoAndarException();
        }
    }

    public void descerUmAndar() {
        if (andarAtual > 0) {
            andarAtual--;
        } else {
            throw new TerreoException();
        }
    }

    public void entrarPassageiro() {
        if (passageirosPresentes >= CAPACIDADE_TOTAl) {
            throw new ElevadorCheioException();
        } else {
            passageirosPresentes++;
        }
    }

    public void sairPassageiro() {
        if (passageirosPresentes <= 0) {
            throw new ElevadorVazioException();
        } else {
            passageirosPresentes--;
        }
    }
}
