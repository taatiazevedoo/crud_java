# Crud de produto

Projeto: Maven </br>
Linguagem: Java </br>
Spring Boot: 3.2.4 </br>
Java: 17 </br>
Banco: Postgres </br>
Lib: Lombok

Dependências
- Spring boot dev tools
- Spring web
- Lombok
- Sprint Data JPA
- PostgresSQL Driver

API Endpoints

POST /produto </br>
GET /produto </br>
GET /produto/getProdutoByCodigo?codigo={codigo} </br>
PUT /produto/{id} </br>
DELETE /produto/{id}

BODY </br>
{ </br>
"descricao": "Caderno", </br>
"codigo": "001", </br>
"grupoProduto": { </br>
"id": 1 </br>
} </br>
"precoCusto": 2.50, </br>
"precoVenda": 5, </br>
"observacao": "" </br>
}