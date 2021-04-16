# 인프런 - 스프링 MVC 1편 - 백엔드 웹 개발 핵심 기술 (김영한)


### SSR, CSR
SSR (server-side rendering)
- HTML 최종 결과를 서버에서 만들어서 웹 브라우저에 전달
- 주로 정적인 화면에서 사용
- 관련기술 : JSP, Thymeleaf

CSR (client-side rendering)
- HTML 결과를 자바스크립트를 사용해 웹 브라우저에서 동적으로 생성해서 사용
- 주로 동적인 화면에 사용, 웹 환경을 마치 앱처럼 필요한 부분부분을 변경할 수 있음
- 관련기술 : React, Vue.js

### Spring WebFlux
특징
- Asynchronouse Non-Blockking (비동기 논블럭킹)
- 최소 쓰레드로 최대 성능 - 쓰레드 컨텍스트 스위치 비용 효율화
- 함수형 스타일로 개발 - 동시처리 코드 효율화
- 서블릿 기술 사용하지 않음

단점
- 기술적 난이도가 높음
- RDB 지원 부족
- 일반 MVC 쓰레드 모델도 충분히 빠르다
- 실무에서 아직 많이 사용하지 않음

### 02. 서블릿(<a href="https://github.com/JungwooSim/Inflearn-Spring-MVC/tree/master/document/servlet" target="_blank">링크</a>)
### 03. 서블릿, JSP, MVC 패턴(<a href="https://github.com/JungwooSim/Inflearn-Spring-MVC/tree/master/document/servlet_jsp_mvc-pattern" target="_blank">링크</a>)
### 04. MVC 프레임워크 만들기(<a href="https://github.com/JungwooSim/Inflearn-Spring-MVC/tree/master/document/mvc_framework" target="_blank">링크</a>)
### 05. Spring MVC(<a href="https://github.com/JungwooSim/Inflearn-Spring-MVC/tree/master/document/spring_mvc" target="_blank">링크</a>)
