package br.com.alirismaurera.leilao.steps;

import br.com.alirismaurera.leilao.base.Base;
import br.com.alirismaurera.leilao.page.EditarLeilaoPage;
import br.com.alirismaurera.leilao.page.HomePage;
import br.com.alirismaurera.leilao.page.LeilaoPage;
import br.com.alirismaurera.leilao.page.LoginPage;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;

public class EditarLeilaoSteps {

    private HomePage homePage;
    private LoginPage loginPage;
    private LeilaoPage leiloesPage;
    private EditarLeilaoPage editarLeilao;
    private String nomeU, nomeL, valorI, dataL;


    @Dado("usuario {string} com senha {string} estar logado")
    public void usuario_com_senha_estar_logado(String nomeUsuario, String senha) {
        nomeU = nomeUsuario;
        homePage = new HomePage(Base.obterDriver());
        loginPage = homePage.irParaPaginaLogar();
        leiloesPage = loginPage.prencherFormulario(nomeUsuario, senha);
    }
    @Quando("ir para a pagina editar do leilao PC novo")
    public void ir_para_a_pagina_editar_do_leilao_pc_novo() {
        editarLeilao = leiloesPage.irParaEditarLeilao();

    }
    @Quando("preencher {string} e {string} e {string} do leilao")
    public void preencher_e_do_leilao(String nomeLeilao,String valorInicial ,String data ) {
        nomeL = nomeLeilao;
        valorI = valorInicial;
        dataL = data;
        leiloesPage = editarLeilao.atualizarFormulario(nomeLeilao,valorInicial, data);

    }
    @Entao("o leilao e salvo com sucesso")
    public void o_leilao_e_salvo_com_sucesso() {
        Assert.assertTrue(leiloesPage.obterPage().equalsIgnoreCase("http://localhost:8080/leiloes"));
        Assert.assertTrue(leiloesPage.obterCodigoFonte().contains("Leilão salvo com sucesso"));
    }
    @Entao("o leilao e mostrado na pagina de leilao com as mudancas")
    public void o_leilao_e_mostrado_na_pagina_de_leilao_com_as_mudancas() {
        Assert.assertTrue(leiloesPage.estaPresenteOLeilao(nomeL, valorI,dataL,nomeU));
    }
}
