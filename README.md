# App Auditoria

Aplicação demonstrativa: Spring Boot com Hibernate Envers - Auditoria

## Pré-requisitos

1 - JDK na versão 11 
```bash
javac --version
```

2 - Maven configurado 
```bash
mvn -v
```

3 - Instalar o [GIT](https://git-scm.com/downloads)
- Para verificar instalação, execute na linha de comando:
```bash
git --version
```

## Passo a passo

4 - Clone seu novo projeto para sua máquina
* a) Na pasta que servirá de worskpace, execute na linha de comando:
```bash
git clone https://github.com/DanSilva41/app-auditoria.git 
```
* c) Entre na pasta criada e execute na linha de comando para instalar as dependências e compilar o código:
```bash
mvn clean install -DskipTests
```

* d) execute o método **main** da classe **AppSpringHibernateEnversApplication** para compilar e subir a aplicação em http://localhost:8181
