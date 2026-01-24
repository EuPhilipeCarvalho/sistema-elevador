package com.philipecarvalho.elevatorsystem.domain;

import com.philipecarvalho.elevatorsystem.exception.ElevadorEmptyException;
import com.philipecarvalho.elevatorsystem.exception.ElevatorFullException;
import com.philipecarvalho.elevatorsystem.exception.GroundFloorException;
import com.philipecarvalho.elevatorsystem.exception.LastFloorException;

public class Elevator {
    /**
     * Elevador inicia no terreo e vazio
     */
    private final int MAX_CAPACITY;
    private int currentPassengers= 0;
    private final int TOTAL_FLOORS;
    private int currentFloor = 0;

    //Construtor
    public Elevator(int MAX_CAPACITY, int TOTAL_FLOORS) {
        if (MAX_CAPACITY <= 0) {
            throw new IllegalArgumentException("A capacidade informada deve ser maior que zero");
        }

        if (TOTAL_FLOORS <= 0) {
            throw new IllegalArgumentException("O total de andares informado deve ser maior que zero");
        }

        this.MAX_CAPACITY = MAX_CAPACITY;
        this.TOTAL_FLOORS = TOTAL_FLOORS;
    }

    public int getCurrentFloor() { return this.currentFloor; }
    public int getCurrentPassengers() { return this.currentPassengers; }

    public void moveUpOneFloor() {
        if (currentFloor >= TOTAL_FLOORS) {
            throw new LastFloorException();
        } else {
            currentFloor++;
        }
    }

    public void moveDownOneFloor() {
        if (currentFloor <= 0) {
            throw new GroundFloorException();
        } else {
            currentFloor--;
        }
    }

    public void addPassenger() {
        if (currentPassengers >= MAX_CAPACITY) {
            throw new ElevatorFullException();
        } else {
            currentPassengers++;
        }
    }

    public void removePassenger() {
        if (currentPassengers <= 0) {
            throw new ElevadorEmptyException();
        } else {
            currentPassengers--;
        }
    }
}
