package br.com.stos.agenda.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import br.com.stos.agenda.dao.ContatoDao;
import br.com.stos.agenda.dao.ContatoHibernateDao;
import br.com.stos.agenda.model.Contato;
import br.com.stos.agenda.util.Util;


@Controller
public class ContatoController {
	
	@RequestMapping("/exibirSalvarContato")
	public String exibirSalvarContato() {

		return "contato/salvarContato";
	}
	
	@RequestMapping("salvarContato")
	public String salvarContato(Contato contato, Model model,  @RequestParam("file") MultipartFile imagem) {
		if (Util.fazerUploadImagem(imagem)) {
			contato.setFoto(Util.obterMomentoAtual() + " - " + imagem.getOriginalFilename());
		}
		ContatoDao dao = new ContatoDao();
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

		ContatoDao dao = new ContatoDao();
		dao.alterar(contato);
		model.addAttribute("msg", "O contato foi Alterado com Sucesso!");
		return "forward:listarContato";
	}
	
	@RequestMapping("removerContato")
	public String removerContato(Contato contato, Model model) {
		ContatoDao dao = new ContatoDao();
		dao.remover(contato);
		model.addAttribute("msg", "o contato removido com sucesso!");
		return "forward:listarContato";
	}
	
	@RequestMapping("listarContato")
	public String listarContato(Model model) {
		ContatoDao dao = new ContatoDao();
		List<Contato> listarContato = dao.listar();
		model.addAttribute("listarContato", listarContato);

		return "contato/listarContato";
	}
	
	@RequestMapping("buscarContato")
	public String buscarProduto(Contato contato, Model model) {
		ContatoDao dao = new ContatoDao();
		List<Contato> buscarContato = dao.buscar(contato);
		model.addAttribute("buscarContato", buscarContato);

		return "forward:buscarContato";

	}

	

}
