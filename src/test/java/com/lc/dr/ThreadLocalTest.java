package com.lc.dr;

import org.junit.Test;

/**
 * Date:   2019/11/30.
 * Author: licheng
 */
public class ThreadLocalTest {

    private static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 1);

    private static A a = new A();
    private static ThreadLocal<A> threadLocalSameA = ThreadLocal.withInitial(() -> a);

    private static ThreadLocal<A> threadLocalDiffA = ThreadLocal.withInitial(A::new);

    @Test
    public void testThreadLocal_WithInteger() {
        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            threads[i] = new Thread(() -> {
                threadLocal.set(threadLocal.get() + 5);
                System.out.println(Thread.currentThread().getName() + ":" + threadLocal.get());
            });
        }

        for (Thread thread : threads) {
            thread.start();
        }
    }

    @Test
    public void testThreadLocal_WithClass() {
        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            threads[i] = new Thread(() -> {
                /**
                 * ThreadLocal让访问某个变量的线程拥有自己的局部变量指向同一个对象，此时ThreadLocal会失效
                 * 打印结果：
                 * 2119779021:Thread-0:5:1889444726
                 * 2119779021:Thread-1:10:1889444726
                 * 2119779021:Thread-2:15:1889444726
                 * 2119779021:Thread-3:20:1889444726
                 * 2119779021:Thread-4:25:1889444726
                 */
                threadLocalSameA.get().setNum(threadLocalSameA.get().getNum() + 5);
                System.out.println(threadLocalSameA.hashCode() + ":" + Thread.currentThread().getName() + ":" + threadLocalSameA.get().getNum() + ":" + threadLocalSameA.get().hashCode());

                /**
                 * ThreadLocal让访问某个变量的线程拥有自己的局部变量指向不同的对象，此时ThreadLocal不会失效
                 * 打印结果：
                 * 1042576329:Thread-0:5:820218493
                 * 1042576329:Thread-1:5:1429673119
                 * 1042576329:Thread-2:5:1825528150
                 * 1042576329:Thread-3:5:870433288
                 * 1042576329:Thread-4:5:2119779021
                 */
                threadLocalDiffA.get().setNum(threadLocalDiffA.get().getNum() + 5);
                System.out.println(threadLocalDiffA.hashCode() + ":" + Thread.currentThread().getName() + ":" + threadLocalDiffA.get().getNum() + ":" + threadLocalDiffA.get().hashCode());
            });
        }

        for (Thread thread : threads) {
            thread.start();
        }
    }
}

class A {
    private int num;

    int getNum() {
        return num;
    }

    void setNum(int num) {
        this.num = num;
    }
}
