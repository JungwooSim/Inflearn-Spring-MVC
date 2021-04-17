# 05. 스프링 MVC
### 01. 스프링 MVC 전체 구조

"04. MVC 프레임워크 만들기" 에서 직접 만든 MVC 프레임워크와 스프링 MVC 비교

<img src="/document/spring_mvc/img/1.png" width="500px;" />

**MVC 프레임워크 → 스프링 MVC 구조**

- FrontController → Dispatcher Servlet
- handlerMappingMap → HandlerMapping
- MyHandlerAdapter → HandlerAdapter
- ModelView → ModelAndView
- viewResolver → ViewResolver
- MyView → View

**DispatcherServlet 구조**

`org.springframework.web.servlet.DispatcherServlet`

- 스프링 MVC의 핵심
- Front Controller 패턴으로 구성되어있는데 DispatcherServlet의 역할이다.

**동작 순서**

1. 핸들러 조회 : 핸들러 매핑을 통해 요청 URL 에 매핑된 핸들러(컨트롤러)를 조회
2. 핸들러 어댑터 조회 : 핸들러를 실행할 수 있는 핸들러 어댑터 조회
3. 핸들러 어댑터 실행 : 핸들러 어댑터 실행
4. 핸들러 실행 : 핸들러 어댑터가 실제 핸들러 실행
5. ModelAndView 반환 : 핸들러 어댑터는 핸들러가 반환하는 정보를 ModelAndView로 변환해서 반환
6. viewResolver 호출 : 뷰 리졸버를 찾고 실행 (JSP 경우 `InternalResourceViewResolver` 가 자동 등록되고 사용된다.)
7. View 반환 : 뷰 리졸버는 뷰의 논리 이름을 물리 이름으로 바꾸고, 렌더링 역할을 담당하는 뷰 객체를 반환
   (JSP 경우 `InternalResourceView(JstlView)` 를 반환하는데, 내부에 `forward()` 로직이 있다.)
8. 뷰 랜더링 : 뷰를 통해서 렌더링

### 03. 스프링 MVC - 시작하기

`@Controller`
- 스프링이 자동으로 빈을 등록 (내부에 `@Component` 애노테이션이 스캔 대상으로 만듬)
- 스프링 MVC 에서 애노테이션 기반 컨트롤러로 인식

`@RequestMapping`
- 요청 정보를 매핑, 해당 URL 이 호출되면 해당 메소드를 호출
- 애노테이션 기반으로 동작하기 때문에, 메서드의 이름은 임의로 지으면 된다.

`@ModelAndView`
- 모델과 뷰 정보를 담아서 반환
