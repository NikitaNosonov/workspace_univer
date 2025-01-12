package dev.vorstu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "dev.vorstu")
public class VorstuApplication {

	private static InitializerService initializerService;

	@Autowired
	public void setInitialLoader(InitializerService initializerService) {
		VorstuApplication.initializerService = initializerService;
	}

	public static void main(String[] args) {
		SpringApplication.run(VorstuApplication.class, args);
		initializerService.initial();
	}
}
