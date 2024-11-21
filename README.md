# API para reservade canoas individuais

Projeto criado para ser o backend do sistema de agendamento para uso de embarcações individuais.

# Docker
Já deixei o projeto dockerizado para quando for subir facilitar minha vida.

## Passo a passo
1. Gerar o .jar do projeto com o comando "./mvnw clean package"
2. Feito isso, é necessário atualizar a imagem do projeto com o comando "docker-compose build --no-cache"
3. Após, basta subir o projeto com o comando "docker-compose up --build"

Pronto, com isso o projeto estará rodando num container!
Obs.: é necessário ter Docker na máquina rsrs