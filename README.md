# spreet
<img width="912" src="https://user-images.githubusercontent.com/65327103/217005331-64cff4dd-234b-491d-97fe-07f810ec50c6.jpg">

### 힙합을 퍼뜨리자!
**Spreed(퍼뜨리다) + Street = Spreet 입니다!**  
힙합이 궁금하다면?  
[🎤**힙합을 즐겨보아Yo! Spreet 방문하기**](https://www.spreet.co.kr)  
<br>    
   
[😎Front-End GitHub](https://github.com/Spreet-Project/Front-end)  
[🛹Spreet Notion](https://www.notion.so/Spreet-30f5391e7e524289b3d44ec0abc11cbc)  

---- 
## 아키텍처  
<img width="912" alt="스크린샷 2023-02-07 15 20 05" src="https://user-images.githubusercontent.com/65327103/217165384-e94dfc4b-b5a2-4960-83d7-cf25f07c5ed2.png">
<!-- <img width="912" alt="image" src="https://user-images.githubusercontent.com/65327103/217009789-bf9dd273-2fef-4168-911e-92a7ce6121ac.png">   -->
  
## ERD  
  
----  
## 📆 전체 프로젝트 개발 기간  
2022.12.30 ~ 2023.02.10    
<br>  

## 💡주요 기능 
* 회원가입, 로그인, 소셜로그인(카카오, 네이버)
* 1분 내외의 쇼츠 영상 업로드 가능
* 최대 5장의 이미지 업로드 가능
* 관리자에게 인증받은 크루는 위치정보를 기입하여 공연 홍보 가능
* 공연 위치정보를 카카오맵 마커로 시각화
* 지역별 공연정보 조회 가능
* 회원정보 수정 가능(닉네임, 프로필 사진, 비밀번호)
* 마이페이지에서 나의 활동기록 확인 가능
* 쇼츠, 피드, 행사 게시글 및 댓글 등록시 비속어 필터링 기능(`*`로 표시)  
<br>

## 🛠️기술 스택
<img src="https://img.shields.io/badge/SpringBoot-6DB33F?style=flat&logo=SpringBoot&logoColor=white"/> <img src="https://img.shields.io/badge/Gradle-02303A?style=flat&logo=Gradle&logoColor=white"/> <img src="https://img.shields.io/badge/QueryDSL-008ED2?style=flat&logo=QueryDSL&logoColor=white"/> <img src="https://img.shields.io/badge/MySQL-4479A1?style=flat&logo=MySQL&logoColor=white"/> <img src="https://img.shields.io/badge/Redis-DC382D?style=flat&logo=Redis&logoColor=white"/> <img src="https://img.shields.io/badge/NGINX-009639?style=flat&logo=NGINX&logoColor=white"/> <img src="https://img.shields.io/badge/AmazonRDS-527FFF?style=flat&logo=AmazonRDS&logoColor=white"/> <img src="https://img.shields.io/badge/AmazonS3-569A31?style=flat&logo=AmazonS3&logoColor=white"/> <img src="https://img.shields.io/badge/AmazonEC2-FF9900?style=flat&logo=AmazonEC2&logoColor=white"/> <img src="https://img.shields.io/badge/WebHooks-41454A?style=flat&logo=WebHooks&logoColor=white"/> <img src="https://img.shields.io/badge/ImgScalr-EF2D5E?style=flat&logo=ImgScalr&logoColor=white"/> <img src="https://img.shields.io/badge/GitHubActions-2088FF?style=flat&logo=GitHubActions&logoColor=white"/> <img src="https://img.shields.io/badge/Swagger-85EA2D?style=flat&logo=Postman&logoColor=white"/> <img src="https://img.shields.io/badge/Postman-FF6C37?style=flat&logo=Postman&logoColor=white"/> <img src="https://img.shields.io/badge/GitHub-181717?style=flat&logo=GitHub&logoColor=white"/> <img src="https://img.shields.io/badge/Slack-4A154B?style=flat&logo=Slack&logoColor=white"/> <img src="https://img.shields.io/badge/JiraSorfware-0052CC?style=flat&logo=JiraSorfware&logoColor=white"/>   
<br>    
  
## 🧐 기술적 의사 결정
|사용 기술|설명|
|:----:|----|
|AWS<br>(EC2, S3, RDS)|많이 유저들이 사용하는 만큼 서비스 신용도가 높고 그에 대한 참고할만한 Reference들이 많은 서비스이기에 유지보수성에 있어서 많은 강점을 가진만큼 개발에 큰 이점을 얻을 수 있기때문에 활용하게 되었습니다.|
|MySQL|데이터의 무결성을 지킬 수 있고 일정한 스키마로 데이터를 관리할 수 있고, 연관관계를 설정하여 테이블을 관리할 수 있는 관계형 데이터베이스를 선택하였습니다.<br>MySQL은 메모리 사용량이 적고, 용량 차지가 적으며 비용적인 부담도 적기 때문에 사용하게 되었습니다.|
|소셜 로그인<br>(카카오, 네이버)|회원가입과 로그인이 용이하며, 유저의 개인정보를 직접 입력받지 않으므로 보안성 향상에 도움이 될 것이라 판단하였습니다.<br>소셜 로그인 중에서도 대중적인 카카오와 네이버 로그인을 적용하였습니다.|
|QueryDSL|여러 테이블을 조회해야하는 필요성이 증가함에 따라 서브쿼리도 작성해야 했는데, 네이티브 쿼리는 데이터베이스에 종속적이며 직접 쿼리를 작성하기 때문에 종종 문법 오류가 발생하기도 했습니다. <br>따라서 자바 언어로 작성되어 손쉽게 query를 작성할 수 있으며 컴파일 단계에서 오류를 발견할 수 있고, 동적쿼리 작성이 용이한 QueryDSL을 사용하였습니다. |
|JWT|세션을 사용하면 사용자가 많아짐에 따라 세션 DB와 서버를 확장해야하는 단점이 있는데, JWT의 경우 토큰 안에 유저의 정보를 담고 있기 때문에 별도의 데이터 및 저장 공간이 필요하지 않기에 사용하기로 하였습니다.|
|WebHooks|서버 배포시 에러가 발생했을 경우 슬랙과 연동하여 실시간으로 에러를 확인하고 신속하게 대응할 수 있도록 하였습니다.|
|SSE||
|Https|DDos 등 서버 공격에 대한 보안을 위해서 프론트엔드와 백엔드 모두 SSL 인증서를 통한 Https를 적용하였습니다.|
<br>  
  
## 🔥 트러블 슈팅
[EC2 RAM 초과 & Memory 성능 이슈](https://github.com/Spreet-Project/Back-end/wiki/EC2-RAM-%EC%B4%88%EA%B3%BC-&-Memory-%EC%84%B1%EB%8A%A5-%EC%9D%B4%EC%8A%88)  
[Image Resizing](https://github.com/Spreet-Project/Back-end/wiki/Image-Resizing)  
<br>  
  
## 👩🏻‍💻🧑🏻‍💻 BackEnd 팀원
|김규민|이승열|김소라|
|:----:|:----:|:----:|
|BE(부팀장)|BE|BE|
||||
|[:link:](https://github.com/starMinK)|[:link:](https://github.com/misracis2)|[:link:](https://github.com/dev-rara)|
|1.회원가입<br>2.로그인<br>3.카카오 로그인<br>4.이메일 인증|1.피드 CRUD<br>2.행사 댓글<br>3.구독 기능<br>4.알림 기능<br>5.Nginx 무중단배포<br>6.QueryDSL|1.쇼츠 CRUD<br>2.비속어 필터링<br>3.네이버 로그인<br>4.행사 게시글<br>5.QueryDSL<br>6.마이페이지 기능<br>7.관리자 기능<br>8.CI/CD 구축 및 서버 환경 관리<br>(AWS route53, ACM , EC2, CodeDeploy)|
