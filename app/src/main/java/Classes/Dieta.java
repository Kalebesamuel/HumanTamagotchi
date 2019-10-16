package Classes;

import java.util.ArrayList;
import java.util.List;

/**Classe desitnada a armazenar a definição da dieta do usuário.
 *
 */

public class Dieta {

    //private Double calorias ?????
    private List<Alimentos> alimentos;
    private List<Alimentos> alimentosSemelhantes;
    private int refeicao;

    public Dieta() {
        alimentos = new ArrayList();
        alimentosSemelhantes = new ArrayList();
    }

    public Dieta(List<Alimentos> alimentos, List<Alimentos> alimentosSemelhantes, int refeicao) {
        this.alimentos = alimentos;
        this.alimentosSemelhantes = alimentosSemelhantes;
        this.refeicao = refeicao;
    }

    public List<Alimentos> getAlimentos() {
        return alimentos;
    }

    public void setAlimentos(List<Alimentos> alimentos) {
        this.alimentos = alimentos;
    }

    public List<Alimentos> getAlimentosSemelhantes() {
        return alimentosSemelhantes;
    }

    public void setAlimentosSemelhantes(List<Alimentos> alimentosSemelhantes) {
        this.alimentosSemelhantes = alimentosSemelhantes;
    }

    public int getRefeicao() {
        return refeicao;
    }

    public void setRefeicao(int refeicao) {
        this.refeicao = refeicao;
    }
}
