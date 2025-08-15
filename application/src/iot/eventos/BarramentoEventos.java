package iot.eventos;
import java.util.List;
import java.util.ArrayList;

// Observer - barramento simples de eventos
public class BarramentoEventos implements Sujeito {
    private final List<Observador> observadores = new ArrayList<>();
    @Override public void assinar(Observador o){ observadores.add(o); }
    @Override public void cancelar(Observador o){ observadores.remove(o); }
    @Override public void publicar(Evento e){ for(Observador o: observadores) o.aoEvento(e); }
}
