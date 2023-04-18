package uy.jv.prueba.Repositories;

import org.springframework.data.repository.CrudRepository;

import uy.jv.prueba.Model.FibonacciModel;


// Iterfaz 
public interface IFibonacciRepository extends CrudRepository < FibonacciModel, Integer > {


}
