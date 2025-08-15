package iot.estrategias;
import iot.eventos.Evento;
import iot.comandos.Comando;
import java.util.List;
import java.util.ArrayList;
import iot.dispositivos.atuadores.Atuador;

public class EstrategiaImediata implements EstrategiaTratamentoEventos {
    private final Atuador ventilador;
    private final int limite;

    public EstrategiaImediata(Atuador ventilador, int limite){
        this.ventilador = ventilador; this.limite = limite;
    }

    @Override
    public List<Comando> tratar(Evento e){
        List<Comando> cmds = new ArrayList<>();
        if("temperatura".equals(e.getTipo()) && e.getCarga() instanceof Integer){
            int temp = (Integer) e.getCarga();
            if(temp > limite){
                cmds.add(new iot.comandos.ComandoLigar(ventilador));
                int velocidade = Math.min(5, Math.max(1, (temp - limite) / 2 + 1));
                cmds.add(new iot.comandos.ComandoDefinirVelocidade(ventilador, velocidade));
            }
        }
        return cmds;
    }
    @Override public String nome(){ return "Imediata"; }
}
