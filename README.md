# 벗들의 개발 커뮤니티, EWHA CODIC

![%E1%84%87%E1%85%A5%E1%86%BA%E1%84%83%E1%85%B3%E1%86%AF%E1%84%8B%E1%85%B4%20%E1%84%80%E1%85%A2%E1%84%87%E1%85%A1%E1%86%AF%20%E1%84%8F%E1%85%A5%E1%84%86%E1%85%B2%E1%84%82%E1%85%B5%E1%84%90%E1%85%B5,%20EWHA%20CODIC%2027519856089541a998e41946f23eee1b/Untitled.png](%E1%84%87%E1%85%A5%E1%86%BA%E1%84%83%E1%85%B3%E1%86%AF%E1%84%8B%E1%85%B4%20%E1%84%80%E1%85%A2%E1%84%87%E1%85%A1%E1%86%AF%20%E1%84%8F%E1%85%A5%E1%84%86%E1%85%B2%E1%84%82%E1%85%B5%E1%84%90%E1%85%B5,%20EWHA%20CODIC%2027519856089541a998e41946f23eee1b/Untitled.png)

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

# 📚 선택한 기술 스택 및 사용 라이브러리

### 🌲 기술 스택

![%E1%84%87%E1%85%A5%E1%86%BA%E1%84%83%E1%85%B3%E1%86%AF%E1%84%8B%E1%85%B4%20%E1%84%80%E1%85%A2%E1%84%87%E1%85%A1%E1%86%AF%20%E1%84%8F%E1%85%A5%E1%84%86%E1%85%B2%E1%84%82%E1%85%B5%E1%84%90%E1%85%B5,%20EWHA%20CODIC%2027519856089541a998e41946f23eee1b/Untitled%201.png](%E1%84%87%E1%85%A5%E1%86%BA%E1%84%83%E1%85%B3%E1%86%AF%E1%84%8B%E1%85%B4%20%E1%84%80%E1%85%A2%E1%84%87%E1%85%A1%E1%86%AF%20%E1%84%8F%E1%85%A5%E1%84%86%E1%85%B2%E1%84%82%E1%85%B5%E1%84%90%E1%85%B5,%20EWHA%20CODIC%2027519856089541a998e41946f23eee1b/Untitled%201.png)

`Spring`, `MySQL`, `AWS`

### 🌲 사용 라이브러리

- `JPA` : DB 연동 및 제어
- `Spring security` : 회원가입&로그인 기능
- `spring-context-support` , `javax.mail` : 메일 전송(이화인 인증 기능)
- `json-simple` , `gson` : json 파싱(Github API로 이용자별 커밋 수 얻어오기)
- `spring-boot-starter-data-redis`, 
`spring-boot-starter-cache` ,
`embedded-redis` : 랭킹 기능을 위한 사용자 데이터 관리

# 📚 API 명세서

[API 명세서](https://www.notion.so/API-2c8a54041aa547ecaaa0cbb3e688bd80)

[https://www.notion.so/API-2c8a54041aa547ecaaa0cbb3e688bd80](https://www.notion.so/API-2c8a54041aa547ecaaa0cbb3e688bd80)

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

![%E1%84%87%E1%85%A5%E1%86%BA%E1%84%83%E1%85%B3%E1%86%AF%E1%84%8B%E1%85%B4%20%E1%84%80%E1%85%A2%E1%84%87%E1%85%A1%E1%86%AF%20%E1%84%8F%E1%85%A5%E1%84%86%E1%85%B2%E1%84%82%E1%85%B5%E1%84%90%E1%85%B5,%20EWHA%20CODIC%2027519856089541a998e41946f23eee1b/%EC%BD%94%EB%94%A9%ED%95%98%EB%8A%94%EC%B9%A0%EA%B3%B5%EC%A3%BC-%EB%B0%B13%EC%B0%A8%EA%B3%BC%EC%A0%9C.jpg](%E1%84%87%E1%85%A5%E1%86%BA%E1%84%83%E1%85%B3%E1%86%AF%E1%84%8B%E1%85%B4%20%E1%84%80%E1%85%A2%E1%84%87%E1%85%A1%E1%86%AF%20%E1%84%8F%E1%85%A5%E1%84%86%E1%85%B2%E1%84%82%E1%85%B5%E1%84%90%E1%85%B5,%20EWHA%20CODIC%2027519856089541a998e41946f23eee1b/%EC%BD%94%EB%94%A9%ED%95%98%EB%8A%94%EC%B9%A0%EA%B3%B5%EC%A3%BC-%EB%B0%B13%EC%B0%A8%EA%B3%BC%EC%A0%9C.jpg)

# 📚 팀원별 역할분담

[Backend](https://www.notion.so/2be1085d62954ab0a654f432466e8f5f)