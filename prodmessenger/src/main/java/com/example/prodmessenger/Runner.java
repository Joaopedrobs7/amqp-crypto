package com.example.prodmessenger;

import java.util.Scanner;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;
import java.util.*;
import java.util.Random;

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
    	Random rand = new Random();
    	List<String> msg1 = Arrays.asList(
    			"[Perfil Baixo risco] $BTC +2.5% = $63,611",
    			"[Perfil Baixo risco] $ETH +5.0% = $2,811",
    			"[Perfil Baixo risco] $SOL +4.2% = $157.0",
    			"[Perfil Baixo risco] $BTC -2.0% = $61,740",
    			"[Perfil Baixo risco] $ETH -6.2% = $2,626",
    			"[Perfil Baixo risco] $ETH +8.0% = $2,961",
    			"[Perfil Baixo risco] $SOL -7.2% = $149.0",
    			"[Perfil Baixo risco] $BTC +3.21% = $65,740");
    	List<String> msg2 = Arrays.asList(
    			"[Perfil Medio risco] $DOT -1.21% = $4.74",
    			"[Perfil Medio risco] $LINK -3.64% = $12.35",
    			"[Perfil Medio risco] $ADA -1.48% = $0.393",
    			"[Perfil Medio risco] $XRP +5.66% = $0.6449",
    			"[Perfil Medio risco] $DOGE -3.31% = $0.1235",
    			"[Perfil Medio risco] $DOT -10.21% = $3.94",
    			"[Perfil Medio risco] $LINK +3.54% = $13.42",
    			"[Perfil Medio risco] $ADA +4.11% = $0.406");
    	List<String> msg3 = Arrays.asList(
    			"[Perfil Alto risco] $XMR -3.30% = $152.81",
    			"[Perfil Alto risco] $FTT +65.49% = $2.31",
    			"[Perfil Alto risco] $XRD -4.28% = $0.02045",
    			"[Perfil Alto risco] $KSM -1.03% = $21.63",
    			"[Perfil Alto risco] $PENDLE -2.33% = $4.31",
    			"[Perfil Alto risco] $FTT -35.49% = $1.495",
    			"[Perfil Alto risco] $PENDLE -12.33% = $3.79",
    			"[Perfil Alto risco] $XMR +10.30% = $167.2");
    	 
    	int choice;
    	String routingKey = "";
    	while(true) {
    		System.out.println("1-[BAIXO]\n2-[MEDIO]\n3-[AlTO]\n");
    		//System.out.println("Digite a mensagem:");
   		    String msg = "";
   		    //msg = ler.nextLine(); 
   		    choice = ler.nextInt();
   		    
   		    if(choice == 1) {
   		    	routingKey = ProdApplication.routingKeyLow;
   		    	msg = msg1.get(rand.nextInt(msg1.size()));
   		    }
   		    else if(choice == 2) {
   		    	routingKey = ProdApplication.routingKeyMid;
   		    	msg = msg2.get(rand.nextInt(msg2.size()));
   		    }
   		    else if (choice == 3) {
   		    	routingKey = ProdApplication.routingKeyHigh;
   		    	msg = msg3.get(rand.nextInt(msg3.size()));
   		    }
   		    
   		    
   		    if(msg.contains("sair"))
   		    	break;
   		    

    		//rabbitTemplate.convertAndSend(ProdApplication.directExchangeName, ProdApplication.routingKey, msg);
   		    rabbitTemplate.convertAndSend(ProdApplication.topicExchangeName, routingKey, msg);
   		    

    	}
        context.close();
    }

}
