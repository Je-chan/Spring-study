# AOP
## AOP (Aspect Oriented Programming)

### 1. 관점지향 프로그래밍
- 스프링은 대부분의 경우 MVC 를 채택한다
- MVC 는 다음 세 단계로 나뉜다
  - Web Layer: REST API 제공. Client 중심 로직
  - Business Layer : 내부 정책에 따른 Logic 개발. 서비스를 개발할 때 주로 사용
  - Data Layer : DB 및 외부와의 연동을 처리

- 횡단 관심
  - 메소드들, 특정 구역에 반복되는 로직들을 한 곳에 모아서 사용한다

### 2. 주요 Annotation
- @Aspect : 자바에서 널리 사용하는 AOP 프레임워크. AOP 를 정의하는 Class 에 할당
- @Pointcut : AOP 를 적용할 지점을 설정
- @Before : 메소드를 실행하기 이전
- @After : 메소드가 성공적으로 실행한 후, 예외가 발생하더라도 실행
- @AfterReturning : 메소드 호출 성공 실행 시 (Not Throws)
- @AfterThrowing : 메소드 호출 실패 예외 발생 (Throws)
- @Around : Before / After 모두 제어