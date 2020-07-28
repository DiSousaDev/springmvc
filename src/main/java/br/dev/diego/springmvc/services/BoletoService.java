package br.dev.diego.springmvc.services;

import br.dev.diego.springmvc.domain.PagamentoComBoleto;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

@Service
public class BoletoService {


    public static void preencherPagamentoComBoleto(PagamentoComBoleto pagto, Date instanteDoPedido){

        Calendar cal = Calendar.getInstance();
        cal.setTime(instanteDoPedido);
        cal.add(Calendar.DAY_OF_MONTH, 7);
        pagto.setDataVencimento(cal.getTime());

    }
}
