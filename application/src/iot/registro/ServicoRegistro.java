package iot.registro;
import iot.eventos.Evento;

// SRP: responsabilidade única de registro
// DIP: depende de abstração FormatadorLog
public class ServicoRegistro {
    private FormatadorLog formatador;
    public ServicoRegistro(FormatadorLog formatador){ this.formatador = formatador; }
    public void setFormatador(FormatadorLog formatador){ this.formatador = formatador; }
    public void registrar(Evento e, String info){
        System.out.println(formatador.formatar(e, info));
    }
}
