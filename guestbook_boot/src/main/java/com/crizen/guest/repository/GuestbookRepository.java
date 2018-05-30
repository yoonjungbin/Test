package com.crizen.guest.repository;

import org.springframework.data.repository.CrudRepository;

import com.crizen.guest.domain.Guestbook;

public interface GuestbookRepository  extends CrudRepository<Guestbook, Long> {
}