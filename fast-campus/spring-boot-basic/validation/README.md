# Validation
## 1. Validation 이란?
- validation 은 프로그래밍에서 중요한 부분
- 특히 Java 에서 Null 값에 대해 접근하고자 할 때, Null Pointer Exception 이 발생하므로, 이런 에러를 방지하기 위해 미리 검증하는 과정을 Validation 이라고 한다

```java
public void run(String account, String pw, int tall) {
    if(account == null || pw == null) { 
        return
    }
    if(tall == 0) {
        return 
    }

    // 정상일 때의 Logic 을 아래에 구현
}
```

- 검증해야 할 값이 많은 경우 코드의 길이가 길어진다.
- Service Logic 과의 분리가 필요하다
- 흩어져 있는 경우, 어디에서 검증하는지 알기 어렵고, 재사용의 한계가 있다.
- 검증 Logic 이 변경되는 경우 테스트 코드 등 참조하는 클래스에서 Logic 이 변경돼야 할 수도 있다

## 2. Validation 을 위한 Annotation
| Annotation        | Meaning                 |
|-------------------|-------------------------|
| @Size             | 문자 길이 측정 (Int 타입 불가능)   |
| @NotNull          | null 불가능                |
| @NotEmpty         | null, "" 불가능            |
| @NotBlank         | Null, "", " " 불가능       |
| @Past             | 과거날짜                    |
| @PastOrPresent    | 오늘이거나 과거 날짜             |
| @Future           | 미래날짜                    |
| @FutureOrPresent  | 오늘이거나 미래 날짜             |
| @Pattern          | 정규식 적용                  |
| @Max              | 최댓값                     |        
| @Min              | 최솟값                     |
| @AssertTrue/False | 별도 Logic 적용             |
| @Valid            | 해당 Object Validation 실행 |

## 3. Validation Setup
- Gradle dependencies
  - implementation("org.springframework.boot:spring-boot-starter-validation")
