# Test de uma pagina de lances

Pre-requisitos:

* java 11
* IDE Intellij

Ferramentas utilizadas:

* JUnit
* Cucumber
* Selenium



# Casos de testes



## <u>Testando login</u>

| Cenário | Tipo de teste | Cenário de  teste              | Resultado  esperado | status |
| ------- | ------------- | ------------------------------ | ------------------- | ------ |
| C1      | Positivo      | Logar com  "fulano", "pass"    | Deve logar          | OK     |
| C2      | Positivo      | Logar com  "beltrano", "pass"  | Deve logar          | OK     |
| C3      | Negativo      | Logar com  "perencejo", "1234" | Não deve logar      | OK     |



## <u>Testando cadastro de um novo leilão</u>

| Cenario | Tipo de teste | Cenario de  teste                                            | Resultado  esperado          | status |
| ------- | ------------- | ------------------------------------------------------------ | ---------------------------- | ------ |
| C1      | Positivo      | Cadastro  de leilao com dados validos  PC  novo  \| 1500     \| 23/12/2021 | Deve adicionar leilão        | OK     |
| C2      | Negativo      | Cadastro  de leilao com valor inicial <= 0    PC novo  \| 0     \| 23/12/2022     \| | Não  deve adicionar o leilão | OK     |
| C2      | Negativo      | Cadastro  de leilao com valor inicial <= 0      PC novo  \|  -5      \| 23/12/2021 \| | Não  deve adicionar o leilão | OK     |
| C3      | Negativo      | Cadastro  de leilao com um nome ate 2 carateres                                PC  \| 1500     \| 23/12/2023 | Não  deve adicionar o leilão | OK     |



## <u>Testando edição de um leilão</u>

| Cenário | Tipo de teste |                      Cenário de  teste                       | Resultado  esperado  | status |
| ------- | ------------- | :----------------------------------------------------------: | -------------------- | ------ |
| C1      | Positivo      | Editando  um leilão                                                        PC  VELHO  \| 1000     \| 25/12/2021 | Deve salvar o leilão | OK     |



## <u>Testando lances</u>

| Cenário | Tipo de teste | Cenário de  teste                                            | Resultado  esperado       | status |
| ------- | ------------- | ------------------------------------------------------------ | ------------------------- | ------ |
| C1      | Positivo      | Dar  um lance valido                                              valor do Lance : 700 | Deve aceitar o lance      | OK     |
| C2      | Negativo      | Dar  um segundo lance de maneira consecutiva                  valor do Lance  : 1000 | Não  deve aceitar o lance | OK     |