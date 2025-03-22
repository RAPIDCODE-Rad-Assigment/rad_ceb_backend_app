package com.rapidcode.api;

import com.rapidcode.api.auth.AuthenticationService;
import com.rapidcode.api.auth.RegisterRequest;
import com.rapidcode.api.role.Permission;
import com.rapidcode.api.role.Role;
import com.rapidcode.api.role.RoleName;
import com.rapidcode.api.role.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.time.LocalDateTime;
import java.util.Set;

@EnableJpaAuditing
@EnableScheduling
@SpringBootApplication
public class ApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }

    @Bean
	public CommandLineRunner commandLineRunner(
			AuthenticationService service,
			RoleRepository roleRepository


	) {
		return args -> {
			initializeRoles(roleRepository);

			var admin = RegisterRequest.builder()
					.usersName("ceblk")
                    .email("cebadmin@example.com")
                    .address("Colombo")
                    .phoneNumber("0771234567")
                    .fullName("CEB Admin")
                    .password("password")
					.build();

			System.out.println("Admin token: " + service.registerAdmin(admin).getAccessToken());



		};
	}


    private void initializeRoles(RoleRepository roleRepository) {
        // Check if roles exist, and if not, initialize them
        if (roleRepository.findByName(RoleName.USER.name()).isEmpty()) {
            Role userRole = Role.builder()
                    .name(RoleName.USER.name())
                    .permissions(Set.of(
                            Permission.USER_READ, Permission.USER_UPDATE, Permission.USER_DELETE, Permission.USER_CREATE,
                            Permission.METER_READER_READ, Permission.METER_READER_CREATE, Permission.METER_READER_UPDATE, Permission.METER_READER_DELETE,
                            Permission.METER_READ, Permission.METER_CREATE, Permission.METER_UPDATE, Permission.METER_DELETE,
                            Permission.BILL_READ, Permission.BILL_CREATE, Permission.BILL_UPDATE, Permission.BILL_DELETE
                    ))
                    .createdDate(LocalDateTime.now()) // Set createdDate here
                    .build();
            roleRepository.save(userRole);
        }

        if (roleRepository.findByName(RoleName.ADMIN.name()).isEmpty()) {
            Role adminRole = Role.builder()
                    .name(RoleName.ADMIN.name())
                    .permissions(Set.of(
                            Permission.ADMIN_READ, Permission.ADMIN_UPDATE, Permission.ADMIN_DELETE, Permission.ADMIN_CREATE,
                            Permission.USER_READ, Permission.USER_UPDATE, Permission.USER_DELETE, Permission.USER_CREATE,
                            Permission.METER_READER_READ, Permission.METER_READER_CREATE, Permission.METER_READER_UPDATE, Permission.METER_READER_DELETE,
                            Permission.METER_READ, Permission.METER_CREATE, Permission.METER_UPDATE, Permission.METER_DELETE,
                            Permission.BILL_READ, Permission.BILL_CREATE, Permission.BILL_UPDATE, Permission.BILL_DELETE
                    ))
                    .createdDate(LocalDateTime.now()) // Set createdDate here
                    .build();
            roleRepository.save(adminRole);
        }
    }

}
