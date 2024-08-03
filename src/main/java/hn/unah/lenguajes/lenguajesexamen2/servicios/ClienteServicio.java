package hn.unah.lenguajes.lenguajesexamen2.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.lenguajes.lenguajesexamen2.modelos.Cliente;
import hn.unah.lenguajes.lenguajesexamen2.modelos.Prestamo;
import hn.unah.lenguajes.lenguajesexamen2.repositorios.ClienteRepositorio;
import hn.unah.lenguajes.lenguajesexamen2.repositorios.CuotaRepositorio;

@Service
public class ClienteServicio 
{
    @Autowired
    private ClienteRepositorio clienteRepositorio;

    @Autowired
    private CuotaServicio cuotaServicio;

    @Autowired
    private CuotaRepositorio cuotaRepositorio;

    public List<Cliente> obtenerTodos()
    {
        return this.clienteRepositorio.findAll();
    }

    public Cliente crearCliente(Cliente nuevoCliente)
    {
        if(this.clienteRepositorio.existsById(nuevoCliente.getDni()))
        {
            return null;
        }
        if(nuevoCliente.getPrestamos() == null)
        {
            return this.clienteRepositorio.save(nuevoCliente);
        }

        for (Prestamo prestamo : nuevoCliente.getPrestamos()) 
        {
            //Valor fijo de interes
            //prestamo.setInteres(0.09);

            prestamo.setCuota(PrestamoServicio.calcularCuota(prestamo));

            prestamo.setCliente(nuevoCliente);

            this.cuotaServicio.generarRegistroCuota(prestamo);
            
        }

        return this.clienteRepositorio.save(nuevoCliente);

        
    }
}
