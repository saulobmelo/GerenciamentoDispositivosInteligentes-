package iot.registro;
import iot.eventos.Evento;

public class FormatadorLogJSON implements FormatadorLog {
    @Override public String formatar(Evento e, String info){
        return String.format("{\"ts\":%d,\"tipo\":\"%s\",\"origem\":\"%s\",\"carga\":\"%s\",\"info\":\"%s\"}",
            e.getTimestamp(), e.getTipo(), e.getOrigem().getNome(), String.valueOf(e.getCarga()), info);
    }
    @Override public String nome(){ return "JSON"; }
}
