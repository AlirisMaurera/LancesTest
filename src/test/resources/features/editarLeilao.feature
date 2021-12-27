# language: pt

  Funcionalidade: Editar os dados de um leilao e ser salvos com sucesso e aparecer na tela principal


    Cenario: editar o nome e valor inicial de um leilao
      Dado usuario "fulano" com senha "pass" estar logado
      Quando ir para a pagina editar do leilao PC novo
      E preencher '<nomeLeilao>' e '<valorInicial>' e '<data>' do leilao
      Entao o leilao e salvo com sucesso
      E o leilao e mostrado na pagina de leilao com as mudancas

      Exemplos:
        | nomeLeilao | valorInicial | data|
        | PC VELHO   |    1000      |25/12/2021|