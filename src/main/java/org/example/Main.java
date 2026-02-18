package org.example;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        inicio();
    }

    public static void inicio(){
        System.out.println("""
                --- Sistema de Logística ---
                1 - Cadastrar Cliente
                2 - Cadastrar Motorista
                3 - Criar Pedido
                4 - Atribuir Pedido a Motorista (Gerar Entrega)
                5 - Registrar Evento de Entrega (Histórico)
                6 - Atualizar Status da Entrega
                7 - Listar Todas as Entregas com Cliente e Motorista
                8 - Relatórios Sistema
                9 - Buscar Pedido por Documento
                10 - Cancelar Pedido
                11 - Excluir Entrega (com validação)
                12 - Excluir Cliente (com verificação de dependência)
                13 - Excluir Motorista (com verificação de dependência)
                0 - Sair
               
                Escolha uma opção: 
                """);

        int opcao = sc.nextInt();
        sc.nextLine();

        switch (opcao){
            case 1: {
                cadastrarCliente();
                break;
            }

            case 2: {
                cadastrarMotorista();
                break;
            }

            case 3: {
                criarPedido();
                break;
            }

            case 4: {
                atribuirPedido();
                break;
            }

            case 5: {
                registrarEventoEntrega();
                break;
            }

            case 6: {
                atualizarStatusEntrega();
                break;
            }

            case 7: {
                listarEntregas();
                break;
            }

            case 8: {
                relatorioSistema();
                break;
            }

            case 9: {
                buscarPedidoPorDocumento();
                break;
            }

            case 10: {
                cancelarPedido();
                break;
            }

            case 11: {
                excluirEntrega();
                break;
            }

            case 12: {
                excluirCliente();
                break;
            }

            case 13: {
                excluirMotorista();
                break;
            }

            case 0: {
                System.exit(0);
            }
        }
    }

    public static void cadastrarCliente() {
        System.out.println("Qual o nome do Cliente que deseja cadastrar?: ");
        String clienteNome = sc.nextLine();

        System.out.println("Qual o CPF/CNPJ do Cliente?: ");
        String clienteCpf_cnpj = sc.nextLine();

        System.out.println("Qual o endereço do Cliente?: ");
        String clienteEndereco = sc.nextLine();

        System.out.println("Qual a cidade do Cliente?: ");
        String clienteCidade = sc.nextLine();

        System.out.println("Qual o estado do Cliente?: ");
        String clienteEstado = sc.nextLine();

        var cadastrarCliente = new SistemaLE();

        try{
            cadastrarCliente.salvarCliente(new Cliente(clienteNome, clienteCpf_cnpj, clienteEndereco, clienteCidade, clienteEstado));
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar um cliente.");
            e.printStackTrace();
        }
    }

    public static void cadastrarMotorista() {
        System.out.println("Qual o nome do Motorista que deseja cadastrar?: ");
        String motoristaNome = sc.nextLine();

        System.out.println("Qual a CNH do Motorista que deseja cadastrar?: ");
        String motoristaCnh = sc.nextLine();

        System.out.println("Qual o veículo que o Motorista dirige?: ");
        String motoristaCarro = sc.nextLine();

        System.out.println("Qual a Cidade Base que o Motorista se desloca?: ");
        String motoristaCidadeBase = sc.nextLine();

        var cadastrarMotorista = new SistemaLE();

        try{
            cadastrarMotorista.salvarMotorista(new Motorista(motoristaNome, motoristaCnh, motoristaCarro, motoristaCidadeBase));
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar um cliente.");
            e.printStackTrace();
        }
    }

    public static void criarPedido() {
        System.out.println("Qual o ID do Cliente?: ");
        Integer pedidoIDCliente = sc.nextInt();

        System.out.println("Qual a Data do pedido? (dd/mm/aaaa): ");
        String pedidoData = sc.nextLine();

        System.out.println("Qual o tamanho do pedido?: ");
        String pedidoTamanhom3 = sc.nextLine();

        System.out.println("Qual o peso do pedido?: ");
        String pedidoPeso = sc.nextLine();

        System.out.println("Qual o Status do pedido?: ");
        String pedidoStatus = sc.nextLine();

    }

    public static void atribuirPedido() {
    }

    public static void registrarEventoEntrega() {
        System.out.println("Qual o ID do Pedido?: ");
        Integer entregapedidoID = sc.nextInt();

        System.out.println("Qual o ID do Motorista?: ");
        Integer entregapedidoIDm = sc.nextInt();

        System.out.println("Qual a data de saída da entrega?: ");
        String entregapedidoSaida = sc.nextLine();

        System.out.println("Qual a data de entrega da entrega?: ");
        String entregapedidoEntrega = sc.nextLine();

        System.out.println("Qual o Status da entrega?: ");
        String entregapedidoStatus = sc.nextLine();
    }

    public static void atualizarStatusEntrega() {
    }

    public static void listarEntregas() {
        System.out.println("Qual o ID da entrega?: ");
        Integer historicoIDEntrega = sc.nextInt();

        System.out.println("Quando ocorreu a entrega?: ");
        String historicoDataEntrega = sc.nextLine();

        System.out.println("Descrição da entrega: ");
        String historicoDescricao = sc.nextLine();
    }

    public static void relatorioSistema() {
        System.out.println("""
                --- Menu de Relatórios ---
                1 - Total de Entregas por Motorista
                2 - Clientes com Maior Volume Entregue
                3 - Pedidos Pendentes por Estado
                4 - Entregas Atrasadas por Cidade
                0 - Voltar
                
                Escolha o relatório: 
                """);

        int opcaorelatorio = sc.nextInt();
        sc.nextLine();

        switch(opcaorelatorio) {
            case 1 : {
                relatorioEntregasPorMotorista();
            }

            case 2 : {
                relatorioVolumePorCliente();
            }

            case 3 : {
                relatorioPendentesPorEstado();
            }

            case 4 : {
                relatorioAtrasosPorCidade();
            }

            case 0 : {
                System.out.println("Voltando ao sistema...");
                inicio();
            }
        }
        sc.close();
    }

    private static void relatorioEntregasPorMotorista() {
    }

    private static void relatorioVolumePorCliente() {
    }

    private static void relatorioPendentesPorEstado() {
    }

    private static void relatorioAtrasosPorCidade() {
    }

    public static void buscarPedidoPorDocumento() {
    }

    public static void cancelarPedido() {
    }

    public static void excluirEntrega() {
    }

    public static void excluirCliente() {
    }

    public static void excluirMotorista() {
    }
}