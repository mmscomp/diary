package com.manoj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.manoj.model.Person;
import com.manoj.service.PersonService;

@Controller
public class PersonController {
	
	private PersonService personService;
	
	@Autowired(required=true)
//	@Resource
	@Qualifier(value="personService")
	public void setPersonService(PersonService ps){
		this.personService = ps;
	}	
	
	@RequestMapping(value = "/person", method = RequestMethod.GET)
	public String listPerson(Model model) {
		model.addAttribute("person", new Person());
		model.addAttribute("listPerson", this.personService.listPerson());
		//System.out.println(this.personService.listPerson());
		return "person";
	}
	
	//For add and update person both
	@RequestMapping(value= "/person/add", method = RequestMethod.POST)
	public String addPerson(@ModelAttribute("person") Person p){
		
		if(p.getId() == 0){
			//new person, add it
			this.personService.addPerson(p);
		}else{ 
			//existing person, call update
			this.personService.updatePerson(p);
		}
		
		return "redirect:/person";
		
	}
	
	@RequestMapping("/person/remove/{id}")
    public String removePerson(@PathVariable("id") int id){
		
        this.personService.removePerson(id);
        return "redirect:/person";
    }
 
    @RequestMapping("/person/edit/{id}")
    public String editPerson(@PathVariable("id") int id, Model model){
        model.addAttribute("person", this.personService.displayPerson(id));
        model.addAttribute("listperson", this.personService.listPerson());
        return "person";
    }
	
}