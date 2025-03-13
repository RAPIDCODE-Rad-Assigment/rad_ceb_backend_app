package com.rapidcode.api.user;

import com.rapidcode.api.common.PageResponse;
import jakarta.mail.MessagingException;
import org.springframework.security.core.userdetails.UserDetails;

import java.security.Principal;
import java.util.UUID;

public interface UserServiceInterface {
    void changePassword(ChangePasswordRequest request, Principal connectedUser);
    void disableUser(UserStatusChangeRequest disableUserRequest) throws MessagingException;
    UserResponse updateUserProfile(UUID id, UserRequest editUserRequest) ;
    UserResponse getCurrentUser(UserDetails userDetails);
    PageResponse<UserResponse> getAllUsersForAdmin(int page, int size);
    void deleteUser(UUID id, UserDetails userDetails);

}
