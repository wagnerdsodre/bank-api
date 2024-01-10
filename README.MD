## 💻 Objetivo do projeto

Rest api para gestão de contas, agências, pessoa física, pessoa jurídica, rotinas bancária como:
Abertura, deleção lógica, transferência entre contas, depósito, saques;
- Outras funcionalidades e melhorias serão implementadas.
---

## ⚙️ Funcionalidades

- [x] Gestão Contas Pessoa Física e Pessoa Jurídica;
- [x] Saques;
- [ ] Transferências;
- [ ] Depósitos;
- [ ] Inativação;

- [x] Teste unitários (parcial);

---

## 📄 Documentação

### Cadastro e pesquisa da Pessoa Jurídica:
- Criar Pessoa Jurídica: http://localhost:8080/pessoa-juridica/criar-pessoa
```json
	{
		"id":1,
		"nome": "Jonh Doe",	
		"email":"jonhdoe@gmail.com",
		"endereco": {
			"cep": "09562658",
			"cidade": "Santo André",
			"complemento": "apto",
			"logradouro": "Aqui perto",
			"numero": 1256,		
			"uf": "SP"
			},
	"cnpj": "67125235623562"	OR "cpf":"12345678999"  
	}
```
- Pesquisar PJ por Id : http://localhost:8080/pessoa-juridica/1


### Pessoa Física:
- Criar Pessoa Física : http://localhost:8080/pessoa-fisica/criar-pessoa
- Pesquisar CPF por Id : http://localhost:8080/pessoa-fisica/1


### Contas:
- Obter Contas por id: http://localhost:8080/contas/1
- Realizar Saque por conta: http://localhost:8080/contas/saque/1
    POST /customer
```json
    {	
        "valor": "100.0"		
    }
```


A documentação sobre as funcionalidades da aplicação pode ser acessada neste link: <a href="#">Trello</a>

---

## 🛠 Tecnologias

As seguintes tecnologias foram utilizadas no desenvolvimento da API Rest do projeto:

- **[Java 17](https://www.oracle.com/java)**
- **[Spring Boot 3](https://spring.io/projects/spring-boot)**
- **[Maven](https://maven.apache.org)**
- **[MySQL](https://www.mysql.com)**
- **[Hibernate](https://hibernate.org)**
- **[Flyway](https://flywaydb.org)**
- **[Lombok](https://projectlombok.org)**
- **[JWT](https://jwt.io/)**
- **[Swagger](https://swagger.io/)**
- **[OpenAPI](https://www.openapis.org/)**
- **[Mockito](https://github.com/mockito/mockito)**
- **[H2 Database](com.h2database)**

---

## 👨‍🚀 Deploy
 - AWS 