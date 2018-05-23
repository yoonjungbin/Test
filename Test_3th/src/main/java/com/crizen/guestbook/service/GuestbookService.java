package com.crizen.guestbook.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crizen.guestbook.domain.Guestbook;
import com.crizen.guestbook.repository.GuestbookRepository;

@Service
@Transactional
public class GuestbookService {
	@Autowired
	private GuestbookRepository guestbookRepository;

	public List<Guestbook> getMessageList(){
		return guestbookRepository.findAll();
	}

	public void insertMessage(Guestbook guestbook) {
		guestbook.setRegDate(new Date());
		guestbookRepository.save(guestbook);
	}

	public void deleteMessage(Guestbook guestbook) {
		boolean result = guestbookRepository.remove(guestbook);
	}
}
