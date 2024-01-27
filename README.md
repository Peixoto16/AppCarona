# APLICATIVO DE CARONA


## O QUE É A APLICAÇÃO :
   
    Esse sera um aplicativo de de carona, ira salvar todos os dados dos motorista ou passageiro e 
    ira mostra somente os dados necessarios de cada um dele atraves de dto de response e request.
    O motorista tera que mostra a rota e possiveis paradas que ele dara.

## FUNCIONALIDADES --> CADASTRO DAS PESSOAS

- Encontra um passageiro/motorista registrado por ID.
- Encontra a lista de motorista registrada no sistema.
- Registrar uma cliente no sistema seja ele motorista/passageiro.
- Atualizar #######
- Deletar

- Devera ter uma classe carro para cadastra e se vincular ao motorista
o ID sera a placa.

## FUNCIONALIDADES --> CADASTRO DAS ROTAS

- Encontra uma rota por ID.
- Dentro das rotas mostrara os motorista disponiveis para ela.

## VERSIONAMENTO:

Versão do Java: 17
Versão do Spring Boot: 3.2.1

## FERRAMENTAS:

Back end:
      - Java
      - Spring Data JPA
      - Maven

## Dependências:

     Data JPA - > Utilizando o JPA para fazer a ponte entre o banco de dados e a aplicação -> ORM

     Web -> É uma aplicação WEB, Utilizado para receber requisições, devolver uma resposta ...

     PostgreSQL -> Utilizado esse BANCO no ambiente de desenvolvimento e produção.

     LomBok -> Utilizado para evitar muitas linhas de código através de annotations.

     Spring validation -> Utilizado para validar campos.

## Bancos de Dados :

    MySQL - Usado em ambiente de desenvolvimento e produção.
---------------------------------------------------------------------------------------------------------------

## Assoçicação

- Um motorista so pode ter 1 carro e 1 carro so pode ter 1 motorista.
- Um motorista so pode ta em uma carrida mais uma corrida pode ter varios motorista.
- Um passageiro so pode esta em uma corrida mais uma corrida pode ter varios passageiros.
- Erro ai gerar o id do motorista

# Corridas:

- Crie uma entidade para representar corridas, com informações como local de partida, destino, preço estimado, status da corrida, etc.
- Associe corridas a motoristas e passageiros.

# Novas
- Criar um usuarioType com enum em motorista e passageiro e fazer as validaçoes em cima dele.
- Depois tera a classe transform, que ira decidir se podera ou nao criar a corrida (podera
  criar a corrida caso seja enum motorista)"
- Se for motorista podera criar corridas e add passageiros nela.
- Voce entra na corrida com um motorista pede altorização para adicionar para o motorista
  (mais no momento isso sera muito trabalho entao irei deixar adicionar altomatico, so de
  ja esta na corrida voce(passageiro) tem o poder de add alguem e entao ganhar cash back e
  desconto chamando alguem para viajar com voce).

----------------------------------------------------------------------------------------------
# RESOLVER AMANHA 26/01 -->
- Crias o controller, service e jpaRepositaory da classe corrida
- Resolver bug da coluna do usuario passageiro ser criado no usuario, por conta do mapeamento,
porque deve ser criada a coluna na classe Corrida.
- Vou ter que criar a classe usuario corrida mesmo e associar
* @Entity
  @Table(name = "TB_USUARIO_CORRIDA")
  public class UsuarioCorrida implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "usuario_id")
  private Usuario usuario;

  @ManyToOne
  @JoinColumn(name = "corrida_id")
  private Corrida corrida;

  }
