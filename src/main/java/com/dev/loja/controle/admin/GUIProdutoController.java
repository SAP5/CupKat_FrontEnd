package com.dev.loja.controle.admin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dev.loja.model.Cor;
import com.dev.loja.model.Produto;
import com.dev.loja.model.ProdutoDTO;
import com.dev.loja.model.Tamanho;
import com.dev.loja.service.ProdutoI;

@Controller
@RequestMapping(path = "/adm")
public class GUIProdutoController {

    @Autowired
    ProdutoI servico;

    @GetMapping("/produtos")
	public String listProdutos(Model model) {
		List<ProdutoDTO> listProdutos = servico.obtemProdutos();
		model.addAttribute("listProdutos", listProdutos);
		return "administrativo/produtos";
	}

    @GetMapping("/produtoCad")
	public String formCliente(Model model) {
        ProdutoDTO produtodto = new ProdutoDTO();
        Produto produto = new Produto();
        List<Tamanho> listT = new ArrayList<Tamanho>();
        List<String> listM = Arrays.asList("Garrafa", "Camiseta", "Chinelo", "Caneca");
        List<Cor> listCor = new ArrayList<Cor>();
        
        Cor c1= new Cor("Rosa");
        Cor c2= new Cor("Roxo");
        Cor c3= new Cor("Lilás");
        Cor c4= new Cor("Azul");
        listCor.add(c1);
        listCor.add(c2);
        listCor.add(c3);
        listCor.add(c4);

        Tamanho t1 = new Tamanho("pequeno");
        Tamanho t2 = new Tamanho("médio");
        Tamanho t3 = new Tamanho("grande");
        listT.add(t1);
        listT.add(t2);
        listT.add(t3);

        model.addAttribute("produtodto", produtodto);
        model.addAttribute("produto", produto);
        model.addAttribute("listT", listT);
        // model.addAttribute("listC", listC);
        model.addAttribute("listM", listM);
        model.addAttribute("listCor", listCor);

		return "administrativo/produto_form";
	}

    @PostMapping("/saveProduto")
	public String saveCliente(Produto produto, RedirectAttributes redirectAttributes) {
		System.out.println(produto);
        
        List<Integer> cat = new ArrayList<Integer>();
		Integer cate = 0;
        cate = produto.getModelo();
        cat.add(cate);
        produto.setCategorias(cat);

		servico.save(produto);
		redirectAttributes.addFlashAttribute("message", "Produto criado com sucesso!");
		return "redirect:/adm/produtos";
	}
    
    @GetMapping("/produtos/delete/{id}")
	public String deleteCliente(@PathVariable("id") int id){
		servico.delete(id);
		return "redirect:/adm/produtos";
	}

   
}
