package iot.eventos;
public interface Sujeito {
    void assinar(Observador o);
    void cancelar(Observador o);
    void publicar(Evento e);
}
