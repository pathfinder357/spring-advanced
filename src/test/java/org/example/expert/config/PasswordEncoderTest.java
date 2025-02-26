package org.example.expert.config;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class PasswordEncoderTest {

    @Mock
    private PasswordEncoder passwordEncoder;

    @Test
    // 로그출력이 보고 싶었다...
    @DisplayName("matches 메서드 테스트 - rawPassword: testPassword")
    void matches_메서드가_정상적으로_동작한다() {
        // given
        String rawPassword = "testPassword";
        String encodedPassword = passwordEncoder.encode(rawPassword);

        // 모의 객체 동작 정의
        when(passwordEncoder.matches(rawPassword, encodedPassword)).thenReturn(true);
        // when(인자값이 반대로 돼어있다->수정)
        boolean matches = passwordEncoder.matches(rawPassword, encodedPassword);

        // then
        assertTrue(matches);

        // verify()
        verify(passwordEncoder).matches(rawPassword, encodedPassword);
    }
}
