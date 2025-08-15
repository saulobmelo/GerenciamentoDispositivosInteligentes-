package iot.fabricas;
import iot.dispositivos.atuadores.Atuador;
import iot.dispositivos.atuadores.Ventilador;
import iot.dispositivos.sensores.Sensor;
import iot.dispositivos.sensores.SensorTemperatura;

public class FabricaPadrao implements FabricaDispositivos {
    @Override public Sensor criarSensorTemperatura(String id, String nome){ return new SensorTemperatura(id, nome); }
    @Override public Atuador criarVentilador(String id, String nome){ return new Ventilador(id, nome); }
}
