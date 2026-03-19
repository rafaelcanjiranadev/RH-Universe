package Model;

public class BeneficioModel {
    
    private int idBeneficio;
    private String Tipo;
    private double Valor;
    private int idPagamento;
    
    public BeneficioModel(int idBeneficio, String Tipo, double Valor, 
            int idPagamento) {
        this.idBeneficio = idBeneficio;
        this.Tipo = Tipo;
        this.Valor = Valor;
        this.idPagamento = idPagamento;
    }

    public BeneficioModel(String Tipo, double Valor) {
        this.Tipo = Tipo;
        this.Valor = Valor;
    }

    public int getidBeneficio() { return idBeneficio;}
    public String getTipo() { return Tipo;}
    public double getValor() { return Valor;}
    public int getIdPagamento() { return idPagamento;}
}