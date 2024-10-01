class Moeda {
    private CategoriaMoeda categoria;
    private float taxaParaUSD;

    public Moeda(CategoriaMoeda categoria, float taxaParaUSD) {
        this.categoria = categoria;
        this.taxaParaUSD = taxaParaUSD;
    }

    public CategoriaMoeda getCategoria() {
        return categoria;
    }

    public float converterPara(Moeda moedaDestino, float valor) {
        float valorEmUSD = valor / this.taxaParaUSD;
        return valorEmUSD * moedaDestino.taxaParaUSD;
    }
}