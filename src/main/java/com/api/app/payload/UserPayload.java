package com.api.app.payload;

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
public class UserPayload {
	private Long id;
	@NotEmpty(message = "First name is required")
	@Size(min = 3, max = 20, message = "First name should be between 3 and 20 characters")
	private String firstName;
	@NotEmpty(message = "Last name is required")
	@Size(min = 3, max = 20, message = "Last name should be between 3 and 20 characters")
	private String lastName;
	@Email(message = "Email should be valid")
	private String email;
}
