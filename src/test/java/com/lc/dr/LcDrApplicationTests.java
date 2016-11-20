package com.lc.dr;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LcDrApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void testLambda(){

		// 实现Runnable接口案例
		int a = 5;
		int b = 6;

		new Thread(() -> {
			System.out.println(a+b);
		}).start();

		// 遍历List集合
		List list = Arrays.asList("1","2","3");
		list.forEach(n -> {
			if (n.equals("3")) {
				System.out.println("NB"+n);
			}
		});
	}

	public static void main(String[] args) {

	}

}
