import java.util.Scanner;

public class JogoDaVelha_Jogador
{
    private JogoDaVelha_Mapa mapa;
    private char letra = 'X';

    public JogoDaVelha_Jogador(JogoDaVelha_Mapa mapa)
    {
        this.mapa = mapa;
    }

    public Boolean joga(Scanner teclado)
    {
        System.out.println("Jogador ..");

        Boolean jogadaValida = false;

        while (!jogadaValida)
        {
            System.out.println("linha:");
            int linha = teclado.nextInt();
            System.out.println("coluna:");
            int coluna = teclado.nextInt();
            
            jogadaValida = mapa.jogar(linha, coluna, letra);
            if (!jogadaValida)
                System.out.println("Posição invalida, tente novamente");
        }

        if (mapa.ganhou(letra))
        {
            System.out.println("... Jogador GANHOU!");
            return true;
        }    

        return false;
    }
}
