# 1. IoC (Inversion of Control)
## 1-1 IoC(제어의 역전)란?
- 스프링에서는 일반적인 자바 객체를 new 로 생성해서 개발자가 관리하는 것이 아니라 Spring Container 에 모두 맡긴다
- 개발자에서 프레임 워크로 모든 객체 관리의 권한이 넘어가 제어의 역전이라고 부른다.
- 다른 프레임워크에서는 없는 특징

## 1-2 DI(Dependency Injection)
- 외부로부터 내가 사용할 객체를 주입받는다.
- 주입해주는 애가 스프링 컨테이너
- 장점
  - 클래스간의 의존성을 격리시켜서 코드 테스트에 용이하도록 만든다
  - DI 를 통해 Mocking 이 가능하다. (배포하지 않으면 테스트가 불가능한 상황이 있었다)
  - 코드를 확장하거나 변경할 때 영향을 최소화한다. (내가 필요한 객체를 외부로부터 주입받기 때문). 추상화가 강화된다
  - 외부에서 주입을 받으면 순환 참조를 막을 수 있다. (내가 나를 참조하거나 내가 참조한 객체가 돌고 돌아 나를 참조하는 현상)


# Spring Annotation

|       Annotation       |                                             의미                                             |
|:----------------------:|:------------------------------------------------------------------------------------------:|
|       Annotation       |                                             의미                                             |
| @SpringBootApplication |                               Spring boot Application 으로 설정                                |
|      @Controller       |                   View 를 제공하는 Controller. Response의 형태가 기본적으로 HTML 의 형태                    |
|    @RestController     |                   Rest API 를 제공하는 Controller. 기본적으로 Response 는 JSON 의 형태                   |
|    @RequestMapping     |                                         URL 주소를 매핑                                         |
|      @GetMapping       |                                  HTTP GET 메소드 URL 주소를 매핑                                   |
|      @PostMapping      |                                  HTTP POST 메소드 URL 주소를 매핑                                  |
|      @PutMapping       |                                  HTTP PUT 메소드 URL 주소를 매핑                                   |
|     @DeleteMapping     |                                   HTTP Delete URL 주소를 매핑                                   |
|     @RequestParam      |                                  URL 에서 Query(?) 파라미터 매핑                                   |
|      @RequestBody      |                           HTTP Body 에 들어오는 값을 Object 로 매핑할 때 사용                            |
|         @Valid         |                                  POJO Java class 검증할 때 사용                                  |
|     @Configuration     |                             1개 이상의 Bean 을 등록하거나 스프링에 설정을 넣어줄 때                             |
|       @Component       |                               1개의 클래스 단위로 등록할 때 클래스 위에 달아준다                                |
|         @Bean          | 1개의 외부 라이브러에서 생성한 객체를 Bean 에 등록할 때 사용. 클래스 단위가 아니라 직접 new 라는 객체로 사용한 다음에 Bean 으로 등록하거나 메소드 |
|       @Autowired       |                                       DI 를 위한 곳에 사용                                        |
|       @Qualifier       |                         @Autowired 사용할 때, Bean 이 두 개 이상이면 명시적으로 사용                         |
|       @Resource        |                                  @Autowired + @Qualifier                                   |
|        @Aspect         |                                        AOP 적용할 때 사용                                        |
|        @Before         |                                  AOP 메소드 실행 이전에 호출할 것을 지정                                  |
|         @After         |                             AOP 메소드 실행 이후에 호출할 것(예외 발생 포함) 지정                              |
|        @Around         |                             AOP 메소드 실행 이전, 이후 모두 포함(예외 발생 포함)                              |
|    @AfterReturning     |                                   AOP 메소드의 호출이 정상일 때 실행                                    |
|     @AfterThrowing     |                                 AOP 시 해당 메소드가 예외 발생할 때를 지                                  |
