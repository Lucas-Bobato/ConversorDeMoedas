import java.util.HashMap;
import java.util.Map;

class ConversorDeMoedas {
    private Map<CategoriaMoeda, Moeda> moedas;

    public ConversorDeMoedas() {
        moedas = new HashMap<>();
        inicializarMoedas();
    }

    private void inicializarMoedas() {
        moedas.put(CategoriaMoeda.DOLAR, new Moeda(CategoriaMoeda.DOLAR, 1.0f));
        moedas.put(CategoriaMoeda.EURO, new Moeda(CategoriaMoeda.EURO, 0.85f));
        moedas.put(CategoriaMoeda.REAL, new Moeda(CategoriaMoeda.REAL, 5.25f));
        moedas.put(CategoriaMoeda.LIBRA, new Moeda(CategoriaMoeda.LIBRA, 0.75f));
    }

    public Moeda obterMoeda(CategoriaMoeda categoria) {
        return moedas.get(categoria);
    }

    public float converter(CategoriaMoeda de, CategoriaMoeda para, float valor) {
        Moeda moedaOrigem = obterMoeda(de);
        Moeda moedaDestino = obterMoeda(para);
        return moedaOrigem.converterPara(moedaDestino, valor);
    }

    public void listarMoedas() {
        System.out.println("Moedas disponíveis:");
        for (CategoriaMoeda moeda : CategoriaMoeda.values()) {
            System.out.println("- " + moeda.getNome());
        }
    }
}
