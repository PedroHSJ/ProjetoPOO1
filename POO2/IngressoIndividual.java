public class IngressoIndividual extends Ingresso {
    private Jogo jogo;

    public IngressoIndividual(int id){
        super(id);
    }
   

    public void setJogo(Jogo j){
        this.jogo = j;
    }

    @Override
    public double calcularValor(){
        return 1.2 * this.preco;
    }

    public String toString(){
        return "Código => " + getId();
    }

    
    //public double calcularValor();
}
