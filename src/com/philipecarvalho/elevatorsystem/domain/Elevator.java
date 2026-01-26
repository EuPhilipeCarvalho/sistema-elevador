package com.philipecarvalho.elevatorsystem.domain;

import com.philipecarvalho.elevatorsystem.exception.ElevadorEmptyException;
import com.philipecarvalho.elevatorsystem.exception.ElevatorFullException;
import com.philipecarvalho.elevatorsystem.exception.GroundFloorException;
import com.philipecarvalho.elevatorsystem.exception.LastFloorException;

public class Elevator {
    /**
     * Elevador inicia no terreo e vazio
     */
    private final int maxCapacity;
    private int currentPassengers= 0;
    private final int totalFloors;
    private int currentFloor = 0;

    //Construtor
    public Elevator(int maxCapacity, int totalFloors) {
        if (maxCapacity <= 0) {
            throw new IllegalArgumentException("A capacidade informada deve ser maior que zero");
        }

        if (totalFloors <= 0) {
            throw new IllegalArgumentException("O total de andares informado deve ser maior que zero");
        }

        this.maxCapacity = maxCapacity;
        this.totalFloors = totalFloors;
    }

    public int getCurrentFloor() { return this.currentFloor; }
    public int getCurrentPassengers() { return this.currentPassengers; }

    public void moveUpOneFloor() {
        if (currentFloor >= totalFloors) {
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
        if (currentPassengers >= maxCapacity) {
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
