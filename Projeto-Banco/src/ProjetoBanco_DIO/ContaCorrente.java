package ProjetoBanco_DIO;

import java.time.LocalDate;

public class ContaCorrente extends Conta {
    private double limite;
    private double saqueDiarioAtual; // Rastreia o total sacado no dia.
    private LocalDate dataUltimoSaque; // Armazena a data do ultimo saque.
    private LocalDate dataUltimaOperacao; // Armazena a data da última operação(saque ou transferência)

    public ContaCorrente(int numeroConta, String cliente, double saldo, double limite) {
        super(numeroConta, cliente, saldo); // Chamando o construtor da classe conta
        this.limite = limite;
        this.saqueDiarioAtual = 0;
        this.dataUltimoSaque = LocalDate.now();
    }


    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    @Override
    public boolean sacar(double valor) {
        LocalDate hoje = LocalDate.now();

        // Reinicia o limite diário se for um novo dia
        if(!hoje.isEqual(dataUltimoSaque)) {
            saqueDiarioAtual = 0;
            dataUltimoSaque = hoje;
        }
        if(valor > 3000) {
            System.out.println("Erro: O limite de saque diário é de R$3000.0");
            return false;
        }
        if (saqueDiarioAtual + valor > 3000) {
            System.out.println("Erro: Você excederia o limite diário de R$3000.0 com esse saque.");
            return false;
        }

        double saldoDisponivel = getSaldo() + limite; // Saldo + limite disponível = saldo total
        if(valor > 0 && valor <= saldoDisponivel) {
            double novoSaldo = getSaldo() - valor;

            // Atualiza o saldo negativo se necessário
            if(novoSaldo < 0) {
                super.sacar(getSaldo()); // Zera o saldo da conta principal
                limite += novoSaldo; // Reduz o limite pelo valor que ficou negativo
            }else {
                super.sacar(valor);
            }
            saqueDiarioAtual += valor; // Atualiza o total sacado no dia
            double saldoTotal = getSaldo() + limite;
            System.out.println("Saque de R$" + valor + " realizado com sucesso. Limite disponivel agora: R$" + saldoTotal);
            return true;
        }
        System.out.println("Erro: Saldo insuficiente para saque.");
        return false;
    }


    @Override
    public void imprimirExtrato() {
        double saldoTotal = getSaldo() + limite;

        System.out.println("==== Extrato Bancário ====");
        super.imprimirExtrato();
        System.out.println("O limite disponível é R$" + limite);
        System.out.println("O saldo total da conta é R$" + saldoTotal);
        System.out.println("O total sacado hoje foi R$" + saqueDiarioAtual);
        System.out.println("===============================");
    }

}
