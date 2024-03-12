# API-RESTful-Produtos
Uma API simples para produtos de um mercadinho.

## 🛠 Ferramentas utilizadas para codificar, compilar e executar o projeto:
![Static Badge](https://img.shields.io/badge/JDK-17-orange)
![Static Badge](https://img.shields.io/badge/ApacheMaven-3.9.6-orange)
![Static Badge](https://img.shields.io/badge/SpringBoot-3.2.3-green)
![Static Badge](https://img.shields.io/badge/STS-4.20-darkgreen)

## 🛠 Ferramentas para criar e hospedar a base de dados:
![Static Badge](https://img.shields.io/badge/Postgresql-16-blue)

## 📚 Bibliotecas utilizadas para desenvolvimento:
![Static Badge](https://img.shields.io/badge/org.postgresql-blue)
![Static Badge](https://img.shields.io/badge/org.hibernate.javax.persistence-1.0.2.Final-darkblue)
![Static Badge](https://img.shields.io/badge/jakarta.persistence-brown)
![Static Badge](https://img.shields.io/badge/org.modelmapper-2.3.8-black)

# EndPoints do projeto localmente:
### Obter Todos os produtos
{GET}http://localhost:8080/api/produtos

### Obter produto por id 
{GET}http://localhost:8080/api/produtos/{id}

### Adicionar produto
{POST}http://localhost:8080/api/produtos
##### Body:
###### {
######    "nome":String,
######    "quantidade": Integer,
######    "valor" : Double,
######    "observacao" : String
###### }

### Atualizando produto
{PUT}http://localhost:8080/api/produtos/{id}
##### Body:
###### {
######    "nome":String,
######    "quantidade": Integer,
######    "valor" : Double,
######    "observacao" : String
###### }

### Deletar Produto
{DELETE}http://localhost:8080/api/produtos/{id}