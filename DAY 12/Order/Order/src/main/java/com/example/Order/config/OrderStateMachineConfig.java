package com.example.Order.config;

import com.example.Order.models.OrderEvent;
import com.example.Order.models.OrderState;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import java.util.EnumSet;

@Configuration
@EnableStateMachine
public class OrderStateMachineConfig
        extends EnumStateMachineConfigurerAdapter<OrderState, OrderEvent> {

    @Override
    public void configure(StateMachineStateConfigurer<OrderState, OrderEvent> states)
            throws Exception {
        states
                .withStates()
                .initial(OrderState.NEW)
                .states(EnumSet.allOf(OrderState.class))
                .end(OrderState.DELIVERED)
                .end(OrderState.CANCELLED);
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<OrderState, OrderEvent> transitions)
            throws Exception {
        transitions
                .withExternal()
                .source(OrderState.NEW).target(OrderState.PROCESSING)
                .event(OrderEvent.PROCESS)
                .and()
                .withExternal()
                .source(OrderState.PROCESSING).target(OrderState.SHIPPED)
                .event(OrderEvent.SHIP)
                .and()
                .withExternal()
                .source(OrderState.SHIPPED).target(OrderState.DELIVERED)
                .event(OrderEvent.DELIVER)
                .and()
                .withExternal()
                .source(OrderState.NEW).target(OrderState.CANCELLED)
                .event(OrderEvent.CANCEL)
                .and()
                .withExternal()
                .source(OrderState.PROCESSING).target(OrderState.CANCELLED)
                .event(OrderEvent.CANCEL)
                .and()
                .withExternal()
                .source(OrderState.SHIPPED).target(OrderState.CANCELLED)
                .event(OrderEvent.CANCEL)
                .and()
                .withExternal()
                .source(OrderState.DELIVERED).target(OrderState.CANCELLED)
                .event(OrderEvent.CANCEL);
    }
}