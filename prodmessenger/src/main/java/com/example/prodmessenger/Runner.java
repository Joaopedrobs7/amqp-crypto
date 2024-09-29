package com.example.prodmessenger;

import java.util.Scanner;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {

    private final RabbitTemplate rabbitTemplate;
    private final ConfigurableApplicationContext context;

    public Runner(RabbitTemplate rabbitTemplate,
                  ConfigurableApplicationContext context) {
        this.rabbitTemplate = rabbitTemplate;
        this.context = context;
    }

    @Override
    public void run(String... args) throws Exception {
    	Scanner ler = new Scanner(System.in);
        String msg1 = " [Perfil Baixo risco] $BTC +2.5% = $63,611";
        String msg2 = "[Perfil Medio risco] $DOT +5.0% = $4.92";
        String msg3 = "[Perfil Alto risco] $XRD -10.0% = $0.02049";
    	int choice;
    	String routingKey = "";
    	while(true) {
    		//pra onde vai
    		
    		System.out.println("1-[BAIXO]\n2-[MEDIO]\n3-[AlTO]\n");
    		//System.out.println("Digite a mensagem:");
   		    String msg = "";
   		    //msg = ler.nextLine(); 
   		    choice = ler.nextInt();
   		    
   		    if(choice == 1) {
   		    	routingKey = ProdApplication.routingKeyLow;
   		    	msg = msg1;
   		    }
   		    else if(choice == 2) {
   		    	routingKey = ProdApplication.routingKeyMid;
   		    	msg = msg2;
   		    }
   		    else if (choice == 3) {
   		    	routingKey = ProdApplication.routingKeyHigh;
   		    	msg = msg3;
   		    }
   		    
   		    
   		    if(msg.contains("sair"))
   		    	break;
   		    

    		//rabbitTemplate.convertAndSend(ProdApplication.directExchangeName, ProdApplication.routingKey, msg);
   		    rabbitTemplate.convertAndSend(ProdApplication.topicExchangeName, routingKey, msg);
   		    

    	}
        context.close();
    }

}
