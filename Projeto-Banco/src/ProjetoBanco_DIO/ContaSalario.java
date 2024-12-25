package ProjetoBanco_DIO;

public class ContaSalario {
    protected String nome;
    protected String conta;
    protected double saldo;

    public void imprimirExtrato(){
        System.out.println("O saldo disponivel é R$" + saldo);
    }

    public boolean sacar(double valor) {
        double saldoDisponivel = getSaldo();
        if(valor > 0 && valor <= saldoDisponivel) {
            double novoSaldo = getSaldo() - valor;
        }else {
            System.out.println("A conta não tem saldo disponível para saque.");
            return false;
        }
        System.out.println("O saque no valor de R$" + valor + " foi realizado com sucesso. Novo saldo disponível R$" + saldoDisponivel);
        return false;
    }

    public ContaSalario(String nome, String conta, double saldo) {
        this.nome = nome;
        this.conta = conta;
        this.saldo = 0.0;
    }

    public String getNome() {
        return nome;
    }

    public String getConta() {
        return conta;
    }

    public double getSaldo() {
        return saldo;
    }

}
