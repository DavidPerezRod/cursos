package com.ratondbiblioteca.utils.aspects;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AlmJpaRepoException extends Exception {

	public AlmJpaRepoException(Exception except) {
		log.debug("aquí estamos");
	}

}
