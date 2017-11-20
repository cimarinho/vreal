Test 

1) Pré-requisito para execução

   	Apache-maven instalado e configurado.
   	Java versão 1.8 instalado e configurado.
   	Docker e docker-compose instalado (https://docs.docker.com/compose/install/)
   	Se for subir o projeto no Eclipse deve ser configurado o lombox.
   		a) Download do https://projectlombok.org/download.html.
   		b) Rodar o comando java -jar lombox.jar(nome do jar baixado).
   		c) Especificar a pasta do eclipse e clicar botão install / update.
   	Se for subir no Intelig, instalar o plugin na aba File/Settings 
   		a) Plugins.
   		b) lombox botão install.

2) Executar o projeto.

    	Dentro do diretório do projeto.
    	mvn clean install.
    	Considerando uma maquina linux.
    	Abrir  um terminal e dentro do diretório{home}/vreal/vreal-core executar sudo docker-compose up 
    	Apos subir vm, abrir outro terminal no mesmo diretório acima e executar  mvn spring-boot:run

3) Test Integrado.

	Após execução da etapa 2, entrar no diretório{home}/vreal/vreal-integration-test e executar o comando: mvn test -Dapp.host=http://{IP}

4) Test.
    Dentro do diretório{home}/vreal
	curl -XPOST http://${IP}:8080/properties -d @request.json --header 'Content-Type:application/json' -vvv
	curl http://${IP}:8080/properties/1
	curl http://${IP}:8080/properties\?ax\=600\&ay\=500\&bx\=1400\&by\=499
	
	Ou importar o arquivo vreal.postman_collection.json no Postman.