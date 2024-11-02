/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parkmaster.view;

import java.sql.SQLException;
import java.util.Scanner;
import parkmaster.controller.CustomerController;
import parkmaster.model.Customer;

/**
 * Classe para interagir com operações relacionadas a Clientes.
 */
public class CustomerView {
    private final Scanner scanner;
    private final CustomerController clientController;

    public CustomerView() {
        scanner = new Scanner(System.in);
        clientController = new CustomerController();
    }

    public void showMenu() throws SQLException {
        int choice;
        do {
            System.out.println("Menu:");
            System.out.println("1. Adicionar Cliente");
            System.out.println("2. Listar Todos os Clientes");
            System.out.println("3. Buscar Cliente por ID");
            System.out.println("4. Actualizar Cliente");
            System.out.println("5. Excluir Cliente");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> insertClient();
                case 2 -> getAllClients();
                case 3 -> getClientById();
                case 4 -> updateClient();
                case 5 -> deleteClient();
                case 0 -> System.out.println("A sair do programa.");
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        } while (choice != 0);

        clientController.closeConnection();
    }

    void insertClient() {
        System.out.print("Nome: ");
        String name = scanner.nextLine();
        System.out.print("Apelido: ");
        String lastName = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Telefone: ");
        String phone = scanner.nextLine();
        System.out.print("Endereço: ");
        String address = scanner.nextLine();
//        Customer client = new Customer(name, lastName, email, phone, address);
//        clientController.insertClient(client);
    }


    void getAllClients() {
//        System.out.println(clientController.getAllClients());
    }

    void getClientById() {
        System.out.print("ID do Cliente: ");
        long id = scanner.nextLong();
//        System.out.println(clientController.getClientById(id));
    }

    void updateClient() {
        System.out.print("ID do Cliente: ");
        long customerID = scanner.nextLong();
        System.out.print("Novo Nome: ");
        String firstName = scanner.nextLine();
        System.out.print("Novo Apelido: ");
        String lastName = scanner.nextLine();
        System.out.print("Novo Email: ");
        String email = scanner.nextLine();
        System.out.print("Novo Telefone: ");
        String phone = scanner.nextLine();
        System.out.print("Novo Endereço: ");
        String address = scanner.nextLine();

//        Customer client = new Customer(firstName, lastName, email, phone, address);
//        client.setCustomerID(customerID);
//        clientController.updateClient(client);
    }

    void deleteClient() {
        System.out.print("ID do Cliente a ser excluído: ");
        long id = scanner.nextLong();
//        clientController.deleteClient(id);
    }

    public static void main(String[] args) throws SQLException {
        CustomerView app = new CustomerView();
        app.showMenu();
    }
}

