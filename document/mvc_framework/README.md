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

### 정리

v1 ~ v5로 점진적으로 코드를 개선해왔다.
- v1 : 프론트 컨트롤러 도입
    - 기존 구조를 최대한 유지하면서 프론터 컨트롤러를 도입
- v2 : View
    - 단순 반복 되는 뷰 로직 분리
- v3 : Model 추가
    - 서블릿 종속성 제거
    - 뷰 이름 중복 제거
- v4 : 단순하고 실용적인 컨트롤러
    - v3와 거의 비슷
    - 구현 입장에서 ModelView를 직접 생성해서 반환하지 않도록 편리한 인터페이스 제공
- v5 : 유연한 컨트롤러
    - 어댑터 도입
    - 어댑터를 추가해서 프레임워크를 유지하고 확장성 있게 설계
