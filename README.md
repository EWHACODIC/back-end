# 벗들의 개발 커뮤니티, EWHA CODIC
![Untitled](https://user-images.githubusercontent.com/61778930/127738714-7cd7e51b-6526-4524-b6ca-ebd3e1047600.png)


# 📚 프로젝트 구조 및 설명

### 📌 Study 페이지

- 나의 커밋 통계 확인하기
- 커밋 수를 이용한 이화 벗들과의 커밋 랭킹전
- 스터디 모집하기
- 스터디 참여하기
- 인기 스터디 조회

### 📌 Community 페이지

- 이화 개발자들의 익명 커뮤니티
- 게시글 공감 기능
- 댓글 작성 기능

### 📌 Tech/QnA 페이지

- 관심태그 및 키워드로 게시글 검색
- 댓글 작성 기능

### 📌 Login/회원가입

- 이화인 이메일 인증을 통해 이화 개발자만 가입 가능
- Github 개인 repository와 연동
- 이화인 이메일과 비밀번호를 이용한 로그인

### 

# 📚 기술 스택 및 사용 라이브러리

### 🌲 기술 스택

![Untitled 1](https://user-images.githubusercontent.com/61778930/127738721-4d84adcf-dcb3-4689-a32b-b6d2008dacf4.png)

`Spring`, `MySQL`, `AWS`

### 🌲 사용 라이브러리

- `JPA` : DB 연동 및 제어
- `Spring security` : 회원가입&로그인 기능
- `spring-context-support` , `javax.mail` : 메일 전송(이화인 인증 기능)
- `json-simple` , `gson` : json 파싱(Github API로 이용자별 커밋 수 얻어오기)
- `spring-boot-starter-data-redis`, 
`spring-boot-starter-cache` ,
`embedded-redis` : 랭킹 기능을 위한 사용자 데이터 관리

- - -

# 📚 [API 명세서](https://www.notion.so/API-2c8a54041aa547ecaaa0cbb3e688bd80)
링크 참고
   
   
# 📚 폴더 구조

```scss
├── DemoApplication.java
├── config
│   ├── MvcConfig.java
│   ├── SecurityMessageConfig.java
│   └── WebSecurityConfig.java
├── controller
│   ├── BoardController.java
│   ├── CommunityController.java
│   ├── QnaController.java
│   ├── TagController.java
│   ├── TechController.java
│		├── GithubInfoController.java
│   └── UserController.java
├── domain
│   ├── Board.java
│   ├── BoardComment.java
│   ├── Community.java
│   ├── CommunityComment.java
│   ├── Qna.java
│   ├── QnaComment.java
│   ├── Tag.java
│   ├── Tech.java
│   ├── TechComment.java
│		├── GithubInfo.java
│   └── UserInfo.java
├── dto
│   ├── BoardCommentDto.java
│   ├── BoardDto.java
│   ├── BoardListDto.java
│   ├── BoardTagDto.java
│   ├── TagDto.java
│		├── GithubInfoDto.java
│   ├── UserInfoDto.java
│   └── UserTagDto.java
├── enums
├── repository
│   ├── BoardCommentRepository.java
│   ├── BoardRepository.java
│   ├── CommunityCommentRepository.java
│   ├── CommunityRepository.java
│   ├── QnaCommentRepository.java
│   ├── QnaRepository.java
│   ├── TagRepository.java
│   ├── TechCommentRepository.java
│   ├── TechRepository.java
│		├── GithubInfoRepository.java
│   └── UserRepository.java
└── service
    ├── BoardService.java
    ├── CommunityService.java
    ├── QnaService.java
    ├── TagService.java
    ├── TechService.java
		├── GithubInfoService.java
    └── UserService.java
```

# 📚 ER다이어그램

![코딩하는칠공주-백3차과제](https://user-images.githubusercontent.com/61778930/127738724-91b26e29-6bb4-4376-9bc9-7316ec349ce8.jpg)

# 📚 팀원별 역할분담

||이름|ID|역할|
|--------|-------|---|---|
|<img src = "https://user-images.githubusercontent.com/71870316/127739602-65d2f3e0-451c-4bfa-b382-4a128336f9de.png" width="250" height="250">|[김윤서](https://github.com/ottl-seo)|@ottl-seo|회원가입 및 로그인, 이화 벗들과의 커밋 랭킹전 기능|
|<img src = "https://user-images.githubusercontent.com/71870316/127739808-3deb9684-e90a-4f19-92a4-49f91617af6d.JPG" width="250" height="250">|[이재희](https://github.com/ejhee1)|@ejhee1|회원가입 및 로그인, 이화 벗들과의 커밋 랭킹전 기능|
||[이채은](https://github.com/lcheun)|@lcheun|게시판, 관심 Tag, 스터디 페이지 구현|
|<img src = "https://user-images.githubusercontent.com/71870316/127739702-b19c4cc4-7273-409c-a345-c74d7872e14a.png" width="250" height="250">|[장보미](https://github.com/JangBomi)|@JangBomi|게시판, 관심 Tag, 스터디 페이지 구현|



