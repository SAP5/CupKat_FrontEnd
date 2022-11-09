package com.dev.loja.controle.admin;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dev.loja.model.Categoria;
import com.dev.loja.model.Cor;
import com.dev.loja.model.Funcionario;
import com.dev.loja.model.Produto;
import com.dev.loja.model.ProdutoDTO;
import com.dev.loja.model.Tamanho;
import com.dev.loja.service.CategoriaI;
import com.dev.loja.service.CorI;
import com.dev.loja.service.ProdutoI;
import com.dev.loja.service.TamanhoI;

@Controller
@RequestMapping(path = "/adm")
public class GUIProdutoController {

    @Autowired
    ProdutoI servico;
    @Autowired
    CorI servicoCor;
    @Autowired
    TamanhoI servicoTam;
    @Autowired
    CategoriaI servicoCat;
    

    @GetMapping("/produtos")
	public String listProdutos(Model model) {
		List<ProdutoDTO> listProdutos = servico.obtemProdutos();
		model.addAttribute("listProdutos", listProdutos);
		return "administrativo/produtos";
	}

    @GetMapping("/produtoCad")
	public String formCliente(Model model) {
    	Produto produto = new Produto();
        List<Cor> listCor = servicoCor.obtemCores();
        List<Tamanho> listTamanho = servicoTam.obtemTamanhos();
        List<Categoria> listCategoria = servicoCat.obtemCategoria();
        
        model.addAttribute("produto",produto);
		model.addAttribute("listCor", listCor);
		model.addAttribute("listTamanho", listTamanho);
		model.addAttribute("listCategoria", listCategoria);
        
		return "administrativo/produto_form";
	}

//    @PostMapping("/saveProduto")
//	public String saveProduto(Produto produto, RedirectAttributes redirectAttributes) {
//		servico.save(produto);
//		redirectAttributes.addFlashAttribute("message", "Produto criado com sucesso!");
//		return "redirect:/adm/produtos";
//	}
    
    @PostMapping("/saveProduto")
   	public ModelAndView save(@Valid Produto produto, BindingResult result, RedirectAttributes redirectAttributes) {
   		ModelAndView mv = new ModelAndView("produtos");
   		List<Cor> listCor = servicoCor.obtemCores();
   		List<Tamanho> listTamanho = servicoTam.obtemTamanhos();
   		List<Categoria> listCategoria = servicoCat.obtemCategoria();
   		if (result.hasErrors()) {
   			mv.addObject("produto", produto);
   			mv.addObject("produto",produto);
   			mv.addObject("listCor", listCor);
   			mv.addObject("listTamanho", listTamanho);
   			mv.addObject("listCategoria", listCategoria);
   			mv.setViewName("administrativo/produto_form");
   		} else {
   			servico.save(produto);
   			mv.setViewName("administrativo/produtos");
   			redirectAttributes.addFlashAttribute("message", "Produto criado com sucesso!");
   			mv.setViewName("redirect:/adm/produtos");
   		}
   		return mv;
   	}
    
    @GetMapping("/alteraProd/{id}")
	public ModelAndView viewProdutoUpdate(@PathVariable("id") int id) {
    	ModelAndView mv = new ModelAndView("administrativo/produto_update");
    	Produto produto = new Produto();
		produto = servico.getById(id);
		
		List<Cor> listCor = servicoCor.obtemCores();
        List<Tamanho> listTamanho = servicoTam.obtemTamanhos();
        List<Categoria> listCategoria = servicoCat.obtemCategoria();
        
        mv.addObject("produto",produto);
		mv.addObject("listCor", listCor);
		mv.addObject("listTamanho", listTamanho);
		mv.addObject("listCategoria", listCategoria);
		return mv;
	}
    
    @PostMapping("/produtos/update/{id}")
	public ModelAndView updateFuncionario(@PathVariable("id") int id, @Valid Produto produto, BindingResult result, RedirectAttributes redirectAttributes){
    	ModelAndView mv = new ModelAndView("administrativo/produtos");
    	List<Cor> listCor = servicoCor.obtemCores();
   		List<Tamanho> listTamanho = servicoTam.obtemTamanhos();
   		List<Categoria> listCategoria = servicoCat.obtemCategoria();
    	if (result.hasErrors()) {
    		produto.setId(id);
    		mv.addObject("produto",produto);
    		mv.addObject("listCor", listCor);
    		mv.addObject("listTamanho", listTamanho);
    		mv.addObject("listCategoria", listCategoria);
   			mv.setViewName("administrativo/produto_update");
   			
   		} else {
   			servico.update(produto, id);
   			redirectAttributes.addFlashAttribute("message", "Produto alterado com sucesso!");
   			mv.setViewName("redirect:/adm/produtos");
   		}
   		return mv;
	}
    
    @GetMapping("/produtos/delete/{id}")
	public String deleteCliente(@PathVariable("id") int id){
		servico.delete(id);
		return "redirect:/adm/produtos";
	}

   
}
