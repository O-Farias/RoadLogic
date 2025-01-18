# RoadLogic

RoadLogic é um sistema de gerenciamento de tráfego urbano que permite simular, monitorar e analisar diferentes elementos de uma cidade, como ruas, interseções e veículos. A aplicação foi construída utilizando **Spring Boot** e segue uma arquitetura modular para facilitar a manutenção e a escalabilidade.

## Funcionalidades

- **Gerenciamento de veículos:**
  - Adicionar, atualizar, visualizar e remover veículos.
  - Controlar características dos veículos, como velocidade, direção e status de emergência.

- **Gerenciamento de interseções:**
  - Criar, atualizar, visualizar e excluir interseções.
  - Acompanhar fluxos de tráfego e localização geográfica.

- **Gerenciamento de ruas:**
  - Adicionar, listar e configurar ruas.
  - Integrar ruas com interseções para simulações mais detalhadas.


## Tecnologias Utilizadas

- **Linguagem:** Java 17
- **Framework:** Spring Boot (v3.1.3)
- **Banco de Dados:** H2 Database (para desenvolvimento e testes)
- **Testes:** JUnit 5 e Mockito
- **Dependências Principais:**
  - Spring Web
  - Spring Data JPA
  - Lombok

## Estrutura do Projeto

```plaintext
src
├── main
│   ├── java
│   │   └── com
│   │       └── roadlogic
│   │           ├── controllers
│   │           │   ├── IntersectionController.java
│   │           │   ├── StreetController.java
│   │           │   └── VehicleController.java
│   │           ├── models
│   │           │   ├── Intersection.java
│   │           │   ├── Street.java
│   │           │   └── Vehicle.java
│   │           ├── repositories
│   │           │   ├── IntersectionRepository.java
│   │           │   ├── StreetRepository.java
│   │           │   └── VehicleRepository.java
│   │           └── services
│   │               ├── IntersectionService.java
│   │               ├── StreetService.java
│   │               └── VehicleService.java
│   └── resources
│       └── application.properties
└── test
    └── java
        └── com
            └── roadlogic
                ├── controllers
                │   ├── IntersectionControllerTest.java
                │   ├── StreetControllerTest.java
                │   └── VehicleControllerTest.java
                └── services
                    ├── IntersectionServiceTest.java
                    ├── StreetServiceTest.java
                    └── VehicleServiceTest.java
```

## Como Executar o Projeto

1. **Pré-requisitos:**
   - Java 17 ou superior instalado.
   - Maven configurado no ambiente.

2. **Clone o repositório:**
   ```bash
   git clone https://github.com/O-Farias/roadlogic.git
   cd roadlogic
   ```

3. **Execute o projeto:**
   ```bash
   mvn spring-boot:run
   ```

4. **Acesse a aplicação:**
   O servidor estará disponível em `http://localhost:8080`.

5. **Testes:**
   Para executar os testes unitários:
   ```bash
   mvn test
   ```

## Endpoints da API

### Veículos
- **GET** `/vehicles` - Lista todos os veículos.
- **POST** `/vehicles` - Adiciona um novo veículo.
- **GET** `/vehicles/{id}` - Retorna detalhes de um veículo específico.
- **PUT** `/vehicles/{id}` - Atualiza informações de um veículo.
- **DELETE** `/vehicles/{id}` - Remove um veículo.

### Interseções
- **GET** `/intersections` - Lista todas as interseções.
- **POST** `/intersections` - Cria uma nova interseção.
- **GET** `/intersections/{id}` - Retorna detalhes de uma interseção.
- **PUT** `/intersections/{id}` - Atualiza informações de uma interseção.
- **DELETE** `/intersections/{id}` - Remove uma interseção.

### Ruas
- **GET** `/streets` - Lista todas as ruas.
- **POST** `/streets` - Adiciona uma nova rua.

## Contribuindo

Contribuições são bem-vindas! Siga os passos abaixo para contribuir:

1. Faça um fork do repositório.
2. Crie uma branch para sua feature ou correção:
   ```bash
   git checkout -b minha-feature
   ```
3. Commit suas alterações:
   ```bash
   git commit -m "Adiciona minha nova feature"
   ```
4. Faça o push para sua branch:
   ```bash
   git push origin minha-feature
   ```
5. Abra um Pull Request no GitHub.

## Licença

Este projeto está licenciado sob a [MIT License](LICENSE).

---


