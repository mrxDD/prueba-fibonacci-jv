package uy.jv.prueba.FibonacciController;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uy.jv.prueba.Fibonacci.Fibonacci;
import uy.jv.prueba.Model.FibonacciModel;
import uy.jv.prueba.Model.StatisticsModel;
import uy.jv.prueba.Repositories.IFibonacciRepository;
import uy.jv.prueba.Repositories.IStatisticsRepository;

@RestController
@RequestMapping("/v1/fibonacci") // defino el endpoint para la solicitud
public class FibonacciController {

    // se inyectan la interfaces de lo que serian DAOs
    @Autowired
    private IFibonacciRepository repo;
    @Autowired
    private IStatisticsRepository repoS;

    //@GetMapping
    @PostMapping
    public Integer doFibonacci (@RequestBody String value) {
        
        Integer resultado = 0;
        
        boolean isValueOnDB = repo.existsById(Integer.parseInt(value)); // verifico si el valor recibido ya se encuentra en la base

        if (isValueOnDB) {
            Optional<FibonacciModel> fm = repo.findById(Integer.parseInt(value));
            
            resultado = fm.get().getResult();
        }

        // de lo contrario se obtiene resultado de la clase implementada y se persiste numero-resultado 

        else {
            resultado = Fibonacci.getFib(Integer.parseInt(value));

            FibonacciModel fb = new FibonacciModel();

            fb.setValueId(Integer.parseInt(value)); // valor recibido en el request
            fb.setResult(resultado);

            repo.save(fb);
        }


        // Auditoria
        boolean wasConsulted = repoS.existsById(Integer.parseInt(value)); 

        // si el valor ya habia sido consultado previamente, se obtiene y se incrementa su ocurrencia
        if (wasConsulted) {
            Optional<StatisticsModel> sm = repoS.findById(Integer.parseInt(value));

            Integer dbAttemp = sm.get().getAttempts();

            dbAttemp = dbAttemp + 1;
           
            sm.get().setAttempts(dbAttemp); // modifico el valor incrementado en la entity

            repoS.save(sm.get());
        }

        // de lo contrario se persiste primer valor consultado con contador en 1
        else {
            StatisticsModel sm = new StatisticsModel();

            sm.setValue(Integer.parseInt(value));
            sm.setAttempts(1);

            repoS.save(sm);
        }

     return resultado;

    }

    

}
