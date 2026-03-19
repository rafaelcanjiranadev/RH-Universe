package Model;

public class DescontoModel {
    
    private int idDesconto;
    private String Tipo;
    private double Valor;
    private int idPagamento;
    
    public DescontoModel(int idDesconto, String Tipo, double Valor, 
            int idPagamento) {
        this.idDesconto = idDesconto;
        this.Tipo = Tipo;
        this.Valor = Valor;
        this.idPagamento = idPagamento;
    }

    public DescontoModel(String Tipo, double Valor) {
        this.Tipo = Tipo;
        this.Valor = Valor;
    }

    public int getidDesconto() { return idDesconto;}
    public String getTipo() { return Tipo;}
    public double getValor() { return Valor;}
    public int getIdPagamento() { return idPagamento;}
}