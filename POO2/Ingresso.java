public abstract class Ingresso extends Jogo{    
    private Jogo jogo;

    public Ingresso (int codigo){
        super(codigo);
    }

    public Ingresso (double preco){
        super(preco);
    }
    
    public abstract double calcularValor();//{
        //return 1.2 * this.preco; 
   //}

    public void setJogo(Jogo j){
        this.jogo = j;
    }

}
