package hn.unah.lenguajes.lenguajesexamen2.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.lenguajes.lenguajesexamen2.modelos.Prestamo;
import hn.unah.lenguajes.lenguajesexamen2.repositorios.ClienteRepositorio;
import hn.unah.lenguajes.lenguajesexamen2.repositorios.PrestamoRepositorio;

@Service
public class PrestamoServicio 
{

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    @Autowired
    private PrestamoRepositorio prestamoRepositorio;

    @Autowired
    private CuotaServicio cuotaServicio;

    //Metodo para calcular la couta
    public static double calcularCuota(Prestamo prestamo)
    {
        double numerador = prestamo.getMonto() *(prestamo.getInteres() / 12) * Math.pow(1 + (prestamo.getInteres() / 12) , prestamo.getPlazo()*12);

        double denominador = (1 - Math.pow((1 + (prestamo.getInteres() / 12)), prestamo.getPlazo() * 12)) - 1;

        return numerador/denominador *(-1);
    }

    public Prestamo buscarPrestamoPorId(long codigoPrestamo)
    {
        if(this.prestamoRepositorio.existsById(codigoPrestamo))
        {
            return this.prestamoRepositorio.findById(codigoPrestamo).get();
        }

        return null;
        
    }


    public Prestamo crearPrestamo(String dni, Prestamo prestamo)
    {
        if(this.clienteRepositorio.existsById(dni))
        {
            if(this.prestamoRepositorio.countByCliente(this.clienteRepositorio.findById(dni).get()) <= 2)
            {

                prestamo.setCliente(this.clienteRepositorio.findById(dni).get());
                prestamo.setCuota(PrestamoServicio.calcularCuota(prestamo));

                this.cuotaServicio.generarRegistroCuota(prestamo);

                return this.prestamoRepositorio.save(prestamo);
            }
        }

        return null;
    }
}
