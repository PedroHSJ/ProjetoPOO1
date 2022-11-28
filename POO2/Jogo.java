import java.util.ArrayList;

public class Jogo {
    private int id;
    protected double preco;
    private String data;
    public String estadio;
    private int estoque;    
    private Time time1;
    private Time time2;
    private ArrayList<IngressoIndividual> ingressos = new ArrayList<>();
    private ArrayList<IngressoGrupo> ingressosGrupo = new ArrayList<>();

    public Jogo(int recbId, String recebData, String recebEstadio, int recbEstoque, double recebPreco, Time recebTime1, Time recebTime2){
        super();
        this.id = recbId;        
        this.data = recebData;
        this.estadio = recebEstadio;
        this.estoque = recbEstoque; 
        this.preco = recebPreco;       
        this.time1 = recebTime1;
        this.time2 = recebTime2;
        

    }

    /*public Jogo(int codigo, double preco) {
        this.id = codigo;
        this.preco = preco;
    }*/

    public Jogo(int codigo) {
        this.id = codigo;
        //this.preco = preco;
    }

    public Jogo (double preco){
        this.preco = preco;
    }

    public Jogo (String recbNome, String recebOrigem){
    }

    /*public double getPreco(){
        return preco;
    }*/

    public int getId(){
        return this.id;
    }

    public String getData(){
        return this.data;
    }

    public String getLocal(){
        return this.estadio;
    }

    public int getEstoque(){
        return this.estoque;
    }

    public double getPreco(){
        return this.preco;
    }

    public void getIngreso(){
        for (IngressoIndividual ingresso : ingressos){
            System.out.println(ingresso.getId());
        }
    }

    public void setTime1(Time jogos){
        this.time1 = jogos;
    }

    public Time getTime1(){
        return this.time1;
    } 

    public Time getTime2(){
        return this.time2;
    }

    public void setTime2(Time nome2){
        this.time2 = nome2;
    }
    
    public void adicionar (IngressoIndividual tickt){
        ingressos.add(tickt);
    }

    public void adicionar (IngressoGrupo tickt){
        ingressosGrupo.add(tickt);
    }

    @Override
    public String toString(){
        return "id => " + this.id +
                "\ndata => " + getData() +
                "\nlocal => " + getLocal() +
                "\nestoque => " + getEstoque() + 
                "\nPreço => " + getPreco() +
                "\nNomes dos times => " + getTime1().getNome() + " x " + getTime2().getNome();
                //"Codigos do ingresso => " + 
    }
}