package uy.jv.prueba.Repositories;

import org.springframework.data.repository.CrudRepository;

import uy.jv.prueba.Model.StatisticsModel;

public interface IStatisticsRepository extends CrudRepository < StatisticsModel, Integer> {
    
}
