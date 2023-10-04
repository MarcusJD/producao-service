package br.com.producaoservice.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMQDirectConfig {
	
    @Value("${mq.queues.create-pedido-producao}") 
    String createPedidoProducaoQueue;
	
    @Value("${mq.exchanges.pedido-producao-ex}") 
    String createPedidoProducaoExchange;
    
    @Value("${mq.keys.create-pedido-producao-key}") 
    String createPedidoProducaoKey;
	
	@Bean
	Queue createPedidoProducaoQueue() {
		return new Queue(createPedidoProducaoQueue, true);
	}

	@Bean
	DirectExchange createPedidoProducaoExchange() {
		return new DirectExchange(createPedidoProducaoExchange);
	}

	@Bean
	Binding adminBinding(Queue createPedidoProducaoQueue, DirectExchange createPedidoProducaoExchange) {
		return BindingBuilder.bind(createPedidoProducaoQueue)
				.to(createPedidoProducaoExchange)
				.with(createPedidoProducaoKey);
	}


}