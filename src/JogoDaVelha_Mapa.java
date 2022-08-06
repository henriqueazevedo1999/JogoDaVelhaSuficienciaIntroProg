public class JogoDaVelha_Mapa
{
    private char[][] mapa = new char[3][3];

    public int sortear(int inicio, int fim)
    {
        return inicio + (int)(Math.random() * ((fim - inicio) + 1));
    }

    public void limpaMapa()
    {
        for (int linha = 0; linha < mapa.length; linha++)
            for (int coluna = 0; coluna < mapa.length; coluna++)
                mapa[linha][coluna] = ' ';  
    }

    public void desenha(int jogada)
    {
        System.out.println("------------- .. jogada: " + jogada);        
        System.out.println("| " + mapa[0][0] + " | " + mapa[0][1] + " | " + mapa[0][2] + " |");
        System.out.println("-------------");
        System.out.println("| " + mapa[1][0] + " | " + mapa[1][1] + " | " + mapa[1][2] + " |");
        System.out.println("-------------");
        System.out.println("| " + mapa[2][0] + " | " + mapa[2][1] + " | " + mapa[2][2] + " |");
        System.out.println("----------------------------");
    }

    public Boolean jogar(int l, int c, char jogador)
    {
        if (l >= mapa.length || c >= mapa[0].length)
            return false;

        if (mapa[l][c] != ' ')
            return false;

        mapa[l][c] = jogador;
        return true;
    }

    public Boolean ganhou(char jogador)
    {
        for (char[] linha : mapa)
        {
            if (linha[0] == jogador && linha[1] == jogador && linha[2] == jogador)
                return true;    
        }

        for (int coluna = 0; coluna < mapa[0].length; coluna++)
        {
            if (mapa[0][coluna] == jogador && mapa[1][coluna] == jogador && mapa[2][coluna] == jogador)
                return true;
        }

        if (mapa[0][0] == jogador && mapa[1][1] == jogador && mapa[2][2] == jogador)
            return true;
        
        if (mapa[2][0] == jogador && mapa[1][1] == jogador && mapa[0][2] == jogador)
            return true;

        return false;
    }
}
