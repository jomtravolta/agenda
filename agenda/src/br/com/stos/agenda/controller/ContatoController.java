package br.com.stos.agenda.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.ifpe.psyChomics.dao.CategoriaProdutoDao;
import br.com.ifpe.psyChomics.dao.GeneroProdutoDao;
import br.com.ifpe.psyChomics.dao.ProdutoDao;
import br.com.ifpe.psyChomics.dao.TipoProdutoDao;
import br.com.ifpe.psyChomics.model.CategoriaProduto;
import br.com.ifpe.psyChomics.model.GeneroProduto;
import br.com.ifpe.psyChomics.model.Produto;
import br.com.ifpe.psyChomics.model.TipoProduto;
import br.com.stos.agenda.HibernateDao.ContatoHibernateDao;
import br.com.stos.agenda.model.Contato;


@Controller
public class ContatoController {
	
	@RequestMapping("/exibirSalvarContato")
	public String exibirSalvarContato() {

		return "contato/salvarContato";
	}
	
	@RequestMapping("salvarContato")
	public String salvarContato(Contato contato, Model model) {
		ContatoHibernateDao dao = new ContatoHibernateDao();
		dao.salvar(contato);
		model.addAttribute("msg", "Contato Cadastrado com Sucesso!");
		return "contato/salvarContato";
	}
	
	
	@RequestMapping("/exibirAlterarContato")
	public String exibirAlterarContato(Contato contato, Model model) {

		ContatoHibernateDao dao = new ContatoHibernateDao();
		Contato contatoCompleto = dao.buscarPorId(contato.getId());
		model.addAttribute("contato", contatoCompleto);
		return "contato/alterarContato";
	}

	@RequestMapping("alterarContato")
	public String alterarContato(Contato contato, Model model) {

		ContatoHibernateDao dao = new ContatoHibernateDao();
		dao.alterar(contato);
		model.addAttribute("msg", "O contato foi Alterado com Sucesso!");
		return "forward:listarContato";
	}
	
	@RequestMapping("listarContato")
	public String listarContato(Model model) {
		ContatoHibernateDao dao = new ContatoHibernateDao();
		List<Contato> listarContato = dao.listar();
		model.addAttribute("listarContato", listarContato);

		return "contato/listarContato";
	}
	
	@RequestMapping("removerContato")
	public String removerContato(Contato contato, Model model) {
		ContatoHibernateDao dao = new ContatoHibernateDao();
		dao.remover(contato);
		model.addAttribute("msg", "o contato removido com sucesso!");
		return "forward:listarContato";
	}
	
	@RequestMapping("buscarContato")
	public String buscarProduto(Contato contato, Model model) {
		ContatoHibernateDao dao = new ContatoHibernateDao();
		List<Contato> buscarContato = dao.buscar(contato);
		model.addAttribute("buscarContato", buscarContato);

		return "contato/buscarContato";

	}
	

}
