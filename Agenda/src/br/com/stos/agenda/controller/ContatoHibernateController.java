package br.com.stos.agenda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import br.com.stos.agenda.dao.ContatoHibernateDao;
import br.com.stos.agenda.model.Contato;

@Controller
public class ContatoHibernateController {
	
	@RequestMapping("/exibirIncluirContato")
	public String exibirIncluirContato() {
		return "contato/incluirContato";
	}

	@RequestMapping("incluirContato")
	public String incluirContato(Contato contato, Model model) {

	ContatoHibernateDao dao = new ContatoHibernateDao();
	dao.salvar(contato);
	model.addAttribute("msg", "O Contato " + contato.getNome()
	+ " foi Inserido com Sucesso !");
	return "forward:listarContato";
	}

}
