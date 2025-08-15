package iot.registro;
import iot.eventos.Evento;

public interface FormatadorLog {
    String formatar(Evento e, String info);
    String nome();
}
