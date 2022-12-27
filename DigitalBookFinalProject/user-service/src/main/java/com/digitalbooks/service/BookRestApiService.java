package com.digitalbooks.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.digitalbooks.entity.User;
import com.digitalbooks.exception.RequestNotFounException;
import com.digitalbooks.repository.UserRepository;
import com.digitalbooks.request.Book;
import com.digitalbooks.request.BookSub;
import com.digitalbooks.response.AuthorRes;
import com.digitalbooks.response.BookResponse;
import com.digitalbooks.response.MessageResponse;
import com.digitalbooks.response.SearchBookResponse;
import com.digitalbooks.util.CommonRestApiUrl;
import com.digitalbooks.util.CommonStringUtil;
import com.digitalbooks.util.RestApiExceptionUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class BookRestApiService {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private CommonRestApiUrl commonRestApiUrl;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CommonStringUtil commonStringUtil;

	@Autowired
	private ObjectMapper objectMapper;

	public ResponseEntity<Integer> createBook(Book book) throws Exception {

		Optional<User> user = userRepository.findById((long) book.getAuthorId());

		if (user.isEmpty()) {
			throw new RequestNotFounException("Error : Author Not Found");
		}

		try {
			ResponseEntity<Integer> response = restTemplate.postForEntity(commonRestApiUrl.getCreateBookUrl(), book,
					Integer.class);
			return response;
		} catch (HttpClientErrorException e) {
			throw RestApiExceptionUtil.throwClientException(e);
		}

	}

	public ResponseEntity<MessageResponse> updateBook(Book book) throws Exception {


		try {
			restTemplate.put(commonRestApiUrl.getUpdateBookUrl(), book);
			return ResponseEntity.status(HttpStatus.CREATED).body(new MessageResponse("Book updated successfully!"));
		} catch (HttpClientErrorException e) {
			throw RestApiExceptionUtil.throwClientException(e);
		}

	}

	public ResponseEntity<MessageResponse> blockBook(Integer authorId, Integer bookId, String block) throws Exception {

		String url = commonStringUtil.replaceAll("authorId", "" + authorId, commonRestApiUrl.getBlockBookUrl());
		url = commonStringUtil.replaceAll("bookId", "" + bookId, url);

		Map<String, Object> reqParam = new HashMap<>();

		try {

			ResponseEntity<MessageResponse> response = restTemplate.postForEntity(url + "?block=" + block, reqParam,
					MessageResponse.class);
			return response;
		} catch (HttpClientErrorException e) {
			throw RestApiExceptionUtil.throwClientException(e);
		}

	}

	public ResponseEntity<List<BookResponse>> searchBook(String category, String title, Integer author, Double price,
			String publisher) throws JsonMappingException, JsonProcessingException {

		ResponseEntity<List<BookResponse>> response = null;

		Map<String, String> mapParam = new LinkedHashMap<>();

		if (category != null) {
			mapParam.put("category", "" + category);
		}
		if (title != null) {
			mapParam.put("title", "" + title);
		}
		if (author != null) {
			mapParam.put("author", "" + author);
		}
		if (price != null) {
			mapParam.put("price", "" + price);
		}
		if (publisher != null) {
			mapParam.put("publisher", "" + publisher);
		}

		String urlParam = "";

		for (Entry<String, String> entry : mapParam.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
			if (urlParam.length() > 0) {
				urlParam += "&" + key + "=" + value;
			} else {
				urlParam += "?" + key + "=" + value;
			}
		}
		ResponseEntity<String> response1 = null;
		response1 = restTemplate.getForEntity(commonRestApiUrl.getSearchBookUrl() + urlParam, String.class);
		String resMsg = response1.getBody();

		List<User> users = userRepository.findAll();

		Map<Long, List<User>> map = users.stream().collect(Collectors.groupingBy(User::getId, Collectors.toList()));

		List<BookResponse> bookResponses = objectMapper.readValue(resMsg, new TypeReference<List<BookResponse>>() {
		});
		for (BookResponse bookResponse : bookResponses) {
			List<User> listUser = map.get((long) bookResponse.getAuthorId());
			if (listUser != null && !listUser.isEmpty()) {
				bookResponse.setAuthor(listUser.get(0).getUsername());
			}
		}

		response = ResponseEntity.status(response1.getStatusCode()).body(bookResponses);

		return response;

	}

	public ResponseEntity<List<BookResponse>> searchBookV2(String category, String title, String author, Double price,
			String publisher) throws JsonMappingException, JsonProcessingException {
		ResponseEntity<List<BookResponse>> response = null;

		Map<String, String> mapParam = new LinkedHashMap<>();

		if (category != null) {
			mapParam.put("category", "" + category);
		}
		if (title != null) {
			mapParam.put("title", "" + title);
		}
		if (author != null) {

			Optional<User> user = userRepository.findByUsername(author);
			if (user.isEmpty()) {
				throw new RequestNotFounException("Error: Book not found");
			}
			mapParam.put("authorId", "" + user.get().getId());
		}
		if (price != null) {
			mapParam.put("price", "" + price);
		}
		if (publisher != null) {
			mapParam.put("publisher", "" + publisher);
		}

		String urlParam = "";

		for (Entry<String, String> entry : mapParam.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
			if (urlParam.length() > 0) {
				urlParam += "&" + key + "=" + value;
			} else {
				urlParam += "?" + key + "=" + value;
			}
		}
		ResponseEntity<String> response1 = null;
		response1 = restTemplate.getForEntity(commonRestApiUrl.getSearchBookUrl() + urlParam, String.class);
		String resMsg = response1.getBody();

		List<User> users = userRepository.findAll();

		Map<Long, List<User>> map = users.stream().collect(Collectors.groupingBy(User::getId, Collectors.toList()));

		List<BookResponse> bookResponses = objectMapper.readValue(resMsg, new TypeReference<List<BookResponse>>() {
		});
		for (BookResponse bookResponse : bookResponses) {
			List<User> listUser = map.get((long) bookResponse.getAuthorId());
			if (listUser != null && !listUser.isEmpty()) {
				bookResponse.setAuthor(listUser.get(0).getUsername());
			}
		}

		response = ResponseEntity.status(response1.getStatusCode()).body(bookResponses);

		return response;
	}

	public ResponseEntity<Integer> subscribeBook(BookSub bookSub) throws Exception {

		try {

			ResponseEntity<Integer> response = restTemplate.postForEntity(commonRestApiUrl.getSubscribeBookUrl(),
					bookSub, Integer.class);
			return response;
		} catch (HttpClientErrorException e) {
			throw RestApiExceptionUtil.throwClientException(e);
		}

	}

	public ResponseEntity<List<BookResponse>> getAllReaderBook(String emailId)
			throws JsonMappingException, JsonProcessingException {

		Optional<User> user = userRepository.findByEmail(emailId);

		if (user.isEmpty()) {
			throw new RequestNotFounException(" User Not Found");
		}

		ResponseEntity<List<BookResponse>> response = null;

		String url = commonStringUtil.replaceAll("readerId", "" + user.get().getId(),
				commonRestApiUrl.getGetAllReaderBookUrl());

		ResponseEntity<String> response1 = null;
		response1 = restTemplate.getForEntity(url, String.class);
		String resMsg = response1.getBody();

		List<User> users = userRepository.findAll();

		Map<Long, List<User>> map = users.stream().collect(Collectors.groupingBy(User::getId, Collectors.toList()));

		List<BookResponse> bookResponses = objectMapper.readValue(resMsg, new TypeReference<List<BookResponse>>() {
		});
		for (BookResponse bookResponse : bookResponses) {
			List<User> listUser = map.get((long) bookResponse.getAuthorId());
			if (listUser != null && !listUser.isEmpty()) {
				bookResponse.setAuthor(listUser.get(0).getUsername());
			}
		}

		response = ResponseEntity.status(response1.getStatusCode()).body(bookResponses);

		return response;

	}

	public ResponseEntity<Book> getBookByReaderAndSubId(String emailId, Integer subId) throws Exception {

		Optional<User> user = userRepository.findByEmail(emailId);

		if (user.isEmpty()) {
			throw new RequestNotFounException(" User Not Found");
		}

		String url = commonStringUtil.replaceAll("readerId", "" + user.get().getId(),
				commonRestApiUrl.getGetReaderBookUrl());
		url = commonStringUtil.replaceAll("subId", "" + subId, url);

		try {
			ResponseEntity<Book> response = restTemplate.getForEntity(url, Book.class);

			Book book = response.getBody();
			Optional<User> author = userRepository.findById((long) book.getAuthorId());
			if (author.isPresent()) {
				book.setAuthor(author.get().getUsername());
			}
			return response;
		} catch (HttpClientErrorException e) {
			throw RestApiExceptionUtil.throwClientException(e);
		}

	}

	public ResponseEntity<String> getContentByReaderAndSubId(String emailId, Integer subId) throws Exception {

		Optional<User> user = userRepository.findByEmail(emailId);

		if (user.isEmpty()) {
			throw new RequestNotFounException(" User Not Found");
		}

		String url = commonStringUtil.replaceAll("readerId", "" + user.get().getId(),
				commonRestApiUrl.getContentReaderSubBookUrl());
		url = commonStringUtil.replaceAll("subId", "" + subId, url);

		try {
			ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
			return response;
		} catch (HttpClientErrorException e) {
			throw RestApiExceptionUtil.throwClientException(e);
		}

	}

	public ResponseEntity<MessageResponse> cancelByReaderAndSubId(String emailId, Integer subId) throws Exception {

		Optional<User> user = userRepository.findByEmail(emailId);

		if (user.isEmpty()) {
			throw new RequestNotFounException(" User Not Found");
		}

		String url = commonStringUtil.replaceAll("readerId", "" + user.get().getId(),
				commonRestApiUrl.getCancelSubBookUrl());
		url = commonStringUtil.replaceAll("subId", "" + subId, url);

		Map<String, Object> reqParam = new HashMap<>();

		try {
			ResponseEntity<MessageResponse> response = restTemplate.postForEntity(url, reqParam, MessageResponse.class);
			return response;
		} catch (HttpClientErrorException e) {
			throw RestApiExceptionUtil.throwClientException(e);
		}

	}

	public ResponseEntity<List<BookResponse>> getBooksByAuthor(Integer authorId)
			throws JsonMappingException, JsonProcessingException {


		Optional<User> user = userRepository.findById((long) authorId);

		if (user.isEmpty()) {
			throw new RequestNotFounException(" Author Not Found");
		}
		ResponseEntity<List<BookResponse>> response = null;
		String url = commonStringUtil.replaceAll("authorId", "" + authorId, commonRestApiUrl.getAllBookAuthorUrl());

		ResponseEntity<String> response1 = null;
		response1 = restTemplate.getForEntity(url, String.class);
		String resMsg = response1.getBody();

		List<BookResponse> bookResponses = objectMapper.readValue(resMsg, new TypeReference<List<BookResponse>>() {
		});
		for (BookResponse bookResponse : bookResponses) {
			bookResponse.setAuthor(user.get().getUsername());
		}

		response = ResponseEntity.status(response1.getStatusCode()).body(bookResponses);

		return response;
	}

	public ResponseEntity<Book> getBooksByAuthorAndBookId(Integer authorId, Integer bookId) throws Exception {


		Optional<User> user = userRepository.findById((long) authorId);

		if (user.isEmpty()) {
			throw new RequestNotFounException(" User Not Found");
		}

		String url = commonStringUtil.replaceAll("authorId", "" + authorId, commonRestApiUrl.getGetAuthorBookUrl());
		url = commonStringUtil.replaceAll("bookId", "" + bookId, url);

		try {
			ResponseEntity<Book> response = restTemplate.getForEntity(url, Book.class);
			return response;
		} catch (HttpClientErrorException e) {
			throw RestApiExceptionUtil.throwClientException(e);
		}
	}

	public ResponseEntity<SearchBookResponse> getAllBook() {


		ResponseEntity<SearchBookResponse> response = null;

		String url = commonRestApiUrl.getAllBookUrl();

		response = restTemplate.getForEntity(url, SearchBookResponse.class);

		SearchBookResponse bookResponse = response.getBody();

		Set<Integer> listAuthorId = bookResponse.getAuthorIdSet();
		List<AuthorRes> listAuthorRes = new ArrayList<>();
		for (Integer autherId : listAuthorId) {
			Optional<User> user = userRepository.findById((long) autherId);
			if (user.isPresent()) {
				AuthorRes authorRes = new AuthorRes();
				authorRes.setId(autherId);
				authorRes.setName(user.get().getUsername());
				listAuthorRes.add(authorRes);
			}

		}

		bookResponse.setListAuther(listAuthorRes);

		return response;

	}

}
