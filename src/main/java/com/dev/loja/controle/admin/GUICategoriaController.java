package com.dev.loja.controle.admin;

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
import com.dev.loja.model.Funcionario;
import com.dev.loja.service.CategoriaI;


@Controller
@RequestMapping(path = "/adm")
public class GUICategoriaController {
	@Autowired
    CategoriaI servico;

    @GetMapping("/categorias")
	public String listCategorias(Model model) {
		List<Categoria> listCategorias = servico.obtemCategoria();
		model.addAttribute("listCategorias", listCategorias);
		return "administrativo/categorias";
	}
    
    @GetMapping("/categoriaCad")
	public String formCategoria(Model model) {
        Categoria categoria = new Categoria();
        model.addAttribute("categoria",categoria);
		return "administrativo/categoria_form";
	}
    
    @PostMapping("/saveCategoria")
	public ModelAndView save(@Valid Categoria categoria, BindingResult result, RedirectAttributes redirectAttributes) {
		ModelAndView mv = new ModelAndView("administrativo/categorias");
		if (result.hasErrors()) {
			mv.addObject("categoria", categoria);
			mv.setViewName("administrativo/categoria_form");
		} else {
			servico.save(categoria);
			mv.setViewName("administrativo/categorias");
			redirectAttributes.addFlashAttribute("message", "Categoria criada com sucesso!");
			mv.setViewName("redirect:/adm/categorias");
		}
		return mv;
	}
      
    @GetMapping("/alteraCat/{id}")
	public String viewCategoriaUpdate(@PathVariable("id") Integer id, Model model) {
    	Categoria categoria = new Categoria();
		categoria = servico.getById(id);
        model.addAttribute("categoria", categoria);
		return "administrativo/categoria_update";
	}
    
    @PostMapping("/categorias/update/{id}")
	public ModelAndView categoriaUpdate(@PathVariable("id") int id, @Valid Categoria categoria, BindingResult result, RedirectAttributes redirectAttributes){
    	ModelAndView mv = new ModelAndView("administrativo/categorias");
    	if (result.hasErrors()) {
    		categoria.setId(id);
    		mv.addObject("categoria",categoria);
   			mv.setViewName("administrativo/categoria_update");
   			
   		} else {
   			servico.update(categoria, id);
   			redirectAttributes.addFlashAttribute("message", "Categoria alterada com sucesso!");
   			mv.setViewName("redirect:/adm/categorias");
   		}
   		return mv;
	}
    
    @GetMapping("/categorias/delete/{id}")
	public String deleteCategoria(@PathVariable(name = "id") int id,
			Model model,
			RedirectAttributes redirectAttributes){
    	servico.delete(id);
    	redirectAttributes.addFlashAttribute("message", "A categoria com ID " + id + " foi excluída com sucesso!" );
		return "redirect:/adm/categorias";
	}
    
}
