# 🎮 Campo Minado

Campo Minado clássico, com efeitos sonoros, animações em pixel art.

Feito em Java com Spring Boot no backend e HTML/CSS/JavaScript puro no frontend.

## ✨ Funcionalidades

- Lógica completa de Campo Minado (revelar células, flood fill, marcar com bandeira, vitória/derrota)
- Primeiro clique nunca é mina — chega de desonestidade! 😄
- Efeitos sonoros sintetizados (clique, revelar, cascata, explosão)
- Animação de tremor no tabuleiro ao acertar uma mina
- Controle de zoom para ajustar o tamanho das células
- surpresa 🤫

## 🛠️ Tecnologias

- Java 17
- Spring Boot 3.3
- Maven
- JUnit 5 (testes automatizados)
- HTML / CSS / JavaScript (Web Audio API para os sons)

## 🚀 Como rodar

Pré-requisitos: Java 17+ e Maven instalados.

```bash
git clone https://github.com/marixb/campo-minado.git
cd campo-minado
mvn spring-boot:run
```

Depois, abra no navegador: http://localhost:8080

## 🧪 Rodando os testes

```bash
mvn test
```

## 📁 Estrutura do projeto