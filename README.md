# Smart Home

Trabalho de Análise de Algoritmos que implementa um controle universal para lâmpadas, persianas e aparelhos de ar-condicionado de diferentes fabricantes.

O projeto utiliza o padrão **Adapter** para uniformizar as APIs dos dispositivos e uma **Facade**, representada por `CasaInteligente`, para oferecer controles individuais e modos de automação.

## Pré-requisitos

- JDK 17
- Maven 3.9 ou superior
- `LibDispositivosIot-1.0.jar`, disponibilizado pelo professor no AVA

## Preparação

1. Baixe a biblioteca fornecida no AVA.
2. Coloque o arquivo, sem alterar o nome, em:

   ```text
   src/main/resources/LibDispositivosIot-1.0.jar
   ```

3. Confira a instalação:

   ```shell
   java -version
   mvn -version
   ```

4. Compile e execute os testes:

   ```shell
   mvn clean test
   ```

O Maven não conseguirá carregar o projeto enquanto o JAR do professor não estiver no caminho indicado.

## Executando a demonstração

Depois de compilar o projeto, execute:

```powershell
java -cp "target\classes;src\main\resources\LibDispositivosIot-1.0.jar" br.furb.analise.algoritmos.smarthome.Main
```

A demonstração monta duas casas com fabricantes diferentes e executa controles individuais, modo Trabalho e modo Sono.

## Estrutura

```text
src/
├── main/
│   ├── java/br/furb/analise/algoritmos/smarthome/
│   │   ├── Interfaces/
│   │   └── adapters/
│   └── resources/
└── test/
    └── java/br/furb/analise/algoritmos/smarthome/
```

## Funcionalidades

- Controle universal de lâmpadas, persianas e aparelhos de ar-condicionado.
- Adapters para os seis dispositivos fornecidos na biblioteca.
- Modo Trabalho: liga a iluminação e o ar-condicionado, define 25°C e abre a persiana.
- Modo Sono: desliga a iluminação e o ar-condicionado e fecha a persiana.
- Testes unitários dos adapters e dos modos da casa inteligente.
