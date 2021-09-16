package org.mfp.poc.dealerlist;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class MfpPocDealerListApplication {
	
	static final Logger log =LoggerFactory.getLogger(MfpPocDealerListApplication.class);

	public static void main(String[] args) {
    
	     log.debug("Started Dealer List MS");
		 SpringApplication.run(MfpPocDealerListApplication.class, args);
	}

}
