// Importa a classe ArrayList, que permite a leitura de ArrayList
import java.util.ArrayList;
// Importa a classe Scanner, que permite a leitura de dados a partir do teclado
import java.util.Scanner;
// Importa a classe List, que permite a leitura de List
import java.util.List;
//classe principal
public class Main
{
    //cria variavel para ser usada em todo o fonte
    static String espacamento = "______________________ \n";
    public static void main(String[] args) 
    {
        String opcaoSelecionada;
        boolean retornoMenu = true;
        String[] opcoesMenu = new String[]
        {
            "1 - Adiciona Time \n",
            "2 - Adiciona Jogo \n",
            "3 - Imprime Times \n",
            "4 - Imprime Resultados \n",
            "5 - Sair \n"
        };

        //cria a lista
        List<String> times = new ArrayList<String> ( );
        List<Jogos> jogos = new ArrayList<Jogos> ( );

        //Loop menu 
        while (retornoMenu)
        {
            System.out.print(espacamento);
            //Imprime o array com o menu de opcoes
            System.out.println("      BASKETBALL");
            System.out.print(espacamento);
            for(String opcoes: opcoesMenu)
            {
                System.out.print(opcoes);
            }
            System.out.print(espacamento);
            
            System.out.print("Digite opção do menu \n");
            //Recebe a opcao do menu escolhida
            Scanner lerop = new Scanner(System.in);
            opcaoSelecionada = lerop.next();
            System.out.print("\n");
            System.out.print(espacamento);
            
            //Faz a condicional da variavel opcaoSelecionada
            switch (opcaoSelecionada)
            {
                case "1":
                    //Adiciona times a lista times
                    AdicionarTime(times);
                    break;
                case "2":
                    //adiciona jogos a lista jogos
                    AdicionarJogo(jogos, times);
                    break;
                case "3":
                    //Imprime a lista de times
                    ImprimirTimes(times);
                    break;
                case "4":
                    //imprime os resultados dos jogos adicionados
                    ImprimirResult(jogos);
                    break;
                case "5":
                    //encerra o programa
                    System.out.print("SAIR! \n");
                    retornoMenu = false;
                    break;
                default:
                    //validaçao para digitar uma opcao valida
                    System.out.print("Digite uma opção válida! \n");
                    break;
            }
        }
    }
    //Gera impressão dos resultados 
    private static void ImprimirResult(List<Jogos> jogos)
    {
        System.out.print(espacamento);
        System.out.print("---IMPRESSAO RESULTADOS---- \n");
        System.out.print(espacamento);
        //Cria variaveis para o calculo da media
        int totalJogos = 0;
        float totalPontos = 0;
        float mediaPontos = 0;
        //faz a impressao dos resultados dos jogos 
        for(Jogos jogo: jogos)
        {
            System.out.print(jogo.time1 + " " + jogo.resultadoTime1 + " X " + jogo.time2 + " " + jogo.resultadoTime2 + " \n");
            //calcula a media de pontos por jogo
            totalJogos ++;
            totalPontos += jogo.resultadoTime1 + jogo.resultadoTime2;
        }
        
        //imprime a media
        System.out.print(espacamento);
        System.out.println("Média de pontos por Jogo: " + (totalPontos/totalJogos));
        
    }
    //Gera a impressao da lista de times
    private static void ImprimirTimes(List<String> times)
    {
        System.out.print(espacamento);
        System.out.print("---IMPRESSAO TIMES---- \n");
        System.out.print(espacamento);
        //imprime a lista de times
        for(String time: times)
        {              
            System.out.print(time+" \n");
        }
    }
    //Faz a adição de novos times
    private static void AdicionarTime(List<String> times)
    {
        boolean continuaAdicionar = true;
        String adiciona = " ";
        String novoItem = "N";
        //Loop para adicionar times
        while (continuaAdicionar)
        {
            System.out.print("Novo time na lista:  \n");
            Scanner add = new Scanner(System.in);
            adiciona = add.next();
            //valida se já existe
            times.add(adiciona);
            //pergunta ao usuário se quer adicionar mais times
            System.out.print("Deseja adicionar um novo time (S/N) ? \n");
            Scanner item = new Scanner(System.in);
            novoItem = item.next();

            //se não for adicionar novo, retorna para o menu
            if((novoItem.equals("N")) || (novoItem.equals("n")))
            {
                continuaAdicionar = false;
            }
        }
    }
    //Faz a adição de novos Jogos 
    private static void AdicionarJogo(List<Jogos> jogos, List<String> times)
    {
        //Instancia o objeto
        Jogos jogo = new Jogos();

        System.out.print(espacamento);
        //Imprime a lista de times para a escolha do jogo
        for(String time: times)
        {
            System.out.print(time + " \n");
        }
        System.out.print(espacamento);

        System.out.print("Digite um Time da lista acima: \n");
        Scanner time1 = new Scanner(System.in);
        jogo.time1 = time1.next();
        //Gera pontuação automática para o time 1
        jogo.resultadoTime1 = (int) (Math.random() * 201);  

        System.out.print(espacamento);
        //Gera lista com times para a escolha de um adversário
        for(String time: times)
        {
            //Validação para nao imprimir o time ja selecionado
            if (!time.equals(jogo.time1))
            {
                System.out.print(time + " \n");
            }                
        }
        System.out.print(espacamento);
        //Pede q incluam o time adversario
        System.out.print("Digite o time Adversário da lista acima: \n");
        Scanner time2 = new Scanner(System.in);
        jogo.time2 = time2.next();
        //gera pontuação automatica para o time 2
        jogo.resultadoTime2 = (int) (Math.random() * 201);   
        //adiciona o resultado a lista de jogos
        jogos.add(jogo);
    }
}
//cria classe classe de jogos
class Jogos
{
    public String time1;
    public String time2;
    public int resultadoTime1;
    public int resultadoTime2;
}