package com.go.bmb.app.book.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

public interface bookService {
	 List<Map<String,Object>> findAll();
}
