# language: pt

  Funcionalidade: Usuario dar lance a outro usuario

    Contexto:
      Dado usuario "fulano" de senha "pass" estar logado


    Cenario: usuario dar um lance valido
      Quando ir para a pagina de lances
      E dar um lance '<valorLance>'
      Entao o lance e aceito
      E adicionado na tela os dados do leilao

      Exemplos:
      |valorLance|
      |700       |


    Cenario: usuario dar um segundo lance de maneira consecutiva
      Quando ir para a pagina de lances
      E dar um lance '<valorLance>'
      Entao o lance nao e aceito

      Exemplos:
        |valorLance|
        |1000       |