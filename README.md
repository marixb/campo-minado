# 🎮 Campo Minado

Campo Minado clássico, com efeitos sonoros, animações em pixel art.

Feito em Java com Spring Boot no backend e HTML/CSS/JavaScript puro no frontend.

## ✨ Funcionalidades

- Lógica completa de Campo Minado (revelar células, flood fill, marcar com bandeira, vitória/derrota)
- Primeiro PODE ser mina! chega de desonestidade!
- Efeitos sonoros sintetizados (clique, revelar, cascata, explosão)
- Animação de tremor no tabuleiro ao acertar uma mina
- Controle de zoom para ajustar o tamanho das células
- surpresa.

## 🛠️ Tecnologias

- Java 17
- Spring Boot 3.3
- Maven
- JUnit 5 (testes automatizados)
- HTML / CSS / JavaScript (Web Audio API para os sons)

## 🚀 Como rodar

Pré-requisitos: Java 17+ e Maven instalados.

```bash
git clone https://github.com/SEU-USUARIO/NOME-DO-REPO.git
cd NOME-DO-REPO
mvn spring-boot:run
Depois, abra no navegador: http://localhost:8080

## 🧪 Rodando os testes

mvn test
## 📁 Estrutura do projeto
rc/main/java/com/mariana/
├── model/
│ ├── Celula.java
│ ├── Tabuleiro.java
│ ├── Jogo.java
│ └── EstadoJogo.java
├── controller/
│ └── JogoController.java
├── dto/
│ ├── CelulaDTO.java
│ └── JogoDTO.java
└── App.java

src/main/resources/static/
├── index.html
├── images/
└── fonts/

## 🎯 Como jogar

**Clique esquerdo** numa célula: revela
**Clique direito**: marca/desmarca uma bandeira
Revele todas as células sem mina para vencer!
---

Feito por Mariana 
```