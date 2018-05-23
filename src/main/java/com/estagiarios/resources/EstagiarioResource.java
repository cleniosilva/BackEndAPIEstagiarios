package com.estagiarios.resources;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.estagiarios.models.Estagiario;
import com.estagiarios.repository.EstagiarioRepository;




@RestController
public class EstagiarioResource {
	
	@Autowired
	private EstagiarioRepository er;
	
	@CrossOrigin(origins = "http://localhost")
	@RequestMapping(value = "/estagiario",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Iterable<Estagiario>listaEstagiarios(){
		Iterable<Estagiario> listaEstagiarios = er.findAll();
		return listaEstagiarios;
	}
	
	
	@CrossOrigin(origins = "http://localhost")
	@RequestMapping(method = RequestMethod.GET, value = "/estagiario/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public  Estagiario buscaPorId(@PathVariable Integer id) {
		return er.findOne(id);
	
	}
	
	@CrossOrigin(origins = "http://localhost")
	@RequestMapping(value = "/estagiario",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Estagiario cadastraEstagiario(@RequestBody @Valid Estagiario estagiario) {
		return er.save(estagiario);
	}
	
	@CrossOrigin(origins = "http://localhost")
	@RequestMapping(value = "/estagiario",method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public Estagiario atualizaEstagiario(@RequestBody Estagiario estagiario) {
		er.save(estagiario);
		return estagiario;
	}
	
	@CrossOrigin(origins = "http://localhost")
	@RequestMapping(value = "/estagiario/{id}",method = RequestMethod.DELETE)
	public void  deletaEstagiario(@PathVariable(value = "id") Integer id) {
		er.delete(id);
	
	
	}
	
	
	

}
