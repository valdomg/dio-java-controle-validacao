package dio.validacao;

import java.util.concurrent.ThreadLocalRandom;

public class Validacao {
    public static void main(String[] args) {
        selecaoCanditatos();
    }

    static void selecaoCanditatos (){
        String [] candidatos = {"FELIPE","MARCIA","PAULO","AUGUSTO","MONICA","FABRICIO","MIRELA","DANIELA","JORGE"};

        int candidatosSelecionados = 0;
        int canditatoAtual =  0;

        final double SALARIO_BASE = 2000.0;

        while (candidatosSelecionados < 5 && canditatoAtual < candidatos.length){
            String candidato = candidatos[canditatoAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("O candidato " + candidato + " Solicitou este valor de salário "+ salarioPretendido);
            if (salarioPretendido <= SALARIO_BASE){
                System.out.println("O candidato " + candidato + " foi selecionado para a vaga");
                candidatosSelecionados++;
            }
            canditatoAtual++;
        }

        System.out.println("Total de Candidatos Selecionados: "+ candidatosSelecionados);

    }

    static double valorPretendido(){
        return ThreadLocalRandom.current().nextDouble(1800,2200);
    }

    static void analisarCandidato(double salarioPretendido){
        final double SALARIO_BASE = 2000.0;

        if (salarioPretendido < SALARIO_BASE){
            System.out.println("LIGAR PARA O CANDIDATO.");
        } else if (salarioPretendido == SALARIO_BASE) {
            System.out.println("LIGAR PARA O CANDIDATO COM CONTRA PROPOSTA");
        }
        else {
            System.out.println("AGUARDANDO DEMAIS CANDIDATOS");
        }
    }


}
