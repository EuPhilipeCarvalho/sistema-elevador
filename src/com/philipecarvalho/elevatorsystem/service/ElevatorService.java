package com.philipecarvalho.elevatorsystem.service;

import com.philipecarvalho.elevatorsystem.domain.Elevator;

/**
 * Classe realizada para chamar serviços corretos
 */
public class ElevatorService {
    private final Elevator elevator;

    public  ElevatorService(Elevator elevator) {
        this.elevator = elevator;
    }

    public int passengers() {return elevator.getCurrentPassengers();}
    public int floors() {return elevator.getCurrentFloor();}

    public void up() {
        elevator.moveUpOneFloor();
    }

    public void down() {
        elevator.moveDownOneFloor();
    }

    public void enter() {
        elevator.addPassenger();
    }

    public void leave() {
        elevator.removePassenger();
    }
}
