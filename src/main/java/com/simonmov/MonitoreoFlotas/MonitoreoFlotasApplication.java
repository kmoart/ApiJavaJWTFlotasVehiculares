package com.simonmov.MonitoreoFlotas;

import com.simonmov.MonitoreoFlotas.domain.Role;
import com.simonmov.MonitoreoFlotas.domain.User;
import com.simonmov.MonitoreoFlotas.domain.Vehiculo;
import com.simonmov.MonitoreoFlotas.enums.RoleList;
import com.simonmov.MonitoreoFlotas.repository.RoleRepository;
import com.simonmov.MonitoreoFlotas.repository.UserRepository;
import com.simonmov.MonitoreoFlotas.repository.VehiculoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MonitoreoFlotasApplication {

	public static void main(String[] args) {
		SpringApplication.run(MonitoreoFlotasApplication.class, args);
	}
  /*
	@Bean
	CommandLineRunner commandLineRunner(
			VehiculoRepository vehiculoRepository,
			UserRepository userRepository){
		return args -> {
			User user1 = userRepository.save(new User(
					null,
					"1345987",
					"Manuel",
					"12345"
			));
			Vehiculo vehiculo = vehiculoRepository.save(new Vehiculo(
					null,
					"JDF899",
					24.5F,
					50.3F,
					1.5F,
					15.0F,
					user1));
		};
	}*/

}
