## 유효성 검사
1. 엔티티의 멤버 관련 DTO에 어노테이션 사용 : @NotNull, @Size, @Pattern
   * 예시
     * @Size(min=1, max=255, message="주소는 1자 이상 255자 이하로 입력해주세요")
     * @Pattern(regexp="010-\\d{4}-\\d{4}", message = "전화번호 형식은 010-xxxx-xxxx 입니다.")
     * @NotNull(message ="아이디는 필수입니다")
2. 컨트롤러 계층 DTO 매개변수 위치에 @Valid 추가
   * 이게 있어야 검사를 함
   * 500 서버 에러에서 400 bad request로 바뀜

## 예외처리 소개
1. Global Exception Handler
   * 공통 예외 처리 핸들러
   * 에러 정보 반환용 DTO
   * AOP(관점 지향 프로그래밍)
2. 커스텀 예외 처리
   * 커스텀 예외 클래스. RuntimeException을 상속한
   * Global Exception Handler에 등록 -> 에러 원인을 명확일 알 수 있음
3. 에러 메시지 클래스
   * 예외 메시지 문자열 중복 사용됨 -> 추가/ 수정하기 힘들다
   * 따라서 상수로 정의
   * 예시)  throw new NotFoundExceoption(ErrorMessage.MEMBER_NOT_FOUND);

## 예외 처리 : Global Exception Handler (전역 예외 핸들러)
  * 스프링에서 제공
  * 예외 종류에 따라 response를 설정 가능
  * Global Exception을 처리 = 스프링 애플리케이션 전역의 모든 에러 처리 방법을 결정
  * @ExceptionHandler(A.class)
    * A 타입 에러를 다루는 핸들러가 Controller 메서드 대신 ResponseBody를 생성 & 응답
    * Exception.class 일 경우 : 모든 에러 클래스의 공통부모. 
                 특정 핸들러에서 처리하지 못한 모든 오류를 처리하는 핸들러(500서버 에러)
  * @ControllerAdvice
    * 모든 컨트롤러에서 발생하는 예외를 중앙에서 처리
    * 모든 컨트롤러의 공통 관심사(에러 처리)를 별도의 클래스로 구분하여 구현
* AOP(Aspect-Oriented Programing): 관점지향 프로그래밍
  * 부가 기능을 모듈화
  * 여러 클래스에 걸쳐 반복되는 공통 기능을 분리
  * 예: 로깅, 트랜잭션, 보안, 예외처리 등

## 에외처리 : 커스텀 예외 처리
  * 커스텀 예외 클래스 생성, RuntimeException 상속
  * 커스텀 예외처리 핸들러 생성(global exception handler에서)

## 예외처리 : API 문서화
  * 특징
    * API 사용 설명서 공유
    * 백엔드 API 명세를 문서로 공유
    * 클라이언트(프론트엔드)와 소통/협업 시 API 문서를 공유
  * 문서화 도구 Swagger 사용
    1. spring doc 사용 -> OpenAPI(API 표준 명세) 규격의 API 문서 생성
    2. Swagger UI 사용 -> API 문서에 Swagger 디자인 적용
    3. http/localhost:8080//swagger-ui/index.html 로 접속하면 보임
  * API 문서화 작업 위한 어노테이션
    * @Tag(name, description) : API 그룹화(컨트롤러 레벨 -> 컨트롤러클래스에 추가)
    * @Operation(summary, description) : API 요약과 설명(메서드 레벨)
    * @ApiResponse(responseCode, description) : 400, 500 등 단일 응답코드 설명(메서드 레벨)


## 리팩토링
  * 외부 동작은 유지, 내부 구조만 개선