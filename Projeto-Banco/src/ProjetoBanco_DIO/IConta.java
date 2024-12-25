package ProjetoBanco_DIO;

public interface IConta {
    void imprimirExtrato();
    boolean sacar(double valor);
    boolean transferir(double valor, Conta contaDestino);


}
