# Sistema de Cadastro de Usuários

Aplicação desktop desenvolvida em Java Swing com integração ao MySQL, utilizando o padrão arquitetural MVC.

## Funcionalidades

- Login de usuários.
- Cadastro de novos acessos.
- Autenticação pelo MySQL.
- Cadastro de nomes.
- Listagem dos usuários cadastrados.
- Persistência dos dados no banco de dados.

## Tecnologias utilizadas

- Java JDK 21
- Java Swing
- MySQL Server
- MySQL Connector/J
- JDBC
- Visual Studio Code

## Estrutura do projeto

```text
src/
└── br/com/sistema/
    ├── Main.java
    ├── controller/
    ├── model/
    └── view/
```

## Banco de dados

Execute o arquivo `database.sql` no MySQL Workbench para criar o banco e as tabelas.

O sistema utiliza o banco `db_sistema`, com as tabelas:

- autenticacao
- usuarios

## Configuração da conexão

Configure as variáveis de ambiente antes de executar a aplicação:

- DB_USER: usuário do MySQL.
- DB_PASSWORD: senha do usuário MySQL.

## Compilação

No PowerShell, execute:

```powershell
$fontes = Get-ChildItem .\src -Recurse -Filter *.java |
    ForEach-Object { $_.FullName }

New-Item -ItemType Directory -Force .\out | Out-Null

javac -encoding UTF-8 -cp ".\lib\mysql-connector-j-26.10.0.jar" -d .\out $fontes
```

## Execução

```powershell
java -cp ".\out;.\lib\mysql-connector-j-26.10.0.jar" br.com.sistema.Main
```