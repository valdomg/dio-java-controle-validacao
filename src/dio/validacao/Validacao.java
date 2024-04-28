package dio.validacao;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Validacao {
    public static void main(String[] args) {

        String [] candidatos = {"FELIPE","MARCIA","PAULO","AUGUSTO","MONICA","FABRICIO","MIRELA","DANIELA","JORGE"};

        String [] candidatosSelecionados = selecaoCandidatos(candidatos);

        System.out.println();

        imprimirListaSelecionados(candidatosSelecionados);

        System.out.println();

        entrarEmContato(candidatosSelecionados);

    }

    //Método para Seleção de Candidatos
    static String[] selecaoCandidatos(String [] candidatos){

        int candidatosSelecionados = 0;
        int canditatoAtual =  0;
        String [] listaSelecionados = new String[5];
        int index = 0;


        final double SALARIO_BASE = 2000.0;

        while (candidatosSelecionados < 5 && canditatoAtual < candidatos.length){
            String candidato = candidatos[canditatoAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("O candidato " + candidato + " Solicitou este valor de salário "+ salarioPretendido);
            if (salarioPretendido <= SALARIO_BASE){
                System.out.println("O candidato " + candidato + " foi selecionado para a vaga");
                candidatosSelecionados++;
                listaSelecionados[index] = candidato;
                index++;
            }
            System.out.println();
            canditatoAtual++;

        }

        System.out.println("Total de Candidatos Selecionados: "+ candidatosSelecionados);
        return listaSelecionados;
    }

    //Método para imprimir a lista de cadidatos
    static void imprimirListaSelecionados(String [] selecionados){
        System.out.println("=====LISTA DE CANDIDATOS SELECIONADOS=====");
        for (int i = 0; i < selecionados.length; i++){
            if (selecionados[i] == null){
                break;
            }else {
                System.out.println("O candidato de nº: "+(i +1) +" é: " + selecionados[i]);
            }
        }
    }

    //Método para ligar para candidato
    static void entrarEmContato(String [] candidatos){


        boolean continuarTentando = true;
        boolean atendeu = false;

        for (String candidato: candidatos){
            if (candidato == null){
                break;
            }
            int tentativasRealizadas = 1;

            do {
                atendeu = atender();
                continuarTentando = !atendeu;

                if (continuarTentando)
                    tentativasRealizadas++;
                else
                    System.out.println("CONTATO REALIZADO COM SUCESSO");

            } while (continuarTentando && tentativasRealizadas < 4);

            if (atendeu){
                System.out.println("CONSEGUIMOS CONTATO COM " + candidato + " NA "+ tentativasRealizadas+"º TENTATIVA REALIZADA");
            }
            else {
                System.out.println("NÃO CONSEGUIMOS CONTATO COM O CANDIDATO "+ candidato +" NO NÚMERO MÁXIMO DE "+ (tentativasRealizadas - 1) +" TENTATIVAS");
            }
            System.out.println();
        }
    }

    //Metodo para simulação de ligação
    static boolean atender(){
        return new Random().nextInt(3)==1;
    }

    //Método para Randomizar o valor de salário
    static double valorPretendido(){
        return ThreadLocalRandom.current().nextDouble(1800,2200);
    }

    //Método para Análise de Candidato
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
