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

import com.manoj.model.Diary;
import com.manoj.service.DiaryService;

@Controller
public class DiaryController {
	
	private DiaryService diaryService;
	
	@Autowired(required=true)
//	@Resource
	@Qualifier(value="diaryService")
	public void setDiaryService(DiaryService ds){
		this.diaryService = ds;
	}

/*	@RequestMapping(value= "/diary/{person_id}", method = RequestMethod.GET)		
	 public String listDiary(@PathVariable("person_id") int person_id,Model model) {
		model.addAttribute("diary", new Diary());
		model.addAttribute("person_id",person_id);
		model.addAttribute("listDiary", this.diaryService.listDiary());
		return "diary/person_id";
	}
*/
	@RequestMapping(value= "/diary/{person_id}", method = RequestMethod.GET)	
	public String listDiary1(@PathVariable int person_id, Model model) {
		Diary d = new Diary();
		d.setPerson_id(person_id);
		model.addAttribute("dia","Add a Diary");
		model.addAttribute("diary", d);//new Diary());
		model.addAttribute("person_id",person_id);
		model.addAttribute("listDiary1", this.diaryService.listDiary1(person_id));
		return "diary";
	}

	//For add and update diary both
	@RequestMapping(value= "/diary/add/{person_id}", method = RequestMethod.POST)
	public String addDiary(@PathVariable int person_id,@ModelAttribute("diary") Diary d){
		d.setPerson_id(person_id);
		System.out.println("000. "+d.getEvent_id()+" "+d.getPerson_id());
		if(d.getEvent_id() == 0){
	 		//new person, add it
			System.out.println("add: "+d.getEvent_id());
			this.diaryService.addDiary(d);
		}else{ 
			//existing person, call update
			System.out.println("update : "+d.getEvent_id());
			this.diaryService.updateDiary(d);
		}
		
		return "redirect:/diary/{person_id}";
		
	}
	
	@RequestMapping("/remove/{person_id}/{event_id}")
    public String removeDiary(@PathVariable("person_id") int person_id,@PathVariable("event_id") int event_id){
		
        this.diaryService.removeDiary(event_id);
        return "redirect:/diary/{person_id}";
    }
 
    @RequestMapping(value="/edit/{person_id}/{event_id}", method=RequestMethod.GET)
    public String editDiary(@PathVariable("person_id") int person_id,@PathVariable("event_id") int event_id, Model model){
		model.addAttribute("dia","Edit the Diary");
    	model.addAttribute("person_id",person_id);
    	model.addAttribute("diary", this.diaryService.displayDiary(event_id));
    //    model.addAttribute("listdiary1", this.diaryService.listDiary1(person_id));
        System.out.println("111. "+person_id+" "+event_id);
        return "diary";
    }
	
} 