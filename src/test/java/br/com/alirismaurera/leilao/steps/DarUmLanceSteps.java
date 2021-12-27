package br.com.alirismaurera.leilao.steps;

import br.com.alirismaurera.leilao.base.Base;
import br.com.alirismaurera.leilao.page.HomePage;
import br.com.alirismaurera.leilao.page.LancesPage;
import br.com.alirismaurera.leilao.page.LeilaoPage;
import br.com.alirismaurera.leilao.page.LoginPage;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;

public class DarUmLanceSteps {

    private String nomeU;
    private HomePage homePage;
    private LoginPage loginPage;
    private LeilaoPage leiloesPage;
    private LancesPage lance;
    private String valorLance;

    @Dado("usuario {string} de senha {string} estar logado")
    public void usuario_de_senha_estar_logado(String nomeUsuario, String senha) {
        nomeU = nomeUsuario;
        homePage = new HomePage(Base.obterDriver());
        loginPage = homePage.irParaPaginaLogar();
        leiloesPage = loginPage.prencherFormulario(nomeUsuario, senha);
    }

    @Quando("ir para a pagina de lances")
    public void ir_para_a_pagina_de_lances() {
        lance = leiloesPage.irParaLance();

    }

    @Quando("dar um lance {string}")
    public void dar_um_lance(String valor) {
        valorLance = valor;
        lance.darUmLance(valor);
    }

    @Entao("o lance e aceito")
    public void o_lance_e_aceito() {
        Assert.assertTrue(lance.obterPaginaFonte().contains("Lance adicionado com sucesso!"));
    }

    @Entao("adicionado na tela os dados do leilao")
    public void adicionado_na_tela_dos_dados_do_leilao() {
        Assert.assertTrue(lance.obterPaginaFonte().contains(nomeU));
        Assert.assertTrue(lance.obterPaginaFonte().contains(valorLance));
    }

    //dar um segundo lance
    @Entao("o lance nao e aceito")
    public void o_lance_nao_e_aceito() {
        Assert.assertTrue(lance.obterPaginaFonte().contains("Lance invalido!"));
    }


}
