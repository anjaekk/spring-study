package oop.core;

import oop.core.discount.DiscountPolicy;
import oop.core.discount.FixDiscountPolicy;
import oop.core.discount.RateDiscountPolicy;
import oop.core.member.MemberRepository;
import oop.core.member.MemberService;
import oop.core.member.MemberServiceImpl;
import oop.core.member.MemoryMemberRepository;
import oop.core.order.OrderService;
import oop.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(MemberRepository());
    }

    @Bean
    public MemberRepository MemberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }

}
