package iot.dispositivos.atuadores;
import iot.dispositivos.Dispositivo;

public interface Atuador extends Dispositivo {
    void executar(String acao, Object parametro);
    String[] acoesSuportadas();
}
