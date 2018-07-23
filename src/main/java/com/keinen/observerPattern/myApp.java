package com.keinen.observerPattern;

import com.keinen.observerPattern.eventSource.eventSource;
import com.keinen.observerPattern.responseHandler.responseHandler;

public class myApp {
    public static void main(String args[]) {
        System.out.println("Enter Text >");

        // 이벤트 발생 주체를 생성함 - stdin 으로 부터 문자열을 입력받음.
        final eventSource evSrc = new eventSource();

        // 옵저버를 생성 함.
        final responseHandler respHandler = new responseHandler();

        // 옵저버가 발행 주체가 발행하는 이벤트를 구독하게 함.
        evSrc.addObserver(respHandler);

        // 이벤트를 발행시키는 쓰레드 시작
        Thread thread = new Thread(evSrc);
        thread.start();
    }
}
