package com.mykhailo_pavliuk.smart_cookie.test.util;

import com.mykhailo_pavliuk.smart_cookie.dto.RoleDto;
import com.mykhailo_pavliuk.smart_cookie.dto.UserDetailDto;
import com.mykhailo_pavliuk.smart_cookie.dto.UserDto;
import com.mykhailo_pavliuk.smart_cookie.dto.UserStatusDto;
import com.mykhailo_pavliuk.smart_cookie.model.Role;
import com.mykhailo_pavliuk.smart_cookie.model.User;
import com.mykhailo_pavliuk.smart_cookie.model.UserDetail;
import com.mykhailo_pavliuk.smart_cookie.model.UserStatus;
import java.math.BigDecimal;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserTestDataUtil {

  public static final Long ID = 1L;
  public static final String FIRST_NAME = "Mykhailo";
  public static final String LAST_NAME = "Pavliuk";
  public static final BigDecimal BALANCE = BigDecimal.ZERO;
  public static final String EMAIL = "mike@gmail.com";
  public static final String PASSWORD = "Mike12345!";

  public static final UserStatus USER_STATUS = createActiveStatus();
  public static final Role ROLE = createSubscriberRole();

  public static User createUser() {
    return User.builder()
        .id(ID)
        .email(EMAIL)
        .password(PASSWORD)
        .userDetail(
            UserDetail.builder()
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .balance(BigDecimal.ZERO)
                .build())
        .role(ROLE)
        .status(USER_STATUS)
        .build();
  }

  public static UserDto creatUserDto() {
    return UserDto.builder()
        .id(ID)
        .email(EMAIL)
        .password(PASSWORD)
        .userDetail(UserDetailDto.builder().firstName(FIRST_NAME).lastName(LAST_NAME).build())
        .build();
  }

  private static Role createSubscriberRole() {
    return Role.builder().id(1L).name(RoleDto.SUBSCRIBER.name().toLowerCase()).build();
  }

  private static UserStatus createActiveStatus() {
    return UserStatus.builder().id(1L).name(UserStatusDto.ACTIVE.name().toLowerCase()).build();
  }

  public static UserDto createValidUserDto() {
    UserDto user = creatUserDto();
    user.getUserDetail().setId(1L);
    user.setRole(createSubscriberRole());
    user.setStatus(createActiveStatus());

    return user;
  }
}
