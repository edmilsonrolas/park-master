/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parkmaster.model;

/**
 *
 * @author rolas
 *
 * Representa um Parque de estacionamento no sistema.
 */
public class ParkingLot extends BaseEntity{
    private String location;
    private int capacity;
    private int currentOccupancy;
    private float tariff; // Tarifa por hora ou diária
    private int parkingManagerId;

    /**
     * Construtor para criar um objecto Parque de Estacionamento.
     *
     * @param id          o ID do parque
     * @param name        o nome do parque
     * @param location a localização do parque
     * @param capacity  a capacidade do parque
     */
    public ParkingLot(int id, String name, String location, int capacity) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.capacity = capacity;
    }

    /**
     * Adiciona um novo parque de estacionamento.
     *
     * @param name        o nome do novo parque
     * @param location a localização do novo parque
     * @param capacity  a capacidade do novo parque
     */
    public void addParkingLot(String name, String location, int capacity) {
        // Logic to add a parking lot
    }

    /**
     * Edits an existing parking lot.
     *
     * @param id       the parking lot ID
     * @param name     the new name of the parking lot
     * @param location the new location of the parking lot
     * @param capacity the new capacity of the parking lot
     */
    public void editParkingLot(int id, String name, String location, int capacity) {
        // Logic to edit a parking lot
    }

    /**
     * Removes a parking lot by its ID.
     *
     * @param id the parking lot ID
     */
    public void removeParkingLot(int id) {
        // Logic to remove a parking lot
    }

    public String generateOccupancyReport() {
        // Gerar relatório de ocupação
        return "Occupancy Report for " + name + ": " + currentOccupancy + "/" + capacity;
    }

    public float calculateRevenue() {
        // Calcular receita
        return currentOccupancy * tariff;
    }
    
    /**
     * Ajusta a tarifa do parque de estacionamento.
     * @param newTariff Nova tarifa a ser aplicada.
     */
    public void adjustTariff(float newTariff) {
        if (newTariff >= 0) {  // Garantir que a tarifa é válida
            this.tariff = newTariff;
            System.out.println("Tarifa ajustada para: " + newTariff);
        } else {
            System.out.println("A tarifa deve ser positiva.");
        }
    }

    // Método para acessar a tarifa atual
    public float getTariff() {
        return this.tariff;
    }
}
