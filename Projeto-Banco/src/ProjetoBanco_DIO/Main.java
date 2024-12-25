package ProjetoBanco_DIO;

public class Main {
    public static void main(String[] args) {
        ContaCorrente cc1 = new ContaCorrente(1111,"João Victor",1450,500);
        ContaCorrente cc2 = new ContaCorrente(1112,"Higor Freitas", 2350,800);
        ContaPoupanca cp = new ContaPoupanca(1112,"João Victor",3000);

        // Fazendo operações na conta corrente:
        cc1.depositar(2000);
        System.out.println(" ");
        cc1.imprimirExtrato();


        cc1.transferir(2000,cc2);
        System.out.println(" ");
        cc1.imprimirExtrato();
        System.out.println(" ");
        cc2.imprimirExtrato();



    }


}
