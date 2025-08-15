package iot.estrategias;
import iot.eventos.Evento;
import iot.comandos.Comando;
import java.util.List;

public interface EstrategiaTratamentoEventos {
    // Dado um evento, retorna comandos a executar (pode ser vazio)
    List<Comando> tratar(Evento e);
    String nome();
}
