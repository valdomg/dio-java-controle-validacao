package dio.controle.fluxo;

import java.util.Scanner;

public class Contador {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Digite o parâmetro subtraendo");
        int parametroUm = input.nextInt();
        System.out.println("Digite o parâmetro minuendo");
        int parametroDois = input.nextInt();

        try{
            contar(parametroUm,parametroDois);
        } catch (ParametrosInvalidosException e){
            System.out.println("Minuendo deve ser maior que o subtraendo");
        }
    }

    static void contar(int parametroUm, int parametroDois) throws ParametrosInvalidosException{
        if (parametroDois < parametroUm) {
            throw new ParametrosInvalidosException();
        }
        else {
            int contador = parametroDois - parametroUm;
            for (int i = 0; i <= contador; i++){
                System.out.println("Imprimindo o número: " + i);
            }
        }

    }
}
