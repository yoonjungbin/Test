package com.crizen.guestbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.crizen.guestbook.domain.Guestbook;
import com.crizen.guestbook.service.GuestbookService;

@Controller
@RequestMapping("")
public class GuestbookController {
	@Autowired
	private GuestbookService guestbookService;

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index(Model model) {
		List<Guestbook> guestbookList = guestbookService.getMessageList();
		model.addAttribute("guestbookList", guestbookList);
		return "index";
	}

	@RequestMapping(value="/", method=RequestMethod.POST)
	public String add(Guestbook guestbook) {
		guestbookService.insertMessage(guestbook);
		return "redirect:/";
	}

	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String deleteform() {
		return "deleteform";
	}

	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String delete(Guestbook guestbook) {
		guestbookService.deleteMessage( guestbook );
		return "redirect:/";
	}
}
