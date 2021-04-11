# 02. 서블릿
### 서블릿 컨테이너 동작 방식 설명

**내장 톰켓 서버 생성**

<img src="/document/servlet/img/1.png" width="500px;" />

**웹 애플리케이션 서버의 요청 응답 구조**

<img src="/document/servlet/img/2.png" width="500px;" />

### HttpServletRequest

서블릿은 HTTP 요청 메시지를 편리하게 사용가능하도록 HTTP 요청 메시지를 파싱한다.<br>
그리고 그 결과를 `HttpServletRequest` 객체에 담아서 제공한다.<br>

**임시 저장소 기능**

해당 HTTP 요청이 시작부터 끝날 때 까지 유지되는 임시 저장소 기능

```
저장 : request.setAttribute(name, value)
조회 : request.getAttribute(name)
```

**세션 관리 기능**

```
request.getSession(create: true)
```

### HTTP 요청 데이터 - 개요
HTTP 강의 들었던 것 참고

**POST HTML FORM**

특징
- content-type: application/x-www-form-urlencoded
    - GET에서 살펴본 쿼리 파리미터 형식과 같다. 그렇기 **때문에 쿼리 파라미터 조회 메서드를 그대로 사용하면 된다.**
- 메시디 바디에서 쿼리 파라미터 형식으로 데이터를 전달. usename=hello&age=20

**API 메시지 바디 - 단순 텍스트**

HTTP message body 에 데이터를 직접 담아서 요청
- HTTP API에서 주로 사용, JSON, XML, TEXT
- 데이터 형식은 주로 JSON 사용
- POST, PUT, PATCH

HTTP 메시지 바디의 데이터를 InputStream을 사용해서 직접 읽을 수 있다.
