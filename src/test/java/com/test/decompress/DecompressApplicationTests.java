package com.test.decompress;

import com.test.decompress.services.DecompressService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DecompressApplicationTests {

	@Autowired
	DecompressService service;

	@Test
	public void case1() {
		String expected = "abcabcabababc";
		String input="2[abc]3[ab]c";
		assertEquals(expected,service.decompressWithSearching(input));
	}

	@Test
	public void case2() {
		String expected = "aaaaaaaaaacabab";
		String input="10[a]c2[ab]";
		assertEquals(expected,service.decompressWithSearching(input));
	}

	@Test
	public void case3() {
		String expected = "aaabaaab";
		String input="2[3[a]b]";
		assertEquals(expected,service.decompressWithSearching(input));
	}

	@Test
	public void case4() {
		String expected = "aaaaaaaaaa";
		String input="10[a]";
		assertEquals(expected,service.decompressWithSearching(input));
	}

	@Test
	public void case5() {
		String expected = "aacacbaacacb";
		String input="2[a2[ac]b]";
		assertEquals(expected,service.decompressWithSearching(input));
	}




}
