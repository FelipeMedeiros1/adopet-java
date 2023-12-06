package medeiros.felipe.adopet.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("medeiros.felipe.adopet.api")
public class AdopetApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdopetApiApplication.class, args);
	}

}
