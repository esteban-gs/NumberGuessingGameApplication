package com.esteban_edu.NumberGuessingGame;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class NumberGuessingGameApplicationTests {

	@Test
	void contextLoads() {
		assertEquals(1, 1);
	}

}
