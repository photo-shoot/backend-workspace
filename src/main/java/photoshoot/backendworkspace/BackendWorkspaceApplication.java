package photoshoot.backendworkspace;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@PropertySource("classpath:env.properties")
public class BackendWorkspaceApplication {
	public static void main(String[] args) {
		SpringApplication.run(BackendWorkspaceApplication.class, args);
	}
}
