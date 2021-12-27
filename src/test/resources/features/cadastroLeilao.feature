# language: pt


Funcionalidade: Cadastrar novo leilao

  Contexto:
    Dado usuario nome "fulano" e senha "pass" estar logado



  Cenario: cadastro de leilao com dados validos
    Quando ir para a pagina de cadastro de leiloes
    E preencher o nome '<nomeLeilao>', valor inicial '<valorInicial>' e data de abertura '<data>' validos
    Entao o leilao é adicionado
    E aparece na tela

   Exemplos:
      |nomeLeilao | valorInicial | data       |
      |PC novo    | 1500         | 23/12/2021 |



  Cenario: Cadastrar novo leilao com valor inicial menor ou igual a 0
    Quando ir para a pagina de cadastro de leiloes
    E preencher o nome '<nomeLeilao>', valor inicial '<valorInicial>' e data de abertura '<data>' invalidos
    Entao o leilao não é adicionado
    E aparece na mesma tela do formulario uma menssagem de erro

    Exemplos:
     |  nomeLeilao | valorInicial | data       |
     | PC novo    |    0         | 23/12/2021 |
     | PC novo    |   -5         | 23/12/2021 |


  Cenario: Cadastrar novo leilao com um nome ate 2 carateres
    Quando ir para a pagina de cadastro de leiloes
    E preencher o nome '<nomeLeilao>' invalido e valor inicial '<valorInicial>' e data de abertura '<data>' validos
    Entao o leilao não é adicionado
    E aparece na mesma tela do formulario uma menssagem de erro no nome

    Exemplos:
      |  nomeLeilao | valorInicial | data       |
      | PC    |    100         | 23/12/2021 |
