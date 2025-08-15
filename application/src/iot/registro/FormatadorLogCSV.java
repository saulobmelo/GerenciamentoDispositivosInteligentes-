package iot.registro;
import iot.eventos.Evento;

public class FormatadorLogCSV implements FormatadorLog {
    @Override public String formatar(Evento e, String info){
        return e.getTimestamp() + "," + e.getTipo() + "," + e.getOrigem().getNome() + "," + e.getCarga() + "," + info;
    }
    @Override public String nome(){ return "CSV"; }
}
