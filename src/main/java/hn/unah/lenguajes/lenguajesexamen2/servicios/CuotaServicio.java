package hn.unah.lenguajes.lenguajesexamen2.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.lenguajes.lenguajesexamen2.modelos.Cuota;
import hn.unah.lenguajes.lenguajesexamen2.modelos.Prestamo;
import hn.unah.lenguajes.lenguajesexamen2.repositorios.CuotaRepositorio;

@Service
public class CuotaServicio 
{
    @Autowired
    private CuotaRepositorio cuotaRepositorio;

    public void generarRegistroCuota(Prestamo prestamo)
    {
        Cuota cuotaInicial = new Cuota();
        cuotaInicial.setInteres(0);
        cuotaInicial.setCapital(0);
        cuotaInicial.setMes(0);
        cuotaInicial.setSaldo(prestamo.getMonto());
        cuotaInicial.setPrestamo(prestamo);

        Cuota cuotaAnterior = cuotaInicial;

        this.cuotaRepositorio.saveAndFlush(cuotaInicial);

        for(int i = 1; i <= (prestamo.getPlazo()*12); i++)
        {
            Cuota cuota = new Cuota();

            cuota.setMes(i);

            cuota.setInteres(cuotaAnterior.getSaldo() * prestamo.getInteres());

            //cuota.setCapital(prestamo.getCuota()- cuota.getInteres()); Valores negativos?
            cuota.setCapital(cuota.getInteres() - prestamo.getCuota());

            cuota.setSaldo(cuotaAnterior.getSaldo() - cuota.getCapital());

            cuota.setPrestamo(prestamo);

            this.cuotaRepositorio.save(cuota);

            cuotaAnterior = cuota;

        }        
    }
}
