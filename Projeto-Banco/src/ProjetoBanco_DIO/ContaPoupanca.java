package ProjetoBanco_DIO;

public class ContaPoupanca extends Conta {
    private static final double JUROS_ANUAL = 0.01; // 1% ao ano

    public ContaPoupanca(int numeroConta, String cliente, double saldo) {
        super(numeroConta, cliente, saldo);
    }
    /*
    Simula a rentabilidade do saldo atual por um número de anos.
    @param anos Número de anos para a simulação.
    */

    public void simularRentabilidade(int anos) {
        if(anos < 0) {
            throw new IllegalArgumentException("O número de anos deve ser positivo");
        }
        // Formula: M = P * (1 + r)^t
        double saldoAtual = getSaldo();
        double saldoFuturo = saldoAtual * Math.pow(1 + JUROS_ANUAL, anos);

        System.out.println("=== Simulação de rentabilidade ===");
        imprimirExtrato();
        System.out.printf("Saldo após %d ano(s): R$%.2f%n", anos, saldoFuturo);
    }

}
