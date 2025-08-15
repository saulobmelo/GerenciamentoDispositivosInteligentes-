package iot.aplicacao;
import iot.eventos.Observador;
import iot.eventos.Evento;
import iot.comandos.Comando;
import iot.estrategias.EstrategiaTratamentoEventos;
import iot.registro.ServicoRegistro;

import java.util.List;

// Observer subscriber que transforma eventos em comandos via Strategy
public class MotorRegras implements Observador {
    private EstrategiaTratamentoEventos estrategia;
    private final ServicoRegistro logger;

    public MotorRegras(EstrategiaTratamentoEventos estrategia, ServicoRegistro logger){
        this.estrategia = estrategia;
        this.logger = logger;
    }

    public void setEstrategia(EstrategiaTratamentoEventos estrategia){
        this.estrategia = estrategia;
        System.out.println("[MotorRegras] Estratégia atual: " + estrategia.nome());
    }

    @Override
    public void aoEvento(Evento e){
        logger.registrar(e, "recebido");
        List<Comando> comandos = estrategia.tratar(e);
        for(Comando c: comandos){
            System.out.println("[Executar] " + c.nome());
            c.executar();
        }
    }
}
