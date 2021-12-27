package br.com.alirismaurera.leilao.steps;

import br.com.alirismaurera.leilao.base.Base;
import br.com.alirismaurera.leilao.page.HomePage;
import br.com.alirismaurera.leilao.page.LeilaoPage;
import br.com.alirismaurera.leilao.page.LoginPage;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;


public class LoginSteps {

    private LoginPage login;
    private HomePage homePage;
    private LeilaoPage leilaoPage;
    private String nomeUsuario;

    //Usuario valido
    @Dado("um usuario estar na pagina de login")
    public void um_usuario_estar_na_pagina_de_login() {
        homePage = new HomePage(Base.obterDriver());
        login = homePage.irParaPaginaLogar();
    }

    @Quando("preencher o nome {string} e senha {string}")
    public void preencher_e_senha(String nome, String senha) {
        nomeUsuario = nome;
        leilaoPage = login.prencherFormulario(nome, senha);
    }

    @Entao("usuario e logado")
    public void usuario_e_logado() {
        Assert.assertEquals(nomeUsuario, leilaoPage.obterNomeUsuario());
    }

    //Usuario Invalido
    @Entao("usuario não deveria logar")
    public void usuario_não_deveria_logar() {
        Assert.assertFalse(leilaoPage.obterPage().equalsIgnoreCase("http://localhost:8080/leiloes"));
        Assert.assertTrue(leilaoPage.obterCodigoFonte().contains("Usuário e senha inválidos."));
    }
}
