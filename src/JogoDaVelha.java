import java.util.Scanner;

public class JogoDaVelha
{
    private static JogoDaVelha_Mapa jogoMapa;
    private static JogoDaVelha_PC jogoPC;
    private static JogoDaVelha_Jogador jogoJogador;

    private static void jogar(Scanner teclado)
    {
        jogoMapa.limpaMapa();
        jogoMapa.desenha(0);
        
        byte qtdJogadas = 0;
        
        int sorteio = jogoMapa.sortear(0, 1);
        Boolean vezPC = sorteio == 0;
        Boolean temVencedor = false;
        
        while (!temVencedor && qtdJogadas < 9)
        {
            temVencedor = vezPC ? jogoPC.joga() : jogoJogador.joga(teclado);
            
            qtdJogadas++;
            if (qtdJogadas == 9 && !temVencedor)
                System.out.println("... EMPATOU!");

            jogoMapa.desenha(qtdJogadas);    
            vezPC = !vezPC;
        }

        System.out.println("\n________________________");
    }

    public static void main(String[] args) 
    {
        Scanner teclado = new Scanner(System.in);
        jogoMapa = new JogoDaVelha_Mapa();
        jogoPC = new JogoDaVelha_PC(jogoMapa);
        jogoJogador = new JogoDaVelha_Jogador(jogoMapa);
        
        Boolean jogarNovamente = true;
        while (jogarNovamente)
        {
            jogar(teclado);

            while (true)
            {
                System.out.println("Deseja jogar novamente (s/n)?");
                char resposta = teclado.next().charAt(0);
                if (resposta == 's' || resposta == 'n')
                {
                    jogarNovamente = resposta == 's';
                    break;
                }

                System.out.println("Inválido. Tente novamente.");
            }

        }
    }
}
