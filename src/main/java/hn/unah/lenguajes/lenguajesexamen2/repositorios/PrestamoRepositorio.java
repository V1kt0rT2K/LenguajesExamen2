package hn.unah.lenguajes.lenguajesexamen2.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hn.unah.lenguajes.lenguajesexamen2.modelos.Prestamo;
import hn.unah.lenguajes.lenguajesexamen2.modelos.Cliente;


public interface PrestamoRepositorio extends JpaRepository<Prestamo, Long>
{
    public long countByCliente(Cliente cliente);

}
