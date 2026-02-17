package org.example;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

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
                
                Escolha uma opção: """);

        int opcao = sc.nextInt();
        sc.nextLine();

        switch (opcao){
            case 1: {
                cadastrarCliente();
            }

            case 2: {
                cadastrarMotorista();
            }

            case 3: {
                criarPedido();
            }

            case 4: {
                atribuirPedido();
            }

            case 5: {
                registrarEventoEntrega();
            }

            case 6: {
                atualizarStatusEntrega();
            }

            case 7: {
                listarEntregas();
            }

            case 8: {
                relatorioSistema();
            }

            case 9: {
                buscarPedidoPorDocumento();
            }

            case 10: {
                cancelarPedido();
            }

            case 11: {
                excluirEntrega();
            }

            case 12: {
                excluirCliente();
            }

            case 13: {
                excluirMotorista();
            }

            case 0: {
                System.exit(0);
            }
        }
    }


    public static void cadastrarCliente() {
    }

    public static void cadastrarMotorista() {
    }

    public static void criarPedido() {
    }

    public static void atribuirPedido() {
    }

    public static void registrarEventoEntrega() {
    }

    public static void atualizarStatusEntrega() {
    }

    public static void listarEntregas() {
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
                System.out.println("Saindo...");
            } while (opcaorelatorio != 0);
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