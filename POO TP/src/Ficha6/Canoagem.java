package Ficha6;

/*********************************************************************************/
/** DISCLAIMER: Este cÃ³digo foi criado e alterado durante as aulas prÃ¡ticas      */
/** de POO. Representa uma soluÃ§Ã£o em construÃ§Ã£o, com base na matÃ©ria leccionada */
/** atÃ© ao momento da sua elaboraÃ§Ã£o, e resulta da discussÃ£o e experimentaÃ§Ã£o    */
/** durante as aulas. Como tal, nÃ£o deverÃ¡ ser visto como uma soluÃ§Ã£o canÃ³nica,  */
/** ou mesmo acabada. Ã‰ disponibilizado para auxiliar o processo de estudo.      */
/** Os alunos sÃ£o encorajados a testar adequadamente o cÃ³digo fornecido e a      */
/** procurar soluÃ§Ãµes alternativas, Ã  medida que forem adquirindo mais           */
/** conhecimentos de POO.                                                        */
/*********************************************************************************/

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


public class Canoagem extends Atividade{
    private String barco;
    private double vento;
    private double distancia;
    private int nvoltas;

    public Canoagem() {
        super();
        this.barco = "";
        this.vento = 0;
        this.distancia = 0;
        this.nvoltas = 0;
    }


    public Canoagem(String codigo, String descricao, LocalDate data, int duracao, String barco, double vento, double distancia, int nvoltas) {
        super(codigo, descricao, data, duracao);
        this.barco = barco;
        this.vento = vento;
        this.distancia = distancia;
        this.nvoltas = nvoltas;
    }

    public Canoagem(Canoagem outro) {
        super(outro);
        this.barco = outro.getBarco();
        this.vento = outro.getVento();
        this.distancia = outro.getDistancia();
        this.nvoltas = outro.getNvoltas();
    }


    public String getBarco() {
        return barco;
    }

    public void setBarco(String barco) {
        this.barco = barco;
    }

    public double getVento() {
        return vento;
    }

    public void setVento(double vento) {
        this.vento = vento;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public int getNvoltas() {
        return nvoltas;
    }

    public void setNvoltas(int nvoltas) {
        this.nvoltas = nvoltas;
    }

    @Override
    public double calorias() {
        long idade =  ChronoUnit.YEARS.between(LocalDate.now(),getUser().getDataNascimento());
        return distancia*vento*getDuracao()*idade/4;
    }

    @Override
    public Atividade clone() {
        return new Canoagem(this);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Canoagem canoagem = (Canoagem) o;
        return Double.compare(canoagem.getVento(), getVento()) == 0
                && Double.compare(canoagem.getDistancia(), getDistancia()) == 0
                && getNvoltas() == canoagem.getNvoltas()
                && this.barco.equals(canoagem.getBarco());
    }

    @Override
    public String toString() {
        return "Canoagem{" +
                super.toString() +
                "barco='" + barco + '\'' +
                ", vento=" + vento +
                ", distancia=" + distancia +
                ", nvoltas=" + nvoltas +
                '}';
    }
}