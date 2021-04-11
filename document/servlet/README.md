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
