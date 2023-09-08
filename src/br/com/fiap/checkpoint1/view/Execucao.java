package br.com.fiap.checkpoint1.view;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

import br.com.fiap.checkpoint1.DAO.MensagemDAO;
import br.com.fiap.checkpoint1.jdbc.Conexao;
import br.com.fiap.checkpoint1.model.Mensagem;

public class Execucao {

    public static void main(String[] args) {
        try {
            Mensagem m = new Mensagem();
            MensagemDAO mensagemdao = new MensagemDAO(Conexao.getConexao());

            int realizar = 0;
            do {
                Scanner entrada = new Scanner(System.in);

                System.out.println("Bem vindo (a) ao nosso sistema de enviar mensagens!");
                System.out.println("Selecione a opcao que deseja: ");
                System.out.println("1. Enviar nova mensagem \n2. Deletar mensagem \n3. Alterar mensagem");
                int opcao = entrada.nextInt();

                switch (opcao) {
                    case 1:
                        System.out.println("Vamos começar...");

                        System.out.println("Primeiro digite o id da mensagem, \nSera importante, portanto, escolha com sabedoria");
                        long id = entrada.nextLong();
                        m.setId(id);

                        System.out.println("Agora, escreva qual o assunto da mensagem: ");
                        String assunto = entrada.next();
                        m.setAssunto(assunto);

                        System.out.println("Escreva pra quem você quer enviar: ");
                        String destinatario = entrada.next();
                        m.setDestinatario(destinatario);

                        System.out.println("Quem gostaria de enviar essa mensagem?");
                        String remetente = entrada.next();
                        m.setRemetente(remetente);

                        m.setData(LocalDate.now());

                        System.out.println("Finalmente, escreva a mensagem: ");
                        String conteudo = entrada.next();
                        m.setConteudo(conteudo);

                        m.setPrioridade(1);

                        mensagemdao.insert(m);

                        System.out.println("Mensagem enviada!");
                        break;

                    case 2:
                        System.out.println("Vamos deletar a mensagem desejada, nos diga o ID da mensagem: ");
                        int idDelete = entrada.nextInt();
                        mensagemdao.deletar(idDelete);

                        System.out.println("Mensagem deletada!");
                        break;

                    case 3:
                        System.out.println("Digite o id da mensagem que deseja alterar: ");
                        int idAltera = entrada.nextInt();

                        System.out.println("Escreva a mensagem nova: ");
                        String newMensagem = entrada.next();
                        
                        System.out.println("Qual seria o destinatario: ");
                        String destNew = entrada.next();
                        
                        System.out.println("Qual seria o remetente: ");
                        String remeNew = entrada.next();

                        mensagemdao.altera(idAltera, newMensagem, remeNew, destNew);

                        System.out.println("Mensagem alterada!");
                        break;

                    default:
                        System.out.println("Opção invalida. Por favor, selecione uma opção valida.");
                        break;
                }

                System.out.println("Deseja realizar mais alguma operacao?");
                System.out.println("1- Sim | 2 - Não");
                realizar = entrada.nextInt();

            } while (realizar == 1);

            System.out.println("Nunca eh um adeus, ate mais!");

        } catch (Exception e) {
            System.out.println("Deu ruim, pai");
            e.printStackTrace();
        }
    }

}

