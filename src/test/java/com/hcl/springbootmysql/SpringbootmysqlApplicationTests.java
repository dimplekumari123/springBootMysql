package com.hcl.springbootmysql;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class) //used to launch up a spring context in unit tests.
@SpringBootTest			//indicates that the context under test is a @SpringBootApplication. 
						//The complete SpringBootTutorialBasicsApplication is launched up during the unit test.
public class SpringbootmysqlApplicationTests {

	@Test
	public void contextLoads() {
	}

}
