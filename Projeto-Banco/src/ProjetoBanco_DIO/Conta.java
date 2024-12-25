package ProjetoBanco_DIO;

public class Conta implements IConta{

    protected int numeroConta;
    protected String cliente;
    protected double saldo;

    public Conta(int numeroConta, String cliente, double saldo) {
        this.numeroConta = numeroConta;
        this.cliente = cliente;
        this.saldo = saldo;
    }

    @Override
    public void imprimirExtrato() {

    }

    public void depositar(double valor) {
        if(valor > 0) {
            saldo += valor;
            System.out.println("Depósito de R$" + valor + " realizado com sucesso. Seu saldo atual é de R$" + saldo);
        }else {
            System.out.println("Valor invalido para depósito");
        }
    }


    @Override
    public boolean sacar(double valor) {
        if(valor <= saldo){
            saldo -= valor;
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean transferir(double valor, Conta contaDestino) {
        if(sacar(valor)) {
            contaDestino.depositar(valor);
            System.out.println("Transferência de valor R$" + valor + " realizada para a conta - " + contaDestino.getNumeroConta());
            return true;
        }
        return false;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public String getCliente() {
        return cliente;
    }

    public double getSaldo() {
        return saldo;
    }
}
