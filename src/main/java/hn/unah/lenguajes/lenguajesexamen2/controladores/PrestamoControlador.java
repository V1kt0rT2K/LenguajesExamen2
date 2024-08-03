package hn.unah.lenguajes.lenguajesexamen2.controladores;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.unah.lenguajes.lenguajesexamen2.modelos.Prestamo;
import hn.unah.lenguajes.lenguajesexamen2.servicios.PrestamoServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/api/prestamo")
public class PrestamoControlador 
{

    @Autowired
    private PrestamoServicio prestamoServicio;

    @PostMapping("/crear/{dni}")
    public Prestamo crearPrestamo(@PathVariable(name = "dni") String dni ,@RequestBody Prestamo prestamo) {
        
        return this.prestamoServicio.crearPrestamo(dni, prestamo);
    }

    @GetMapping("/buscar/{codigoPrestamo}")
    public Prestamo buscarPorCodigoPrestamo(@PathVariable(name = "codigoPrestamo") long codigoPrestamo) {
        return this.prestamoServicio.buscarPrestamoPorId(codigoPrestamo);
    }
    
    
}
