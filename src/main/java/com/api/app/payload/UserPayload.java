package com.api.app.payload;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "UserDto Model Information")
public class UserPayload {
	private Long id;
	@NotEmpty(message = "User's first name should not be empty")
	@Size(min = 3, max = 20, message = "First name should be between 3 and 20 characters")
	private String firstName;
	@NotEmpty(message = "User's last name should not be empty")
	@Size(min = 3, max = 20, message = "Last name should be between 3 and 20 characters")
	private String lastName;
	@Email(message = "User's email address should be a valid email address")
	private String email;
}
