package com.rest.rest2;

import org.springframework.data.jpa.repository.JpaRepository;

interface Library extends JpaRepository<Book, Long> {
}
