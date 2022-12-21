package de.freerider;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 * JUnit5 tests for HelloMaven class.
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class HelloMavenTest {

	/**
	 * Test case to verify singleton instance behavior.
	 */
	@Test @Order(100)
	void test100_singleton() {
		final HelloMaven inst_1 = HelloMaven.getInstance();
		final HelloMaven inst_2 = HelloMaven.getInstance();
		assertNotNull(inst_1);
		assertNotNull(inst_2);
		assertTrue(inst_1 instanceof HelloMaven);
		assertTrue(inst_2 instanceof HelloMaven);
		assertSame(inst_1, inst_2);
	}


	/**
	 * Test case to verify getHelloMessage(withQuotes: false)
	 * returns unquoted message.
	 */
	@Test @Order(200)
	void test200_getMessageNoQuotes() {
		final var inst = HelloMaven.getInstance();
		String res = inst.getHelloMessage(false);
		assertEquals("Hello Maven!", res);
	}


	/**
	 * Test case to verify getHelloMessage(withQuotes: true)
	 * returns quoted message.
	 */
	@Test @Order(210)
	void test210_getMessageQuotes() {
		final var inst = HelloMaven.getInstance();
		String res = inst.getHelloMessage(true);
		assertEquals("\"Hello Maven!\"", res);
	}
}
