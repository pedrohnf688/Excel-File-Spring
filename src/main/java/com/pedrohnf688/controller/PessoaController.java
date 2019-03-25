package com.pedrohnf688.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.MultipartFilter;

import com.pedrohnf688.helpers.ExcelHelper;
import com.pedrohnf688.modelo.Pessoa;
import com.pedrohnf688.servico.PessoaService;

@Controller
@Configuration
@RequestMapping("/pessoa")
public class PessoaController implements ServletContextAware {
	
	@Autowired
	private PessoaService pessoaService;
	
	private ServletContext servletContext;
	
	@RequestMapping(method = RequestMethod.GET)
	public String index() {
		return "pessoa/index";
	}

	@RequestMapping(value ="importExcel", method = RequestMethod.POST)
	public @ResponseBody String importExcel(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws Exception {
		
		String fileName = saveExcelFile(file);
		String excelPath = servletContext.getRealPath("/resources/excels/"+fileName);
		
		ExcelHelper excelHelper = new ExcelHelper(excelPath);
		
		List<Pessoa> pessoas = excelHelper.readData(Pessoa.class.getName());
		
		for(Pessoa pessoa : pessoas) {
			pessoaService.save(pessoa);
		}
		
		return "pessoa/index";
	}
	
	
	private String saveExcelFile(MultipartFile multipartFile) {
		try {
			byte[] bytes = multipartFile.getBytes();
			Path path = Paths.get(servletContext.getRealPath("/resources/excels/"+multipartFile.getOriginalFilename()));
			Files.write(path, bytes);
			return multipartFile.getOriginalFilename();
		}catch(Exception e) {
			return null;
		}
	
	}
	
	
	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
		
	}
	
	
}
