package uy.jv.prueba.Model;


import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class FibonacciModel {

    @Id
    private int value_id;
    private int result;

    
    // getters
    public int getValueId () {
        return this.value_id;
    }

    public int getResult () {
        return this.result;
    }

    // setters
    public void setValueId (int value) {
        this.value_id = value;
    }

    
    public void setResult (int result) {
        this.result = result;
    }


    
}
