package com.mykhailo_pavliuk.smart_cookie.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@Builder
public class User {

	private Integer id;

	private String email;

	@ToString.Exclude
	private String password;

	private UserDetail userDetail;

	private Status status;

	private Role role;

	private List<Subscription> subscriptions;
}
