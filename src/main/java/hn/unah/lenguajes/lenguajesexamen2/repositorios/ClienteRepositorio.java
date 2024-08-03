package hn.unah.lenguajes.lenguajesexamen2.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hn.unah.lenguajes.lenguajesexamen2.modelos.Cliente;

@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, String>
{
    
}
