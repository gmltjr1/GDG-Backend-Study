______정리___
1. 웹 이란

웹, 인터넷: 인터넷은 전 세계 컴퓨터를 연결하는 거대한 네트워크이며, 웹은 그 인터넷 위에서 동작하는 정보 공유 서비스

클라이언트-서버 모델: '클라이언트'가 요청을 보내고 '서버'가 요청을 처리하여 응답을 반환

URL: 웹상에서 자원(문서, 이미지 등) 위치를 나타내는 주소

  -Host: 리소스가 위치한 서버의 ip주소

  -Port: 서버의 특정 네트워크 포트 번호(일반적으로 생략)
  
  -Path: 서버 내에서 원하는 리소스 경로
  
  -Query: 추가 정보, ? 뒤에 key-value형식으로 나열


2. HTTP

HTTP: 웹에서 클라이언트와 서버가 데이터를 주고받는 프로토콜

  -무상태성: 서버는 클라이언트의 이전 요청을 기억하지 않음

  -비연결성: 클라이언트가 응답을 받은 후 서버와 연결을 유지하지 않음

요청과 응답 메시지 모두 start line, headers, body으로 구성

주요 메서드
  
  -GET: 리소스 조회 
  
  -POST: 리소스 추가, 등록
  
  -PUT: 리소스 교체, 없으면 생성
  
  -PATCH, 리소스 일부 수정
  
  -DELETE: 리소스 삭제

주요 상태 코드
  
  -200 OK: 요청 성공적으로 처리
  
  -201 Created: 리소스 생성
  
  -400 Bad Request: 요청 잘못으로 서버가 이해 불가능
  
  -404 Not Found: 리소스를 찾을 수 없음 
  
  -500 Internal Server Error: 서버 내부 오류 

3. 프론트엔드와 백엔드

프론트엔드: 사용자가 직접 보는 화면과 사용자 인터페이스 개발

백엔드: 사용자의 요청을 받아 동작을 처리하고 데이터 저장, 관리

데이터베이스: 데이터를 체계적으로 모아둔 저장소로
  
  -데이터베이스 관리 시스템(DBMS)로 관리
  
  -예) MySQL, MongoDB 등


4. API와 REST API

API: 클라이언트와 서버가 어떻게 요청하고 응답할지에 대한 규칙과 기능의 목록

REST: HTTP의 장점을 최대한 활용할 수 있는 네트워크 아키텍처 스타일. 
  
  -자원(Resource): URI
  
  -행위(Verb): HTTP Method
  
  -표현(Representation): 데이터형식(Json 등)

REST API: REST 원칙을 준수하여 만든 API로, HTTP의 모범 사례


5. Spring과 Spring Boot

Spring: 좋은 객체 지향 프로그램을 개발할 수 있도록 도와주는 자바 기반의 오픈소스 애플리케이션 프레임워크

Spring Boot: 복잡한 초기 설정 없이 스프링 프레임워크를 빠르고 쉽게 사용할 수 있게 해주는 도구
____________________________________________



<img width="1919" height="512" alt="스크린샷 2025-09-30 232422" src="https://github.com/user-attachments/assets/421915c6-8a25-4710-9c2d-cd6eeb5fd0e1" />





___쇼핑몰 API작성___

상품 기능

  1. 상품 정보 등록
    
    HTTP Method: POST
    URI: /goods
  
  2. 상품 목록 조회
    
    HTTP Method: GET
    URI: /goods
  
  3. 개별 상품 정보 상세 조회
    
    HTTP Method: GET
    URI: /goods/{goodId}
  
  4. 상품 정보 수정
    
    HTTP Method: PATCH
    URI: /goods/{goodId}
  
  5. 상품 삭제
    
    HTTP Method: DELETE
    URI: /goods/{goodId}

주문 기능
  
  1. 주문 정보 생성
    
    HTTP Method: POST
    URI: /orders
  
  2. 주문 목록 조회
    
    HTTP Method: GET
    URI: /orders
  
  3. 개별 주문 정보 상세 조회
    
    HTTP Method: GET
    URI: /orders/{orderId}
  
  4. 주문 취소
    
    HTTP Method: DELETE
    URI: /orders/{orderId}
