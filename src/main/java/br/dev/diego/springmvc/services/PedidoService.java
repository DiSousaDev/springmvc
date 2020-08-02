package br.dev.diego.springmvc.services;

import br.dev.diego.springmvc.domain.ItemPedido;
import br.dev.diego.springmvc.domain.PagamentoComBoleto;
import br.dev.diego.springmvc.domain.Pedido;

import br.dev.diego.springmvc.domain.Produto;
import br.dev.diego.springmvc.domain.enums.EstadoPagamento;
import br.dev.diego.springmvc.repositories.ClienteRepository;
import br.dev.diego.springmvc.repositories.ItemPedidoRepository;
import br.dev.diego.springmvc.repositories.PagamentoRepository;
import br.dev.diego.springmvc.repositories.PedidoRepository;
import br.dev.diego.springmvc.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repo;

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    @Autowired
    ClienteService clienteService;

    public Pedido find(Integer id){
        Optional<Pedido> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Produto.class.getName()));
    }

    public Pedido insert(Pedido obj){
        obj.setId(null);
        obj.setInstante(new Date());
        obj.setCliente(clienteService.find(obj.getCliente().getId()));
        obj.getPagamento().setEstado(EstadoPagamento.PENDENTE);
        obj.getPagamento().setPedido(obj);
        if(obj.getPagamento() instanceof PagamentoComBoleto){
            PagamentoComBoleto pagto = (PagamentoComBoleto) obj.getPagamento();
            BoletoService.preencherPagamentoComBoleto(pagto, obj.getInstante());

        }
        obj = repo.save(obj);
        pagamentoRepository.save(obj.getPagamento());
        for (ItemPedido ip : obj.getItens()) {
            ip.setDesconto(0.0);
            ip.setProduto(produtoService.find(ip.getProduto().getId()));
            ip.setPreco(ip.getProduto().getPreco());
            ip.setPedido(obj);
        }
        itemPedidoRepository.saveAll(obj.getItens());
        System.out.println(obj);
        return obj;
    }
}
