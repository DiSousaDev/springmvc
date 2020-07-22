package br.dev.diego.springmvc.services;

import br.dev.diego.springmvc.domain.Categoria;
import br.dev.diego.springmvc.domain.Cliente;
import br.dev.diego.springmvc.repositories.ClienteRepository;
import br.dev.diego.springmvc.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repo;

    public Cliente find(Integer id){
        Optional<Cliente> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
    }

}
