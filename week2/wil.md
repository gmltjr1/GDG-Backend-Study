### 1. 스프링 계층형 아키텍쳐(Layered Architecture)

    browser <-DTO-> controller <-DTO-> service <-DTO-> DAO <-Entity(Domain)-> DB

* browser(frontend) = 손님
* controller = 웨이터
  * browser와 소통
  * 비즈니스 로직x
* service = 주방장
  * 비즈니스 로직 알음
  * 재료가 없음
* DAO(Data Access Object) = 창고 관리인
  * 데이터 위치 알음
  * 정리와 출고
* DB = 창고

- DTO = 주문선, 영수증
    - 데이터 전송 객체
    - 소통 목적에 맞는, 필요한 정보만 전달
- Entity(domain) = 원재료
    - DB 테이블과 맵핑되는 핵심 객체
    - 외부 직접 노출 금지

### 2. Controller Layer
* 패키지 구조
  * controller, service, repository, domain, dto, exception, config  
  * 계층형
    * 애플리케이션 기능별로 나눈다.
    * controller는 controller에, service는 service에
  * 도메인형
    * 도메인 관련 모든 클래스를 포함 -> 코드 탐색 easy
    * 도메인 단위 개발, 유지보수하기 용이
    * 새로운 도메인 추가시 다른 곳에 영향 없음
* 참고)ResponseEntity의 메서드
  - ok().build()
  - ok(data)
  - created(url).build()
  - noContent().build()
### 3. Service Layer
* 비즈니스 로직
  * ex) member 데이터 수정
    1. member를 조회
    2. member 데이터 수정
* requset 3개중 하나가 오류여도 셋다 실행 or 셋다 실행 안함 -> 원자성을 가진다

### 4. 스프링 빈 & 의존성 주입
* Spring Container
  * 스프링 빈 저장소
  * 어플리케이견 컨텍스트 != 영속성 컨텍스트
* 스프링 빈
  * 어플리케이션 전역에서 사용할 공용 객체
  * 스프링 컨테이너(공용창고)에 빈을 저장, 필요한 빈을 컨테이너에서 받아 사용한다.
  * 필요한 빈은 스프링 프레임워크가 자동으로 가져다 준다.
  * 빈을 요구하는 객체 역시 스프링 빈이다.
* 빈 등록방법
  * 설정 파일 작성 (수동 등록)
  * 컴포넌트 스캔 (자동 등록)
    * @ComponentScan
      * 어떤 클래스들이 Spring Bean인지 찾아서 등록
      * @SpringBootApplication에 포함된
    * @component
      * @Controller, @Service, @Repository, @Entity 등에 포함됨
      * 이 클래스가 Spring Bean이야 라고 표기
    * @controller, @RestController, @Service, @Repository, @SpringBootApplication, ...
* 의존성 주입
  * 내가 의존하는 객체를 직접생성하지 않고 밖(스프링 컨테이너)에서 주입 받는 것
  * 생성해둔 객체를 사용 -> 메모리를 효율적으로 사용
* 의존성 주입 방법
  * ~~필드주입~~
  * ~~수정자 주입~~
  * 생성자 주입
    * 안전하게 final로 선언(controller는 service를, service는 repository를)
    * 생성자에 @Autowired를 사용하면, 생성자를 통해 빈을 주입한다.
    * 만약 생성자가 하나만 있다면 @Autowired 생략 가능
  * 생성자 주입(간단ver)
    * 필요한 의존성을 final 키워드를 사용해 추가.
    * @REquiredArgsConstructor를 사용해 생성자를 추가