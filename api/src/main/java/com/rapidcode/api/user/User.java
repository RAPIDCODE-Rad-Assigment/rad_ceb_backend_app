package com.rapidcode.api.user;

import com.rapidcode.api.area.Area;
import com.rapidcode.api.role.Role;
import com.rapidcode.api.token.Token;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Entity
@Table(name = "_user")
public class User implements UserDetails, Principal {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String usersName;

    @Column(name = "full_name")
    private String fullName;

    @Column(unique = true)
    private String email;

    private String password;

    private String profile_image_url;

    private boolean accountLocked;

    private String address;
    private String phoneNumber;

    private boolean enabled;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> roles;

    @OneToMany(mappedBy = "user")
    private List<Token> tokens;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate
    @Column(insertable = false)
    private LocalDateTime lastModifiedDate;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_assigned_areas",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "area_id")
    )
    private List<Area> assignedAreas;

    public User() {
    }

    public User(UUID id, String usersName, String fullName, String email, String password, String profile_image_url, boolean accountLocked, String phoneNumber, String address, boolean enabled, List<Role> roles, List<Token> tokens, LocalDateTime lastModifiedDate, LocalDateTime createdDate, List<Area> assignedAreas) {
        this.id = id;
        this.usersName = usersName;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.profile_image_url = profile_image_url;
        this.accountLocked = accountLocked;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.enabled = enabled;
        this.roles = roles;
        this.tokens = tokens;
        this.lastModifiedDate = lastModifiedDate;
        this.createdDate = createdDate;
        this.assignedAreas = assignedAreas;
    }

    // Getters and Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUsersName() {
        return usersName;
    }

    public void setUsersName(String usersName) {
        this.usersName = usersName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfile_image_url() {
        return profile_image_url;
    }

    public void setProfile_image_url(String profile_image_url) {
        this.profile_image_url = profile_image_url;
    }

    public boolean isAccountLocked() {
        return accountLocked;
    }

    public void setAccountLocked(boolean accountLocked) {
        this.accountLocked = accountLocked;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<Area> getAssignedAreas() {
        return assignedAreas;
    }

    public void setAssignedAreas(List<Area> assignedAreas) {
        this.assignedAreas = assignedAreas;
    }

    public List<Token> getTokens() {
        return tokens;
    }

    public void setTokens(List<Token> tokens) {
        this.tokens = tokens;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    // UserDetails methods
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream()
                .flatMap(role -> role.getAuthorities().stream())
                .collect(Collectors.toSet());
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !accountLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // Principal method
    @Override
    public String getName() {
        return email;
    }

    // toString method
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", usersName='" + usersName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", profile_image_url='" + profile_image_url + '\'' +
                ", accountLocked=" + accountLocked +
                ", enabled=" + enabled +
                ", roles=" + roles +
                ", tokens=" + tokens +
                ", createdDate=" + createdDate +
                ", lastModifiedDate=" + lastModifiedDate +
                '}';
    }

    // Builder pattern
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private UUID id;
        private String usersName;
        private String email;
        private String password;
        private String profile_image_url;
        private String fullName;
        private String address;
        private String phoneNumber;
        private List<Area> assignedAreas;
        private boolean accountLocked;
        private boolean enabled;
        private List<Role> roles;
        private List<Token> tokens;
        private LocalDateTime createdDate;
        private LocalDateTime lastModifiedDate;

        public Builder id(UUID id) {
            this.id = id;
            return this;
        }

        public Builder usersName(String usersName) {
            this.usersName = usersName;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder profile_image_url(String profile_image_url) {
            this.profile_image_url = profile_image_url;
            return this;
        }

        public Builder accountLocked(boolean accountLocked) {
            this.accountLocked = accountLocked;
            return this;
        }

        public Builder enabled(boolean enabled) {
            this.enabled = enabled;
            return this;
        }

        public Builder roles(List<Role> roles) {
            this.roles = roles;
            return this;
        }

        public Builder tokens(List<Token> tokens) {
            this.tokens = tokens;
            return this;
        }

        public Builder createdDate(LocalDateTime createdDate) {
            this.createdDate = createdDate;
            return this;
        }

        public Builder lastModifiedDate(LocalDateTime lastModifiedDate) {
            this.lastModifiedDate = lastModifiedDate;
            return this;
        }

        public Builder fullName(String fullName) {
            this.fullName = fullName;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder assignedAreas(List<Area> assignedAreas) {
            this.assignedAreas = assignedAreas;
            return this;
        }

        public User build() {
            return new User(
                    id,
                    usersName,
                    fullName,
                    email,
                    password,
                    profile_image_url,
                    accountLocked,
                    phoneNumber,
                    address,
                    enabled,
                    roles,
                    tokens,
                    lastModifiedDate,
                    createdDate,
                    assignedAreas
            );
        }

    }
}