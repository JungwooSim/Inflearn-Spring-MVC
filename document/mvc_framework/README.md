# 04. MVC 프레임워크 만들기

### 프론트 컨트롤러 패턴

<img src="/document/mvc_framework/img/1.png" width="500px;" />

**FrontController 패턴 특징**

- 프론트 컨트롤러 서블릿 하나로 클라이언트의 요청을 받음
- 프론트 컨트롤러가 요청에 맞는 컨트롤러를 찾아서 호출
- 공통 처리 가능
- 프론트 컨트롤러를 제외한 나머지 컨트롤러는 서블릿을 사용하지 않아도 됨

**스프링 웹 MVC와 프론트 컨트롤러**

- 스프링 웹 MVC의 DispatcherServlet 이 FrontController 패턴으로 구현되어 있음