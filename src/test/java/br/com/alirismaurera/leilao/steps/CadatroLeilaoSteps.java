package br.com.alirismaurera.leilao.steps;

import br.com.alirismaurera.leilao.base.Base;
import br.com.alirismaurera.leilao.page.HomePage;
import br.com.alirismaurera.leilao.page.LeilaoPage;
import br.com.alirismaurera.leilao.page.LoginPage;
import br.com.alirismaurera.leilao.page.NovoLeiloesPage;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;

public class CadatroLeilaoSteps {

    private HomePage homePage;
    private LoginPage loginPage;
    private LeilaoPage leiloesPage;
    private NovoLeiloesPage novosLeiloes;
    private String usuario, nome, valor, dataAbertura;

    //Cadastro com dados validos
    @Dado("usuario nome {string} e senha {string} estar logado")
    public void usuario_nome_e_senha_estar_logado(String nomeUsuario, String senha) {
        usuario = nomeUsuario;
        homePage = new HomePage(Base.obterDriver());
        loginPage = homePage.irParaPaginaLogar();
        leiloesPage = loginPage.prencherFormulario(nomeUsuario, senha);
    }

    @Quando("ir para a pagina de cadastro de leiloes")
    public void ir_para_a_pagina_de_cadastro_de_leiloes() {
        novosLeiloes = leiloesPage.irParaNovoLeiloes();

    }

    @Quando("preencher o nome {string}, valor inicial {string} e data de abertura {string} validos")
    public void preencher_o_nome_valor_inicial_e_data_de_abertura_validos(String nomeLeilao, String valorInicial, String data) {
        nome = nomeLeilao;
        valor = valorInicial;
        dataAbertura = data;
        leiloesPage = novosLeiloes.PreencherFormularioNovoLeilao(nomeLeilao, valorInicial, data);
    }

    @Entao("o leilao é adicionado")
    public void o_leilao_é_adicionado() {
        Assert.assertTrue(leiloesPage.obterPage().equalsIgnoreCase("http://localhost:8080/leiloes"));
        Assert.assertTrue(leiloesPage.obterCodigoFonte().contains("Leilão salvo com sucesso"));
    }

    @Entao("aparece na tela")
    public void aparece_na_tela() {
        Assert.assertTrue(leiloesPage.estaPresenteOLeilao(nome, valor, dataAbertura, usuario));
    }

    //Cadastro com dados invalidos

    @Quando("preencher o nome {string}, valor inicial {string} e data de abertura {string} invalidos")
    public void preencher_o_nome_valor_inicial_e_data_de_abertura_invalidos(String nomeLeilao, String valorInicial, String data) {
        nome = nomeLeilao;
        valor = valorInicial;
        dataAbertura = data;
        leiloesPage = novosLeiloes.PreencherFormularioNovoLeilao(nomeLeilao, valorInicial, data);
    }
    @Entao("o leilao não é adicionado")
    public void o_leilao_não_é_adicionado() {
        Assert.assertTrue(leiloesPage.obterPage().equalsIgnoreCase(novosLeiloes.obterUrlDaPagina()));

    }
    @Entao("aparece na mesma tela do formulario uma menssagem de erro")
    public void aparece_na_mesma_tela_do_formulario_uma_menssagem_de_erro() {
        Assert.assertTrue(leiloesPage.obterCodigoFonte().contains("deve ser um valor maior de 0.1"));
    }

    //Cadastro de leilao com um nome nao expressivo
    @Quando("preencher o nome {string} invalido e valor inicial {string} e data de abertura {string} validos")
    public void preencher_o_nome_invalido_e_valor_inicial_e_data_de_abertura_validos(String nomeLeilao, String valorInicial, String data) {
        nome = nomeLeilao;
        valor = valorInicial;
        dataAbertura = data;
        leiloesPage = novosLeiloes.PreencherFormularioNovoLeilao(nomeLeilao, valorInicial, data);
    }
    @Entao("aparece na mesma tela do formulario uma menssagem de erro no nome")
    public void aparece_na_mesma_tela_do_formulario_uma_menssagem_de_erro_no_nome() {
        Assert.assertTrue(leiloesPage.obterCodigoFonte().contains("minimo 3 caracteres"));
    }
}
