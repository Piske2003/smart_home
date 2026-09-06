# Smart Home

Estrutura inicial do Trabalho 1 de Análise de Algoritmos. O projeto usará Java e Maven para implementar um controle universal de dispositivos IoT.

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

4. Execute os testes:

   ```shell
   mvn test
   ```

O Maven não conseguirá carregar o projeto enquanto o JAR do professor não estiver no caminho indicado.

## Estrutura

```text
src/
├── main/
│   ├── java/br/furb/analise/algoritmos/smarthome/
│   └── resources/
└── test/
    └── java/br/furb/analise/algoritmos/smarthome/
```

A implementação dos dispositivos universais, padrões de projeto e modos de automação será adicionada em uma próxima etapa.
