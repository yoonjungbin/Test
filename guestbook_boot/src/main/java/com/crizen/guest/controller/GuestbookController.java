package com.crizen.guest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.crizen.guest.domain.Guestbook;
import com.crizen.guest.repository.GuestbookRepository;

@Controller
@RequestMapping("guestbook")
public class GuestbookController {
	@Autowired
	private GuestbookRepository guestbookRepository;

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index(Model model) {
		List<Guestbook> guestbookList = (List<Guestbook>) guestbookRepository.findAll();
		model.addAttribute("guestbookList", guestbookList);
		return "index";
	}

	@RequestMapping(value="/", method=RequestMethod.POST)
	public String add(Guestbook guestbook) {
		guestbookRepository.save(guestbook);
		return "redirect:/guestbook/";
	}

	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String deleteform() {
		return "deleteform";
	}

	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String delete(Guestbook guestbook) {
		guestbookRepository.delete(guestbook);
		return "redirect:/guestbook/";
	}
}
