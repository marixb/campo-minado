    package com.mariana.model;

    import org.junit.jupiter.api.Test;
    import static org.junit.jupiter.api.Assertions.*;

    class TabuleiroTest {

        @Test
        void deveCriarTabuleiroComTamanhoCorreto() {
            Tabuleiro tabuleiro = new Tabuleiro(8, 8, 10);
            assertEquals(8, tabuleiro.getLinhas());
            assertEquals(8, tabuleiro.getColunas());
        }

        @Test
        void deveContarMinasVizinhasCorretamente() {
            Tabuleiro tabuleiro = new Tabuleiro(3, 3, 0);
            tabuleiro.colocarMina(0, 0);
            assertEquals(1, tabuleiro.contarMinasVizinhas(1, 1));
        }

        @Test
        void NaoDeveContarMinaNaProriaCelula(){
            Tabuleiro tabuleiro = new Tabuleiro (3,3,0);
            tabuleiro.colocarMina(1,1 );
            assertEquals(0, tabuleiro.getCelula(1, 1).getMinasVizinhas());
        }

        @Test
        void DeveContarMultiplasMinasVizinhas(){
            Tabuleiro tabuleiro = new Tabuleiro (3,3,0);
            tabuleiro.colocarMina(0, 0);
            tabuleiro.colocarMina(0, 1);
            tabuleiro.colocarMina(1, 0);
            assertEquals(3, tabuleiro.contarMinasVizinhas(1, 1));
        }

        @Test
        void CelulaDoCantoIgnorarFora(){
            Tabuleiro tabuleiro = new Tabuleiro(3,3,0);
            tabuleiro.colocarMina(1, 0);
            tabuleiro.colocarMina(0, 1);
            assertEquals(2, tabuleiro.contarMinasVizinhas(0, 0));
        }
    }
