# language: pt

  Funcionalidade: Logando um usuario

    Contexto:
      Dado um usuario estar na pagina de login


    Cenario: logando um usuario valido
      Quando preencher o nome '<Nome>' e senha '<Senha>'
      Entao usuario e logado

      Exemplos:
        |  Nome  | Senha |
        | fulano |  pass |
        |beltrano|  pass |

    Cenario: logando um usuario invalido
      Quando preencher o nome '<Nome>' e senha '<Senha>'
      Entao usuario não deveria logar


      Exemplos:
        |  Nome     | Senha |
        | perencejo |  1234 |
