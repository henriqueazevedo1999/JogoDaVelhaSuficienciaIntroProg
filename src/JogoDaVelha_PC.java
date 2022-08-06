import javax.swing.UIDefaults.LazyInputMap;

public class JogoDaVelha_PC
{
    private JogoDaVelha_Mapa mapa;
    private char letra = 'O';
    
    public JogoDaVelha_PC(JogoDaVelha_Mapa mapa)
    {
        this.mapa = mapa;
    }

    public Boolean joga()
    {
        int linha = 0;
        int coluna = 0;

        do
        {
            linha = mapa.sortear(0, 2);
            coluna = mapa.sortear(0, 2);
        } while (!mapa.jogar(linha, coluna, letra));

        System.out.println("PC[" + linha + "," + coluna + "]");

        if (mapa.ganhou(letra))
        {
            System.out.println("... PC GANHOU!");
            return true;
        }
        
        return false;
    }
}
