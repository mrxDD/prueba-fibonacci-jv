package uy.jv.prueba.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class StatisticsModel {

    @Id
    private int value;
    private int attempts; // cantidad de intentos del valor consultado


    public int getValue () {
        return this.value;
    }

    public int getAttempts () {
        return this.attempts;
    }

    public void setValue (int value) {
        this.value = value;
    }

    public void setAttempts (int attempt) {
        this.attempts = attempt;
    }
    
}
