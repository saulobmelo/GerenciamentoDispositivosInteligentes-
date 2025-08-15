# Sistema Modular para Gerenciamento de Dispositivos Inteligentes — PT-BR (Java)

**Objetivo:** Middleware modular para cadastro e monitoramento de dispositivos inteligentes (sensores/atuadores), com eventos, execução de ações, aplicação de padrões **GOF** e princípios **SOLID**.

## Como compilar e executar (sem Maven)
1. **Requisito:** JDK 21+ instalado.
2. **Compilar (Windows PowerShell):**
   ```powershell
   cd src
   $files = Get-ChildItem -Recurse -Filter *.java | ForEach-Object { $_.FullName }
   javac -d . $files
   ```
   **Linux/macOS:**
   ```bash
   cd src
   find . -name "*.java" | xargs javac -d .
   ```
3. **Executar:**
   ```powershell
   java Principal
   ```

## Configurações (editar em `GerenciadorConfiguracao`)
- `ui.tema`: `escuro` | `claro`
- `log.formato`: `CSV` | `JSON` | `TEXTO`
- `evento.estrategia`: `IMEDIATA` | `ATRASADA` | `VALIDADA`
- `atraso.ms`: atraso em ms para estratégia ATRASADA
- `temp.limite`: limite de temperatura (°C) para acionar atuador

## Padrões de Projeto (GOF) Utilizados
- **Abstract Factory:** `iot.fabricas.*` — criação de famílias de objetos (`Sensor`, `Atuador`)
- **Singleton:** `iot.configuracao.GerenciadorConfiguracao` — gerenciador global de configuração
- **Observer:** `iot.eventos.BarramentoEventos` — com `MotorRegras` como assinante
- **Command:** `iot.comandos.*` — encapsulamento de ações sobre atuadores
- **Strategy:** `iot.estrategias.*` — políticas de reação a eventos
- **Composite + Decorator:** `iot.ui.*` e `iot.ui.decoradores.*` — UI e temas

## Princípios SOLID
- **SRP:** classes com responsabilidade única (ex.: `ServicoRegistro` apenas registra)
- **OCP:** fácil extensão de estratégias/atuadores/sensores/formatadores sem alterar classes existentes
- **LSP:** substituição segura de `Sensor`/`Atuador` por implementações concretas
- **ISP:** interfaces pequenas e específicas (`ComponenteUI`, `FormatadorLog`)
- **DIP:** dependências invertidas (ex.: `MotorRegras` depende de abstração de estratégia)

## Estrutura do Projeto
```
src/
  Principal.java
  iot/
    aplicacao/
      MotorRegras.java
    comandos/
      Comando.java
      ComandoLigar.java
      ComandoDefinirVelocidade.java
    configuracao/
      GerenciadorConfiguracao.java
    dispositivos/
      Dispositivo.java
      TipoDispositivo.java
      sensores/
        Sensor.java
        SensorTemperatura.java
      atuadores/
        Atuador.java
        Ventilador.java
    eventos/
      Evento.java
      BarramentoEventos.java
      Observador.java
      Sujeito.java
    fabricas/
      FabricaDispositivos.java
      FabricaPadrao.java
    registro/
      ServicoRegistro.java
      FormatadorLog.java
      FormatadorLogCSV.java
      FormatadorLogJSON.java
      FormatadorLogTexto.java
    estrategias/
      EstrategiaTratamentoEventos.java
      EstrategiaImediata.java
      EstrategiaAtrasada.java
      EstrategiaValidada.java
    ui/
      ComponenteUI.java
      Painel.java
      EtiquetaTexto.java
      decoradores/
        TemaDecorador.java
        TemaEscuro.java
        TemaClaro.java
```