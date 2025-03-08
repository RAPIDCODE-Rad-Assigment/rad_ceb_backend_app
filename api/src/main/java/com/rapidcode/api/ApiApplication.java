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

import java.time.LocalDateTime;
import java.util.Set;

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
					.usersName("DanumaLK")
                    .email("danuma@example.com")
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
                            Permission.POST_READ, Permission.POST_CREATE, Permission.POST_UPDATE, Permission.POST_DELETE,
                            Permission.COMMENT_READ, Permission.COMMENT_CREATE, Permission.COMMENT_UPDATE, Permission.COMMENT_DELETE,
                            Permission.REACTION_READ, Permission.REACTION_CREATE, Permission.REACTION_UPDATE, Permission.REACTION_DELETE
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
                            Permission.POST_READ, Permission.POST_CREATE, Permission.POST_UPDATE, Permission.POST_DELETE,
                            Permission.COMMENT_READ, Permission.COMMENT_CREATE, Permission.COMMENT_UPDATE, Permission.COMMENT_DELETE,
                            Permission.REACTION_READ, Permission.REACTION_CREATE, Permission.REACTION_UPDATE, Permission.REACTION_DELETE
                    ))
                    .createdDate(LocalDateTime.now()) // Set createdDate here
                    .build();
            roleRepository.save(adminRole);
        }
    }

}
