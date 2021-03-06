# 06. 스프링 MVC - 기본 기능

### 02. 로깅 간단히 알아보기

**로깅 라이브러리**<br>
스프링 부트 라이브러리를 사용하면 `spring-boot-starter-logging`가 함께 포함된다.<br>
스프링 부트 로깅 라이브러리는 기본으로 아래 라이브러리를 사용한다.<br>

- SLF4J - http://www.sl4j.org
- Logback - http://logback.qos.ch

로그 라이브러리는 Logback, Log4J, Log4J2 등 수 많은 라이브러리가 있는데, 그것을 통합해서 인터페이스로 제공하는 것이 SLF4J 라이브러리다.

**로그 레벨**<br>
TRACE > DEBUG > INFO > WARN > ERROR

**로그 사용시 장점**<br>
- 쓰레드 정보, 클래스 이름 같은 부가 정보를 함께 출력 할 수 있그 출력 포멧도 조정할 수 있다.
- 각 environment 환경마다 로그 레벨을 설정하여 출력 가능하다.
- 파일이나 네트워크 등 로그를 별도의 위치에 남길 수 있고 파일마다 일별, 용량, 등 로그 분할도 가능하다. (간단한 설정으로)
- 성능도 System.out 보다 좋다.

### 09. HTTP 요청 메시지 - 단순 텍스트

**HTTP message body에 데이터를 직접 담아서 호출**

- HTTP API 에서 주로 사용, JSON, XML, TEXT
- 데이터 형식은 주로 JSON 사용
- POST, PUT, PATCH

> 요청 파라미터와 다르게, HTTP 메시지 바디를 통해 데이터가 직접 넘어오는 경우는 `@RequestParam` `@ModelAttribute` 를 사용할 수 없다. (HTML Form 형식으로 전달되는 경우는 요청 파라미터로 인정)

HTTP 메시지 바디의 데이터를 `InputStream` 을 사용해서 직접 읽을 수 있다.

**Spring MVC 는 다음 파라미터를 지원해준다.**

- InputStream(Reader) : HTTP 요청 메시지 바디의 내용을 직접 조회
- OutputStream(Write) : HTTP 응답 메시지의 바디에 직접 결과 출력
- HttpEntity
    - HTTP header, body 정보를 편리하게 조회
        - 메시지 바디 정보를 직접 조회
        - 요청 파라미터를 조회하는 기능과 관계 없음(`@RequestParam` - X `@ModelAttribute` - X)
    - 응답에도 사용 가능
        - 메시지 바디 정보 직접 반환
        - 헤더 정보 포함 가능
        - view 조회 X
- RequestEntity : HttpMethod, url 정보를 추가 , 요청에서 사용
- ResponseEneity
    - HTTP 상태 코드 설정 가능, 응답에서 사용
    - `return new ResponseEntity<String>("Hello World", responseHeaders, HttpStatus.CREATED)`

> Spring MVC 내부에서 HTTP 메시지 바디를 읽어서 문자나 객체로 변환해서 전달해주는데, 이 때 HTTP 메시지 컨버터(`HttpMessageConverter`라는 기능을 사용.

`@RequestBody` <br>
HTTP 메시지 바디 정보를 편리하게 조회 가능.<br>
헤더 정보가 필요하면 `HttpEntity` 를 사용하거나 `@RequestHeader` 를 사용하면 된다.<br>
메시지 바디를 직접 조회하는 기능은 요청 파라미터를 조회하는 `@RequestParam` `@ModelAttribute` 와 전혀 관계 없다.<br>

`@ResponseBody` <br>
응답 결과를 HTTP 메시지 바디에 직접 담아서 전달할 수 있다. 이 경우 view 를 사용하지 않는다.

### 10. HTTP 요청 메시지 - JSON

문자로 된 JSON 데이터를 Jackson 라이브러리인 ObjectMapper 를 사용해서 객체로 변환할 수 있다.

`@RequestBody`, `HttpEntity`<br>
HTTP 메시지 컨버터가 HTTP 메시지 바디의 내용을 우리가 원하는 문자나 객체 등으로 변환해준다.

`@RequestBody` 는 생략이 불가능하다.<br>
주의할점은 HTTP 요청시에 content-type 이 application/json 인지 확인해야한다. (HTTP 메시지 컨터가 동작하기 위해서는 content-type을 체크한다)

### 11. HTTP 응답 - 정적 리소스, 뷰 템플릿

스프링(서버)에서 응답 데이터를 만드는 방법은 크게 3가지 이다.

- 정적 리소스
    - Ex. 웹 브라우저에 정적인 HTML, css, js 을 제공할 때는 정적 리소스 사용
- 뷰 템플릿 사용
    - Ex. 웹 브라우저에 동적인 HTML 을 제공할 때는 뷰 템플릿 사용
- HTTP 메시지 사용
    - HTTP API 를 제공하는 경우에는 HTML이 아니라 데이터를 전달해야 하므로, HTTP 메시지 바디에 JSON 같은 형식으로 데이터를 실어 보냄

**정적 리소스**

스프링 부트는 클래스패스의 다음 디렉토리에 있는 정적 리소스 제공

`/static` , `/public` , `/resources` , `/META-INF/resources`

`src/main/resources` 는 리소스를 보관하는 곳이며 클래스패스의 시작 경로이기도 하다.

**뷰 템플릿**

뷰 템플릿을 거쳐 HTML 이 생성되고, 뷰가 응답을 만들어서 전달한다.

### 12. HTTP 메시지 컨버터

<img src="/document/spring_mvc_2/img/1.png" width="500px;" />

`@ResponseBody` 사용<br>
- HTTP 의 BODY에 문자 내용을 직접 반환
- `viewResolver` 대신에 `HttpMessageConverter` 이 동작
- 기본 문자처리 : `StringHttpMessageConverter`
- 기본 객체처리 : `MappingJackson2HttpMessageConverter`
- byte 처리 등등 기타 여러 HttpMessageConverter 가 기본으로 등록

> **응답**의 경우 클라이언트의 HTTP Accept 해더와 서버의 컨트롤러 반환 타입 정보 둘을 조합해서 `HttpMessageConverter` 가 선택된다.

**스프링 MVC 는 다음의 경우 HTTP 메시지 컨버터를 적용**

- HTTP 요청 : `@RequestBody` , `HttpEntity(RequestEntity)`
- HTTP 응답 : `@RequestBody`, `HttpEntity(RequestEntity)`
