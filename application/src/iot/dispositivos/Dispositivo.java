package iot.dispositivos;

// SRP (Single Responsibility Principle): cada implementação terá uma responsabilidade clara
public interface Dispositivo {
    String getId();
    String getNome();
    TipoDispositivo getTipo();
}
