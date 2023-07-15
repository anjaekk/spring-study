package oop.core;

import oop.core.discount.FixDiscountPolicy;
import oop.core.member.MemberService;
import oop.core.member.MemberServiceImpl;
import oop.core.member.MemoryMemberRepository;
import oop.core.order.OrderService;
import oop.core.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }

}
