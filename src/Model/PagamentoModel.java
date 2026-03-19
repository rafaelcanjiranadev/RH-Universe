package Model;

public class PagamentoModel {

    private int idPagamento;
    private String NomeFuncionario;
    private Mes Mes;
    public enum Mes {JANEIRO, FEVEREIRO, MARÇO, ABRIL, MAIO, JUNHO, JULHO, AGOSTO, SETEMBRO, OUTUBRO, NOVEMBRO, DEZEMBRO};
    private String ano;
    private double salarioMensal;
    private int Jornada;
    private double horasExtras;
    private double beneficioTotal;
    private double salarioBruto;
    private double inss;
    private double descontoTotal;
    private double salarioLiquido;
    private double fgts;
    
    public PagamentoModel(int idPagamento, String NomeFuncionario, Mes Mes, 
                          String ano, double salarioMensal, int Jornada, double horasExtras, 
                          double beneficioTotal, double salarioBruto,double inss, 
                          double descontoTotal, double salarioLiquido, double fgts) {

        this.idPagamento = idPagamento;
        this.NomeFuncionario = NomeFuncionario;
        this.Mes = Mes;
        this.ano = ano;
        this.salarioMensal = salarioMensal;
        this.Jornada = Jornada;
        this.horasExtras = horasExtras;
        this.beneficioTotal = beneficioTotal;
        this.salarioBruto = salarioBruto;
        this.inss = inss;
        this.descontoTotal = descontoTotal;
        this.salarioLiquido = salarioLiquido;
        this.fgts = fgts;
    }

    public PagamentoModel(String NomeFuncionario, Mes Mes, String ano, double salarioMensal, int Jornada,
                          double horasExtras, double beneficioTotal, double salarioBruto,
                          double inss, double descontoTotal, double salarioLiquido, double fgts) {

        this.NomeFuncionario = NomeFuncionario;
        this.Mes = Mes;
        this.ano = ano;
        this.salarioMensal = salarioMensal;
        this.Jornada = Jornada;
        this.horasExtras = horasExtras;
        this.beneficioTotal = beneficioTotal;
        this.salarioBruto = salarioBruto;
        this.inss = inss;
        this.descontoTotal = descontoTotal;
        this.salarioLiquido = salarioLiquido;
        this.fgts = fgts;
    }

    public int getIdPagamento() { return idPagamento; }
    public String getNomeFuncionario() { return NomeFuncionario; }
    public Mes getMes() { return Mes; }
    public String getAno() { return ano; }
    public double getSalarioMensal() { return salarioMensal; }
    public int getJornada() { return Jornada; }
    public double getHorasExtras() { return horasExtras; }
    public double getBeneficioTotal() { return beneficioTotal; }
    public double getSalarioBruto() { return salarioBruto; }
    public double getInss() { return inss; }
    public double getDescontoTotal() { return descontoTotal; }
    public double getSalarioLiquido() { return salarioLiquido; }
    public double getFgts() { return fgts; }
}