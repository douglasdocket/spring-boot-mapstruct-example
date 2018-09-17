package com.github.douglasdocket.mapstruct.controller;

import com.github.douglasdocket.mapstruct.domain.Empresa;
import com.github.douglasdocket.mapstruct.factory.EmpresaFactory;
import com.github.douglasdocket.mapstruct.hardcode.Sexo;
import com.github.douglasdocket.mapstruct.hardcode.TipoPessoa;
import com.github.douglasdocket.mapstruct.repository.EmpresaRepository;
import com.github.douglasdocket.mapstruct.vo.NovaEmpresaVO;
import com.github.douglasdocket.mapstruct.vo.NovoFuncionarioVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/empresa")
public class EmpresaController {

	private EmpresaRepository empresaRepository;

	private EmpresaFactory empresaFactory;

	@Autowired
	public EmpresaController(EmpresaRepository empresaRepository, EmpresaFactory empresaFactory) {
		this.empresaRepository = empresaRepository;
		this.empresaFactory = empresaFactory;
	}

	@GetMapping
	public String home(Model model, @ModelAttribute("novaEmpresa") NovaEmpresaVO novaEmpresaVO, @RequestParam(name = "e", required = false) String empresaUUID) {


		model.addAttribute("sexos", Sexo.values());
		model.addAttribute("tipos", TipoPessoa.values());
		model.addAttribute("novaEmpresa", novaEmpresaVO);
		model.addAttribute("empresas", empresaRepository.findAll());

		if (empresaUUID != null && !"".equals(empresaUUID)) {
			empresaRepository.findOneByUuid(empresaUUID).ifPresent(empresa -> model.addAttribute("empresa", empresa));
		}

		return "empresa/home";
	}

	@PostMapping(params = "adicionarFuncionario")
	public String adicionarFuncionario(Model model, @ModelAttribute("novaEmpresa") NovaEmpresaVO novaEmpresaVO, RedirectAttributes redirectAttributes) {

		novaEmpresaVO.getFuncionarios().add(new NovoFuncionarioVO());

		redirectAttributes.addFlashAttribute("novaEmpresa", novaEmpresaVO);

		return "redirect:/empresa";
	}

	@PostMapping
	public String criar(Model model, @ModelAttribute("novaEmpresa") @Valid NovaEmpresaVO novaEmpresaVO, BindingResult result) {

		if (result.hasErrors()) {
			model.addAttribute("sexos", Sexo.values());
			model.addAttribute("tipos", TipoPessoa.values());
			model.addAttribute("novaEmpresa", novaEmpresaVO);
			model.addAttribute("empresas", empresaRepository.findAll());

			return "empresa/home";
		}

		Empresa empresa = empresaFactory.fabricateFromViewObject(novaEmpresaVO);

		empresaRepository.save(empresa);

		return "redirect:/empresa";
	}


}
