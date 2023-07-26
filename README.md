MiniProject_Basic_Leesiyun
==================================
## 멋사마켓
멋사마켓 프로젝트는 스프링부트로 구현한 중고 물품 거래 서비스입니다.
1차 프로젝트 기간에는 CRUD를 구현하였습니다.

----------------------------------
### Information
#### - 1차 프로젝트 기간 : 2023/07/26 ~ 2023/08/02
#### - 작성자 : 이시윤
#### - 문의 : livre303@gmail.com

----------------------------------
### 사용 방법
 resources 패키지 안에 있는 다음의 파일들을 다운로드 하세요.

 - Postman Collection(1)_Leesiyun_SalesItem.json
 - Postman Collection(2)_Leesiyun_Comment.json
 - Postman Collection(3)_Leesiyun_Negotiation.json
 
 POSTMAN에 import하신 후 테스트하실 수 있습니다.

----------------------------------
### Environment
- IDE : IntelliJ
- Project : Gradle
- Language: Java 17
- Spring Boot 3.1.1
- Dependencies
  - Spring Reactive Web
  - Spring Data JPA
  - Lombok
  - Spring Boot DevTools

----------------------------------
### 멋사마켓 기능
- 판매글 생성/조회/수정/삭제
   - 판매 게시글을 등록할 수 있습니다.
   - (예정) 판매 게시글에 이미지를 첨부할 수 있습니다.
   - 특정 판매 게시글을 지정하여 조회할 수 있습니다.
   - 여러 개의 판매 게시글을 전체 조회하거나 페이지 단위로 조회할 수 있습니다.
   - 판매 게시글을 등록할 때 지정한 비밀번호로 판매글을 수정 및 삭제할 수 있습니다.

- 댓글 생성/조회/수정/삭제
  - 판매 게시글에 댓글을 생성할 수 있습니다.
  - 판매 게시글을 전체 조회할 수 있습니다.
  - 판매 게시글을 등록할 때 지정한 비밀번호로 판매글을 수정 및 삭제할 수 있습니다.

- 거래 제안 등록/조회/삭제
    - 제안을 최초 등록시 자동으로 "제안" 상태가 됩니다.
    - 판매글 작성자(작성자명, 비밀번호 일치)는 해당 판매글에 달린 제안 목록을 조회할 수 있습니다.
    - 제안을 등록할 때 입력한 비밀번호로 제안을 삭제할 수 있습니다.

----------------------------------
### Document
- 판매 게시글에 관한 기능은 'item' 또는 'Sale'을 사용하여 네이밍하였습니다.
코멘트 게시글에 관한 기능은 'comment'를 사용하여 네이밍하였습니다.
거래 제안에 관한 기능은 'nego'를 사용하여 네이밍하였습니다.


1. 데이터 구조

- items 테이블
  
|      변수명     |  자료형 |    제약    |
|:--------------:|--------:|:--------:|
|       Id       |    Long |    PK    |
|     title      |  String | NotNull  |
|  description   |  String |          |
|   image_url    |  String |          |
| minPriceWanted | Integer |          |
|     status     |  String |          |
|     writer     |  String | NotNull  |
|    password    |  string | NotNull  |

- comments 테이블

|  변수명     |     자료형 |    제약    |
|:--------:|--------:|:--------:|
|    Id    |    Long |    PK    |
|  ItemId  |    Long |          |
|  writer  |  String | NotNull  |
| password |  string | NotNull  |
| content  |  string | NotNull  |
|  reply   |  string |          |

-  negotiation 테이블 

| 변수명      |  자료형 |    제약    |
|:--------:|--------:|:--------:|
|    Id    |    Long |    PK    |
|  ItemId  |    Long |          |
|  status  |  String |          |
|  writer  |  string |          |
| password |  string | NotNull  |



2. MVC 패턴을 적용하고자 다음의 카테고리로 문서를 분리하여 관리하였습니다.
- Controller
   - SaleController : 판매 게시글 생성/조회/수정/삭제에 관한 요청과 응답
   - commentController : 댓글 생성/조회/수정/삭제에 관한 요청과 응답
   - negoController : 거래 제안 등록/조회/수정/삭제에 관한 요청과 응답
-  Dto
   - itemDto
      - itemCreateDto : 판매 게시글 생성에 관한 Dto
      - itemUpdateDto : 판매 게시글 수정에 관한 Dto
      - itemDeleteDto : 판매 게시글 삭제에 관한 Dto
   - commentDto
     - commentDto : 댓글 관련 기능에 관한 Dto
     - commentReadDto : 댓글 조회 기능에 관한 Dto
   - negoDto : 거래 제안 관련 기능에 관한 Dto
   - responseDto : 응답 메시지에 관한 Dto
     
-  Entity
   - itemEntity : items 테이블을 구성하는 물품에 대한 기본 정보
   - commentEntity : comments 테이블의 기본 정보
   - negoEntity : negotiation 테이블의 기본 정보
-  Repository
   - itemRepository : JpaRepository를 상속 받은 레포지토리이며,
 items 테이블을 활용할 수 있도록 인터페이스를 제공
   - commentRepository : JpaRepository를 상속 받은 레포지토리이며,
 comments 테이블을 활용할 수 있도록 인터페이스를 제공
   - negoRepository : JpaRepository를 상속 받은 레포지토리이며,
 negotiation 테이블을 활용할 수 있도록 인터페이스를 제공
-  Service
   - salesService: 판매 게시글 생성/조회/수정/삭제에 관한 로직
   - commentService : 댓글 생성/조회/수정/삭제에 관한 로직
   - negoService : 거래 제안 생성/조회/수정/삭제에 관한 로직

----------------------------------
### Update

    < 업데이트 예정 >
    - 판매글에 이미지 추가 기능 추가
    - 댓글에 답글 기능 추가
    - URL 중복으로 인한 에러 수정 및 기능 세부화
    - HttpStatus 대신 에러에 대한 상세 정보를 제공하는 Exception으로 대체
    - 작성자 및 비밀번호 확인과 같은 공통 기능을 별도의 메서드로 분리
    - 제안 수정 기능 추가
    - 제안 수락/거절 기능 추가
    - 제안 확정 기능 추가


#### < 업데이트 완료 >
2023/07/04
- 추가: 물품 거래 제안 등록/조회/삭제 기능 구현
- 리팩토링: 판매/댓글/제안 기능별로 Dto 분리

2023/07/03
- 추가: 댓글(코멘트) 생성/삭제 기능 구현

2023/07/02
- 추가: 판매글의 갯수를 선택하여 조회하기 기능 추가
- 추가: 판매글을 수정 및 삭제시 비밀번호를 확인하는 기능 추가

2023/07/01
- 추가: 판매글의 수정 및 삭제시 응답 메시지 추가

2023/06/30
- 추가: 물품 판매글 작성/조회/수정/삭제 기능 구현
  
----------------------------------
### Acknowledgement
스프링부트를 사용한 첫 번째 미니 프로젝트를 진행하면서 아쉬운 점이 많습니다. 
이번 프로젝트를 통하여 느낀 점입니다. 
- 설계의 중요성 인지
  - 기능의 구현에 급급하여 요구사항의 기능을 그대로 주먹구구식으로 개발하였고,
  점차 기능을 추가하면서 리팩토링에 시간을 많이 들이게 되었습니다.
- 프로젝트 시간 관리 필요
  - 프로젝트를 진행하던 중 돌발 상황이 발생하여 시간 관리에 실패하였습니다. 
  주어진 시간보다 타이트한 일정 관리가 필요할 것 같습니다. 
- 기능의 중요도 선별 필요
  - 주요 기능을 먼저 구현하고 세부적인 이슈는 차후 개선하는 방식으로 진행하여
  시간 안에 주요 기능을 모두 구현하겠습니다.

미구현 기능들을 모두 구현할 수 있도록 꾸준히 개선하겠습니다.
저의 부족한 프로젝트 결과물을 끝까지 보아 주셔서 감사드립니다. 

