# SPRING ADVANCED

### 1. 코드 리펙토링
- 'valid 리팩토링' : svc 메서드의 부분을 DTO에서 처리할수 있도록 리팩토

### 2. N+1 문제
- 클래스 전체에 적용 되는 메타데이터에 대한 이해 부족으로 고생(JPA 규칙)
- @EntityGraph(attributePaths = "user") 개별 조회하면 문제 발생하므로 함께 조

### 3. TestCode
- 인자 값 반대로 된 코드 수정후 success
- Optional.empty()를 반환하는 경우 InvalidRequestException을 던지는지 검증해야함.
- severException -> InvalidRequestException: comment Sevice 비지니스 로직인 findbyId가 예외를 후자로 던짐

### 4. 🛠️ 인터셉터(`AdminAccessInterceptor`)를 통한 접근 로깅
- `preHandle()`에서 관리자 인증을 수행하고, 접근 로그 기록
- 요청 URL, 요청 시간, 사용자 ID 등을 `logger.info`로 기록
- `postHandle()`에서 응답 본문 로깅 처리
