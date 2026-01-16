# 📦 Sistema de Elevador — Java
## 📌 Sobre o projeto

Projeto desenvolvido em Java para simular o funcionamento de um elevador, aplicando conceitos de Programação Orientada a Objetos, separação de responsabilidades e boas práticas de organização de código.

### O sistema controla:

* Andar atual
* Capacidade máxima
* Entrada e saída de passageiros
* Subida e descida do elevador
* Regras de negócio por meio de exceções

### 🧠 Estrutura do projeto

O código foi organizado em pacotes, inspirando-se em uma arquitetura simples de aplicações back-end:
```
 domain     → regras de negócio
 service    → delegação e orquestração
 exception  → exceções customizadas
 ui         → interação com o usuário
```
### ⚙️ Regras de negócio

As validações ficam concentradas no domínio, garantindo que o elevador nunca fique em um estado inválido, como:

* Subir além do último andar
* Descer abaixo do térreo
* Exceder a capacidade máxima
* Permitir saída quando o elevador está vazio
* Quando uma regra é violada, o domínio lança uma exceção.

### ⚠️ Tratamento de exceções

As exceções são lançadas no domínio e tratadas de forma genérica na interface (```RuntimeException```), mantendo a ```UI``` desacoplada das regras internas do sistema.

Essa abordagem facilita manutenção e futuras mudanças na interface.

### 🖥️ Interface

A interface foi implementada com ```JOptionPane``` apenas para simular a interação com o sistema.
O foco do projeto está na lógica e organização, não na interface gráfica.

### 🛠️ Tecnologias e conceitos

* Java
* Programação Orientada a Objetos (POO)
* Exceções customizadas
* Organização em camadas
* Clean Code (princípios básicos)

### 📈 Aprendizados

* Separação clara entre interface, serviço e domínio
* Uso de exceções para representar falhas de regra de negócio
* Organização de código pensando em manutenção e evolução

### 👤 Autor

* Philipe Carvalho
* Estudante de Análise e Desenvolvimento de Sistemas