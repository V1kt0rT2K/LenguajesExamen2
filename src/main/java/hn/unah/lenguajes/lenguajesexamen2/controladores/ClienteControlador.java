package hn.unah.lenguajes.lenguajesexamen2.controladores;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.unah.lenguajes.lenguajesexamen2.modelos.Cliente;
import hn.unah.lenguajes.lenguajesexamen2.servicios.ClienteServicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/api/cliente")
public class ClienteControlador 
{
    @Autowired
    private ClienteServicio clienteServicio;


    @GetMapping("/obtener/todos")
    public List<Cliente> obtenerTodos() 
    {
        return this.clienteServicio.obtenerTodos();
    }
    

    @PostMapping("/crear")
    public Cliente crearCliente(@RequestBody Cliente nuevoCliente) 
    {
        
        return this.clienteServicio.crearCliente(nuevoCliente);
    }
    
}
