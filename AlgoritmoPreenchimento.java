// Dentro de AlgoritmoPreenchimento.java

import java.awt.Color;
import java.awt.image.BufferedImage;

public class AlgoritmoPreenchimento {

    // Este será o método que usa a Pilha
    public void preencherComPilha(BufferedImage imagem, Ponto pontoInicial, Color novaCor) {
        // 1. Obter a cor original que será substituída
        int corOriginalRGB = imagem.getRGB(pontoInicial.x, pontoInicial.y);
        Color corOriginal = new Color(corOriginalRGB);

        // Se a cor do ponto clicado já for a nova cor, não faz nada.
        if (corOriginal.equals(novaCor)) {
            return;
        }

        // 2. Criar a Pilha
        // A capacidade pode ser o total de pixels da imagem (largura * altura)
        int capacidade = imagem.getWidth() * imagem.getHeight();
        Pilha pilha = new Pilha(capacidade);

        // 3. Adicionar o ponto inicial na pilha
        pilha.empilhar(pontoInicial);

        // 4. Iniciar o loop de preenchimento
        while (!pilha.estaVazia()) {
            // Pegue um ponto da pilha
            Ponto p = pilha.desempilhar();

            // Verifique se o ponto 'p' é válido (dentro da imagem e com a cor certa)
            if (p.x >= 0 && p.x < imagem.getWidth() && p.y >= 0 && p.y < imagem.getHeight()) {
                if (imagem.getRGB(p.x, p.y) == corOriginalRGB) {

                    // Se for válido:
                    // a. Pinte o pixel
                    imagem.setRGB(p.x, p.y, novaCor.getRGB());

                    // b. Adicione os 4 vizinhos na pilha
                    pilha.empilhar(new Ponto(p.x + 1, p.y)); // Direita
                    pilha.empilhar(new Ponto(p.x - 1, p.y)); // Esquerda
                    pilha.empilhar(new Ponto(p.x, p.y + 1)); // Baixo
                    pilha.empilhar(new Ponto(p.x, p.y - 1)); // Cima
                }
            }
        }
    }

    public void preencherComFila(BufferedImage imagem, Ponto pontoInicial, Color novaCor) {
        // 1. Obter a cor original (lógica idêntica)
        int corOriginalRGB = imagem.getRGB(pontoInicial.x, pontoInicial.y);
        if (corOriginalRGB == novaCor.getRGB()) {
            return; // Se a cor já for a desejada, não faz nada.
        }

        // 2. Criar a Fila (a única mudança aqui é o nome da classe)
        int capacidade = imagem.getWidth() * imagem.getHeight();
        Fila fila = new Fila(capacidade);

        // 3. Adicionar o ponto inicial na fila (mudou o nome do método)
        fila.enfileirar(pontoInicial);

        // 4. Iniciar o loop de preenchimento
        while (!fila.estaVazia()) {
            // Pegue um ponto da fila (mudou o nome do método)
            Ponto p = fila.desenfileirar();

            // A lógica de validação e pintura é EXATAMENTE a mesma
            if (p != null && p.x >= 0 && p.x < imagem.getWidth() && p.y >= 0 && p.y < imagem.getHeight()) {
                if (imagem.getRGB(p.x, p.y) == corOriginalRGB) {

                    // a. Pinte o pixel
                    imagem.setRGB(p.x, p.y, novaCor.getRGB());

                    // b. Adicione os 4 vizinhos na fila (mudou o nome do método)
                    fila.enfileirar(new Ponto(p.x + 1, p.y)); // Direita
                    fila.enfileirar(new Ponto(p.x - 1, p.y)); // Esquerda
                    fila.enfileirar(new Ponto(p.x, p.y + 1)); // Baixo
                    fila.enfileirar(new Ponto(p.x, p.y - 1)); // Cima
                }
            }
        }
    }

}
