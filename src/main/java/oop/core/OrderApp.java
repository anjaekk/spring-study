package oop.core;

import oop.core.member.Grade;
import oop.core.member.Member;
import oop.core.member.MemberService;
import oop.core.member.MemberServiceImpl;
import oop.core.order.Order;
import oop.core.order.OrderService;
import oop.core.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {

        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "memberA", 10000);

        System.out.println("order = " + order);
    }
}
