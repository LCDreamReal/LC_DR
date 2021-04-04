package com.lc.dr;

import com.lc.dr.service.TestService;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class LcDrApplicationTests {

	@Resource
	private List<TestService> serviceList;

	private final Map<String, Function<String, Boolean>> tests = new HashMap<>();

	@Test
	public void contextLoads() {
		serviceList.forEach(testService -> tests.put(testService.type(), testService::test));
		if (tests.containsKey("A")) {
			tests.get("A").apply("test CCCCCC");
		}
	}

	@Test
	public void test() {
		int[] nums = new int[]{1,1,2,2,4,5,5,7,8,8,8,8};
		int res = nums[0];
		int rst = 0;
		int[] response = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			if ((res ^ nums[i]) != 0) {
				System.out.println(nums[i]);
				res = nums[i];
				response[rst++] = nums[i];
			}
		}
		System.out.println(response.length);
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
