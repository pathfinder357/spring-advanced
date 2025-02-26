package org.example.expert.domain.user.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserChangePasswordRequest {
    // Service에서 ChangePasswd 메서드를 DTO에서 처리
    @NotBlank(message = "기존 비밀번호를 입력해주세요.")
    private String oldPassword;
    @NotBlank(message = "새 비밀번호를 입력해주세요.")
    @Size(min = 8, message = "새 비밀번호는 8자 이상이어야 합니다.")
    @Pattern(regexp = ".*\\d.*", message = "새 비밀번호는 숫자를 포함해야 합니다. ")
    @Pattern(regexp = ".*[A-Z].*", message = "새 비밀번호는 대문자를 포함해야 합니다.")
    private String newPassword;
}
