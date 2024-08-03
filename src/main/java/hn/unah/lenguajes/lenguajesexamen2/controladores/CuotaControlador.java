package hn.unah.lenguajes.lenguajesexamen2.controladores;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.unah.lenguajes.lenguajesexamen2.servicios.CuotaServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/cuota")
public class CuotaControlador 
{

    @Autowired
    private CuotaServicio cuotaServicio;
/* 
    @PostMapping("/crear")
    public void crearCuotas()
    {
        this.cuotaServicio.generarRegistroCuota();
    }    
        */
}
