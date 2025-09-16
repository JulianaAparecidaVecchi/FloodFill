import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        // --- VERSÃO COM PILHA ---
        rodarPreenchimentoComPilha();

        System.out.println("\n-----------------------------------\n");

        // --- VERSÃO COM FILA ---
        rodarPreenchimentoComFila();
    }

    public static void rodarPreenchimentoComPilha() {
        try {
            System.out.println("Executando preenchimento com PILHA...");
            BufferedImage imagem = ImageIO.read(new File("coracao.png"));
            Ponto pontoInicial = new Ponto(imagem.getWidth() / 2, imagem.getHeight() / 2);
            Color novaCor = Color.RED;

            AlgoritmoPreenchimento floodFill = new AlgoritmoPreenchimento();
            floodFill.preencherComPilha(imagem, pontoInicial, novaCor);

            File arquivoDeSaida = new File("coracao_preenchido_pilha.png");
            ImageIO.write(imagem, "png", arquivoDeSaida);
            System.out.println("Imagem salva como: " + arquivoDeSaida.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void rodarPreenchimentoComFila() {
        try {
            System.out.println("Executando preenchimento com FILA...");
            BufferedImage imagem = ImageIO.read(new File("coracao.png")); // Recarrega a imagem original
            Ponto pontoInicial = new Ponto(imagem.getWidth() / 2, imagem.getHeight() / 2);
            Color novaCor = Color.BLUE; // Vamos usar AZUL para diferenciar

            AlgoritmoPreenchimento floodFill = new AlgoritmoPreenchimento();

            // A ÚNICA MUDANÇA REAL ESTÁ AQUI:
            floodFill.preencherComFila(imagem, pontoInicial, novaCor);

            File arquivoDeSaida = new File("coracao_preenchido_fila.png");
            ImageIO.write(imagem, "png", arquivoDeSaida);
            System.out.println("Imagem salva como: " + arquivoDeSaida.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}