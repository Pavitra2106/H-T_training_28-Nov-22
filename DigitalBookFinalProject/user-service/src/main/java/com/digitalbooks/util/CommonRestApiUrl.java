package com.digitalbooks.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CommonRestApiUrl {

	@Value("${rest.api.url.create-book}")
	private String createBookUrl;

	@Value("${rest.api.url.update-book}")
	private String updateBookUrl;

	@Value("${rest.api.url.block-book}")
	private String blockBookUrl;

	@Value("${rest.api.url.search-book}")
	private String searchBookUrl;

	@Value("${rest.api.url.subscribe-book}")
	private String subscribeBookUrl;

	@Value("${rest.api.url.get-all-book-reader}")
	private String getAllReaderBookUrl;

	@Value("${rest.api.url.get-book-reader}")
	private String getReaderBookUrl;

	@Value("${rest.api.url.get-content-reader-book}")
	private String contentReaderSubBookUrl;

	@Value("${rest.api.url.cancel-sub-book}")
	private String cancelSubBookUrl;

	@Value("${rest.api.url.get-all-author}")
	private String allBookAuthorUrl;

	@Value("${rest.api.url.get-book-author}")
	private String getAuthorBookUrl;

	@Value("${rest.api.url.get-all-book}")
	private String allBookUrl;

	public String getCreateBookUrl() {
		return createBookUrl;
	}

	public String getUpdateBookUrl() {
		return updateBookUrl;
	}

	public String getBlockBookUrl() {
		return blockBookUrl;
	}

	public String getSearchBookUrl() {
		return searchBookUrl;
	}

	public String getSubscribeBookUrl() {
		return subscribeBookUrl;
	}

	public String getGetAllReaderBookUrl() {
		return getAllReaderBookUrl;
	}

	public String getGetReaderBookUrl() {
		return getReaderBookUrl;
	}

	public String getContentReaderSubBookUrl() {
		return contentReaderSubBookUrl;
	}

	public String getCancelSubBookUrl() {
		return cancelSubBookUrl;
	}

	public String getAllBookAuthorUrl() {
		return allBookAuthorUrl;
	}

	public String getGetAuthorBookUrl() {
		return getAuthorBookUrl;
	}

	public String getAllBookUrl() {
		return allBookUrl;
	}

}
