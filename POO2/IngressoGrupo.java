import java.lang.reflect.Array;
import java.util.ArrayList;

public class IngressoGrupo extends Ingresso{
    private ArrayList<Jogo> jogos = new ArrayList<>();

    public IngressoGrupo(int id){
        super(id);

    }

    public void adicionar(Jogo jogo){
        jogos.add(jogo);
    }


    public double calcularValor(){
        ArrayList<Double> soPrecos = new ArrayList<>();

        
        for(Jogo valores : jogos){
            soPrecos.add(valores.getPreco());

        }

       double sum = soPrecos.stream().mapToDouble(i -> i).sum();


        return (0.9 * sum);
    }
    
}
