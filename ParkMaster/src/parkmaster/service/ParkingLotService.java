/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parkmaster.service;

import java.util.List;
import parkmaster.dao.ParkingLotDAO;
import parkmaster.model.ParkingLot;

/**
 *
 * @author rolas
 */
public class ParkingLotService {
    private final ParkingLotDAO parkingLotDAO;

    public ParkingLotService(ParkingLotDAO parkingLotDAO) {
        this.parkingLotDAO = parkingLotDAO;
    }
    
    /**
     * Adiciona um novo estacionamento ao sistema.
     *
     * @param lot o estacionamento a ser adicionado
     */
    public void addParkingLot(ParkingLot lot) {
        try {
            parkingLotDAO.save(lot);
            System.out.println("Estacionamento adicionado com sucesso: " + lot.getName());
        } catch (Exception e) {
            System.out.println("Erro ao adicionar estacionamento: " + e.getMessage());
        }
    }

    /**
     * Actualiza as informações de um estacionamento existente.
     *
     * @param lot o estacionamento a ser atualizado
     */
    public void updateParkingLot(ParkingLot lot) {
        try {
            parkingLotDAO.update(lot);
            System.out.println("Estacionamento atualizado com sucesso: " + lot.getName());
        } catch (Exception e) {
            System.out.println("Erro ao atualizar estacionamento: " + e.getMessage());
        }
    }

    /**
     * Remove um estacionamento do sistema.
     *
     * @param lotId o ID do estacionamento a ser removido
     */
    public void removeParkingLot(int lotId) {
        try {
            parkingLotDAO.delete(lotId);
            System.out.println("Estacionamento removido com sucesso. ID: " + lotId);
        } catch (Exception e) {
            System.out.println("Erro ao remover estacionamento: " + e.getMessage());
        }
    }

    /**
     * Consulta a lista de todos os estacionamentos.
     *
     * @return uma lista de todos os estacionamentos cadastrados
     */
    public List<ParkingLot> getAllParkingLots() {
        return parkingLotDAO.findAll();
    }
}
