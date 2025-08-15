package iot.registro;
import iot.eventos.Evento;

public class FormatadorLogTexto implements FormatadorLog {
    @Override public String formatar(Evento e, String info){
        return "[LOG] ts=" + e.getTimestamp() + " tipo=" + e.getTipo() + " origem=" + e.getOrigem().getNome() + " carga=" + e.getCarga() + " info=" + info;
    }
    @Override public String nome(){ return "TEXTO"; }
}
