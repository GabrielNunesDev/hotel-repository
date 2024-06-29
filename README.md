Hotel Reservation System

Bem-vindo ao sistema de reserva de hotéis! Este projeto é uma aplicação Spring Boot que permite aos usuários pesquisar, comparar e reservar quartos de hotel. A aplicação usa RabbitMQ para enviar mensagens e H2 Database para armazenamento em memória.

Antes de começar, você precisará das seguintes ferramentas instaladas em sua máquina:

Java 17 ou superior.
Apache Maven para gerenciar dependências e executar comandos.
RabbitMQ para mensageria (ou Docker para uma instalação rápida).
Clonando o Repositório
Clone o repositório usando Git:

bash
Copiar código
git clone https://github.com/GabrielNunesDev/hotel-repository.git
cd hotel-reservation


Configuração do Ambiente
1. Inicie o RabbitMQ
   Certifique-se de que o RabbitMQ está em execução. Você pode iniciar o RabbitMQ usando Docker com o seguinte comando:

bash
Copiar código
docker run -d --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:management
Isso iniciará o RabbitMQ e você poderá acessar o console de gerenciamento em http://localhost:15672 com o usuário e senha padrão guest/guest.

2. Configure o Maven
   Certifique-se de que o Maven está configurado corretamente e você está no diretório do projeto.

Executando a Aplicação
Para executar a aplicação, use o comando Maven a seguir:

bash
Copiar código
./mvnw spring-boot:run
Isso iniciará a aplicação Spring Boot, e você poderá acessar a API na URL http://localhost:8080.

Executando os Testes
Para executar todos os testes, incluindo os testes unitários e de integração, use o comando Maven:

bash
Copiar código
./mvnw test
Para executar apenas os testes de integração, use o comando:

bash
Copiar código
./mvnw verify
Resultados dos Testes
Após a execução dos testes, você encontrará os resultados em target/surefire-reports para testes unitários e target/failsafe-reports para testes de integração.

Testando a API
Você pode testar a API usando ferramentas como curl ou Postman. Aqui estão alguns exemplos de como fazer isso:

1. Criar um Novo Hotel
   bash
   Copiar código
   curl -X POST http://localhost:8080/hotels -H "Content-Type: application/json" -d '{"name":"Hotel Test","address":"123 Test St","availableRooms":5}'
2. Listar Todos os Hotéis
   bash
   Copiar código
   curl -X GET http://localhost:8080/hotels
3. Criar uma Nova Reserva
   bash
   Copiar código
   curl -X POST http://localhost:8080/reservations -H "Content-Type: application/json" -d '{"hotelId":1,"user":"Test User","checkInDate":"2024-06-01","checkOutDate":"2024-06-05"}'
4. Listar Reservas por Hotel
   bash
   Copiar código
   curl -X GET http://localhost:8080/reservations/hotel/1
   Acessando o Console H2
   Acesse o console H2 em http://localhost:8080/h2-console com as seguintes configurações:

JDBC URL: jdbc:h2:mem:hotel_reservation
Username: sa
Password: 
Acessando o Console RabbitMQ
Acesse o console RabbitMQ em http://localhost:15672 com as seguintes credenciais:

Username: guest
Password: guest
Fila de Mensagens
Você encontrará a fila chamada reservationQueue no console RabbitMQ.