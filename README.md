Test 

1) Pré-requisito para execução

   	Apache-maven instalado e configurado.
   	Java versão 1.8 instalado e configurado.
   	Docker e docker-compose instalado (https://docs.docker.com/compose/install/)
   	Se for subir o projeto no Eclipse deve ser configurado o lombox.<br>
   		a) Download do https://projectlombok.org/download.html. <br>
   		b) Rodar o comando java -jar lombox.jar (nome do jar baixado) . <br>
   		c) Especificar a pasta do eclipse e clicar botão install / update .<br>
   	Se for subir no Intelig, instalar o plugin na aba File/Settings <br>
   		a) Plugins.
   		b) lombox botão install.

2) Executar o projeto.

    	Dentro do diretório do projeto.
    	mvn clean install.
    	Considerando uma maquina linux.
    	Abrir  um terminal e dentro do diretório{home}/vreal/vreal-core executar sudo docker-compose up 
    	Apos subir vm, abrir outro terminal no mesmo diretório acima e executar  mvn spring-boot:run

3) Test Integrado.

	Após execução da etapa 2, entrar no diretório{home}/vreal/vreal-integration-test e executar o comando: mvn surefire:test -Dtest=*.java -Dapp.host=http://{IP}

4) Test.<br>
    a) Dentro do diretório{home}/vreal<br>
	curl -XPOST http://${IP}:8080/properties -d @request.json --header 'Content-Type:application/json' -vvv<br>
	curl http://${IP}:8080/properties/1<br>
	curl http://${IP}:8080/properties\?ax\=600\&ay\=500\&bx\=1400\&by\=499<br>
	
    b) Ou importar o arquivo vreal.postman_collection.json no Postman.
