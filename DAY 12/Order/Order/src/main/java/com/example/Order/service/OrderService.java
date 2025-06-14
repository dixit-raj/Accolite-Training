package com.example.Order.service;

import com.example.Order.exception.InvalidStateTransitionException;
import com.example.Order.models.Order;
import com.example.Order.models.OrderEvent;
import com.example.Order.models.OrderState;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineFactory;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final StateMachineFactory<OrderState, OrderEvent> stateMachineFactory;

    public OrderService(StateMachineFactory<OrderState, OrderEvent> stateMachineFactory) {
        this.stateMachineFactory = stateMachineFactory;
    }

    public Order createOrder(String description) {
        Order order = new Order();
        order.setDescription(description);
        order.setState(OrderState.NEW);
        return order;
    }

    public void processEvent(Order order, OrderEvent event) {
        StateMachine<OrderState, OrderEvent> sm = stateMachineFactory.getStateMachine();
        sm.getExtendedState().getVariables().put("order", order);

        if (!sm.sendEvent(event)) {
            throw new InvalidStateTransitionException(
                    "Invalid event '" + event + "' for current state '" + order.getState() + "'"
            );
        }
        order.setState(sm.getState().getId());
    }
}
