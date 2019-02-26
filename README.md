# 웹 애플리케이션 서버
>  해당 프로젝트는 교육기관 코드스쿼드 [이슈 관리 시스템](https://github.com/code-squad/java-ims/tree/master/src/main/java/codesquad)에서 Fork받아 발전시킨 것입니다.

  

## 배운 점

* HTTP Request, Response의 Header 및 Body 값 확인 및 전반적인 흐름을 파악할 수 있었습니다.
* Reflection API를 통해 Annotation 기반의 Controller매핑, parameter binding 구현을 통해서 스프링 프레임워크 동작원리를 좀 더 이해할 수 있게 되었습니다.
* 쿠키와 세션 설정을 통해 서버내에서 상태값을 관리함으로써 쿠키, 세션값을 어떻게 처리하고 이용해야할지 배웠습니다.
* 다양한 요청, 응답에 대응하기 위해 객체지향적으로 리팩토링을 진행하였습니다. 또 다형성도 이용하여 구체적인 것에 대한 의존성을 최대한 제거하였습니다.
* 프로젝트 진행 중 싱글톤 객체 내에서 쓰레드 셰이프하지 않은 버그가 발생하였습니다. 이를 통해서 싱글톤 객체 내에서 쓰레드 셰이프하게 전략적으로 메모리 관리하는 방법을 익히게 되었습니다.

  

  

## Dev Notes
* [Today's Dev Notes(2019-01-20)](https://brad903.tistory.com/entry/XFile) : 최초 설계
* [Today's Dev Notes(2019-01-23)](https://brad903.tistory.com/entry/Todays-Dev-Notes20190123?category=842599)