package br.com.producaoservice.infra.mqueue;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import br.com.producaoservice.infra.mqueue.model.PedidoProducaoMQ;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PedidoProducaoPublisher {
	
	private final RabbitTemplate rabbitTemplate;
	
    @Value("${mq.exchanges.pedido-producao-ex}") 
    String createPedidoProducaoExchange;
    
    @Value("${mq.keys.create-pedido-producao-key}") 
    String createPedidoProducaoKey;
	
	public ResponseEntity<Void> publishPedidoProducao(PedidoProducaoMQ pedidoProducao) {
		HttpStatus status = (HttpStatus) rabbitTemplate.convertSendAndReceive(createPedidoProducaoExchange, 
				createPedidoProducaoKey, pedidoProducao);
		return new ResponseEntity<Void>(status);
	}
}
