# UnicornFinder
> [팀프로젝트] 구직자를 위해 스타트업 정보를 알려주는 웹 어플리케이션 (Spring boot, JPA, Thymeleaf) (22.03.04 ~ )

## 프로젝트 계획 이유

+ 구직자 입장에서 스타트업 정보를 간단하고 편하게 조회하고 관심있는 회사들에 대해 저장해서 찾아보고 싶었습니다.

+ 이 웹사이트는 간단한 UI로 스타트업들의 정보를 보기쉽고 찾기 쉽게 구현됐습니다.
    + 추후 원하는 회사의 정보를 우리 관리자들에게 알려주신다면 회사정보를 조사해 추가하겠습니다.
    + 이 웹사이트는 영리 목적이 아님을 명시합니다.


## 웹사이트 주소

+ 이 웹사이트는 라이브 서버로 운영되고 있습니다.
  + http://ec2-52-79-69-195.ap-northeast-2.compute.amazonaws.com:8080/

## 프로젝트 개발 환경 및 사용 라이브러리, 툴

+ Springboot version 2.6.4
+ java version 11
+ AWS EC2, S3, CodeDeploy
+ Travis CI
+ jpa
+ thymeleaf
+ mysql
+ bootstrap, jQuery, HTML/CSS
+ OAuth2 (Google), Google Map API

## 기능 설명

1. 메인 화면에서 검색 기능을 이용할 수 있습니다.
    + 회사 이름, 서비스 명을 검색어로 입력하면 해당 데이터를 보여줍니다.

2. 관리자
    + 관리자는 회사 정보를 등록, 수정, 삭제할 수 있습니다.

3. 관심등록
    + 북마크 하고 싶은 회사를 관심등록 할 수 있습니다.
    + 관심 등록 된 회사들을 조회하는 페이지는 추후 개발 예정 입니다.

4. 구글로그인
    + 구글 로그인으로 편하게 가입하고 이용하세요.

5. 테이블 필터링
    + 조회된 회사들의 투자 단계, 위치 정보를 필터링 하여 원하는 정보만 조회 가능합니다.


## 참고사항

1차 프로토타입 완성 2022.03.28

- 계속 해서 유지보수 및 개발 진행중입니다.
- 부하 테스트 진행해 성능 최적화할 예정 
