package hn.unah.lenguajes.lenguajesexamen2.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import hn.unah.lenguajes.lenguajesexamen2.modelos.Cuota;
import hn.unah.lenguajes.lenguajesexamen2.modelos.Prestamo;

public interface CuotaRepositorio extends JpaRepository<Cuota, Long>
{
    public Cuota findByMesAndPrestamo(long mes, Prestamo prestamo);

}
