package br.dev.diego.springmvc.services;

import br.dev.diego.springmvc.domain.Pedido;

import br.dev.diego.springmvc.domain.Produto;
import br.dev.diego.springmvc.repositories.PedidoRepository;
import br.dev.diego.springmvc.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repo;

    public Pedido find(Integer id){
        Optional<Pedido> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Produto.class.getName()));
    }

}
