package br.dev.diego.springmvc.domain;

import br.dev.diego.springmvc.domain.enums.EstadoPagamento;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
public class PagamentoComBoleto extends Pagamento {
    private static final long serialVersionUID = 1L;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataVencimento;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataPagamento;

    public PagamentoComBoleto(){
    }

    public PagamentoComBoleto(Integer id, EstadoPagamento estado, Pedido pedido, Date dataVencimento, Date dataPagamento){
        super(id, estado, pedido);
        this.dataVencimento = dataVencimento;
        this.dataPagamento = dataPagamento;
    }

    public Date getDataVencimento(){
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento){
        this.dataVencimento = dataVencimento;
    }

    public Date getDataPagamento(){
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento){
        this.dataPagamento = dataPagamento;
    }
}
