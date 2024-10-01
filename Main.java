import java.util.Scanner;
import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) {
        ConversorDeMoedas conversor = new ConversorDeMoedas();
        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#.00"); // Formato para 2 casas decimais

        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Listar Moedas");
            System.out.println("2. Converter Moeda");
            System.out.println("3. Sair");

            int escolha = scanner.nextInt();
            if (escolha == 3) {
                break;
            } else if (escolha == 1) {
                conversor.listarMoedas();
                System.out.println("Digite 0 para voltar ao Menu.");
                int voltar = scanner.nextInt();
                if (voltar != 0) {
                    System.out.println("Opção inválida. Digite 0 para voltar ao Menu.");
                }
            } else if (escolha == 2) {
                System.out.print("Digite a moeda de origem (DOLAR, EURO, REAL, LIBRA): ");
                String de = scanner.next().toUpperCase();
                System.out.print("Digite a moeda de destino (DOLAR, EURO, REAL, LIBRA): ");
                String para = scanner.next().toUpperCase();
                System.out.print("Digite o valor a converter: ");
                float valor = scanner.nextFloat();

                try {
                    CategoriaMoeda moedaOrigem = CategoriaMoeda.valueOf(de);
                    CategoriaMoeda moedaDestino = CategoriaMoeda.valueOf(para);
                    float valorConvertido = conversor.converter(moedaOrigem, moedaDestino, valor);
                    System.out.println(valor + " " + moedaOrigem.getNome() + " é igual a: " + df.format(valorConvertido) + " " + moedaDestino.getNome());
                } catch (IllegalArgumentException e) {
                    System.out.println("Moeda não encontrada. Por favor, verifique a entrada.");
                }
                System.out.println("Digite 0 para voltar ao Menu.");
                int voltar = scanner.nextInt();
                if (voltar != 0) {
                    System.out.println("Opção inválida. Digite 0 para voltar ao Menu.");
                }
            } else {
                System.out.println("Opção inválida. Digite 0 para voltar ao Menu.");
            }
        }
        scanner.close();
    }
}

enum CategoriaMoeda {
    DOLAR("Dólar"),
    EURO("Euro"),
    REAL("Real"),
    LIBRA("Libra Esterlina");

    private final String nome;

    CategoriaMoeda(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
