package com.makersacademy.acebook.model;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;

import org.junit.Test;

public class PostTest {

	private Post post = new Post("hello", "hi");

	@Test
	public void postHasContent() {
		assertThat(post.getContent(), containsString("hello"));
	}

	@Test
	public void postHasTitle() {
		assertThat(post.getTitle(), containsString("hi"));
	}

	@Test
	public void postAcedStartsZero() {
		Post post = new Post("Test", "Test title");
		post.setAced(5);
		assertEquals(5, post.getAced());
	}

	@Test
	public void postAcedIncrements() {
		Post post = new Post("Test", "Test title");
		post.setAced(5);
		post.incrementAced();
		post.incrementAced();
		assertEquals(7, post.getAced());
	}

}
