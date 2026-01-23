package com.philipecarvalho.exercicioelevador.service;

import com.philipecarvalho.exercicioelevador.domain.Elevator;

/**
 * Classe realizada para chamar serviços corretos
 */
public class ElevatorService {
    private final Elevator ELEVATOR;

    public  ElevatorService(Elevator ELEVATOR) {
        this.ELEVATOR = ELEVATOR;
    }

    public int passengers() {return ELEVATOR.getCurrentPassengers();}
    public int floors() {return ELEVATOR.getCurrentFloor();}

    public void up() {
        ELEVATOR.moveUpOneFloor();
    }

    public void down() {
        ELEVATOR.moveDownOneFloor();
    }

    public void enter() {
        ELEVATOR.aPassengerEnter();
    }

    public void leave() {
        ELEVATOR.aPassengerLeave();
    }
}
