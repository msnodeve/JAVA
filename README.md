![Java](/img/JAVA.png)
# JAVA
JAVA 객체 개념부터 HTTP 통신까지

* * *

### 알려 드림
<p>본 Github 프로젝트는 JAVA에 대해서 어느 정도 기초 지식을 동반한 공부 프로젝트입니다.<br>
파일 I/O를 기본으로 시작해서 네트워트 소켓 통신 및 Database 연동을 이용한 객체 저장을 중심으로<br>
CentOS 7의 Tomcat으로 Servlet HTTP 통신을 목적을 두고 있습니다.</p>
<p>단계별로 폴더를 구성해 놓았습니다. 각각의 프로젝트 실행 방법에 대해서 아래에 설명드리겠습니다.</p>
<p>각 폴더가 각각의 프로젝트이므로 내부 주석을 보면서 이해해주시길 바랍니다.</p>

* * *
### 확인 부탁 드림
```
    시스템 환경변수 > JAVA_HOME 설정
    시스템 환경변수 > classpath 설정 되어있다면 삭제 해주십시오.
    또 cmd 창에서 컴파일시 "error: unmappable character for encoding MS949" 에러 문구가 뜬다면
    > javac Main.java -encoding utf8
    utf8로 인코딩하여 컴파일 해주시기 바랍니다.
```

* * * 

<p>또 한 이 프로젝트는 Eclipse를 이용하지 않아 패키지 명이 기재되어 있지 않다는 점 알려드립니다.</p>

## 실행 방법
### 01.파일 입출력을 통해 객체 저장하기
```
    01.파일 입출력을 통해 객체 저장하기 > cmd(명령 프롬프트) 실행
    > javac *.java
    > java Main
```

### 02.네트워크를 통해 파일 전송하기
```
    02.네트워크를 통해 파일 전송하기 > cmd(명령 프롬프트) 2개 실행 > Server부터 실행 후 Client 실행
    > javac *.java
    > java Server
    > java Client
```

### 03.데이터베이스 내용 출력하기
<p>사전 작업이 필요합니다.</p>

- 자신의 서버가 필요합니다.
- 서버에 mysql이 설치 되어 있어야 합니다.
- 데이터베이스 이름과 테이블 이름이 코드에있는 것과 같아야 합니다.
- 서버가 없고, 서버를 어떻게 만들어야하는지 모르시면 다음 링크를 따라 해주세요.<br>
[우리 함께 서버를 구축합시다!](https://www.youtube.com/playlist?list=PLnae-xjNaVaYND3eKBV4DXrLOQBeXmwyl)
- DB Connector jar 파일이 외부 라이브러리에 포함 되어 있어야합니다.
```
    Client(내 컴퓨터)에서 수행해야할 작업입니다!
    https://www.mysql.com/ > downloads > Community > MySQL Connectors > Connector/J
    > Select Operaing System : Platform Independent
    > Platform Independent (Architecture Independent), ZIP Archive Download
    > 압축 풀기 > mysql-connctor-java-폴더 > mysql-connector-java-version.jar 파일 Copy
    > C:\Program Files\Java\jdk1.8.0_191\jre\lib\ext 위치에 붙여넣기
```

```
    자신의 Server On > mysql start
    03.네트워크를 통해 파일 전송하기 > cmd(명령 프롬프트) 실행
    > javac Main.java
    > java Main
```

### 04.서블릿을 통해 받아온 내용 출력하기
<p>사전 작업이 필요합니다.</p>

- 03.데이터베이스 내용 출력하기 프로젝트를 먼저 수행하세요.
- 서버에 Tomcat이 설치 되어 있어야 합니다.
- 서버가 없고, Tomcat을 어떻게 설치해야하고, Tomcat을 수행하는 방법을 모르시면 다음 링크를 따라 해주세요.<br>
[우리 함께 Tomcat에 대해서 알아봅시다!](https://www.youtube.com/playlist?list=PLnae-xjNaVaYND3eKBV4DXrLOQBeXmwyl)
- DB Connector jar 파일이 Server의 외부 라이브러리에 또 포함 되어 있어야합니다.<br>
이유 : 03.프로젝트는 Client에서 DB를 접속해서 컴퓨터 DB Connector를 포함했지만 이제 Server에서 Server 내부에있는 DB에 접속해야하기 때문에 Server에 DB Connector를 포함해야합니다.
```
    Server(서버 컴퓨터)에서 수행해야할 작업입니다!
    firefox > https://www.mysql.com/ > downloads > Community > MySQL Connectors > Connector/J
    > Select Operaing System : Platform Independent
    > Platform Independent (Architecture Independent), ZIP Archive Download
    > 압축 풀기 > mysql-connctor-java-폴더 > mysql-connector-java-version.jar 파일 Copy
    > /usr/java/jdk1.8.0_211-amd64/jre/lib/ext 위치에 붙여넣기
```

```
    자신의 Server On > mysql start
    04.서블릿을 통해 받아온 내용 출력하기 > cmd(명령 프롬프트) 실행
    > javac *.java
    > Server의 /usr/tomcat/webapps/ROOT/WEB-INF/classes 에 GetServlet.class, Person.class를 Copy
    > Server의 /usr/tomcat/bin > ./shutdown.sh > ./startup.sh
    > java Main
```

### 05.파일, 네트워크, 데이터베이스, 서블릿 통합
<p>사전 작업이 필요합니다.</p>

- 03.데이터베이스 내용 출력하기, 04.서블릿을 통해 받아온 내용 출력하기 프로젝트를 먼저 수행하세요.
- 서버가 없고, Tomcat을 어떻게 설치해야하고, Tomcat을 수행하는 방법을 모르시면 다음 링크를 따라 해주세요.<br>
[우리 함께 Servlet에 대해서 알아봅시다!](https://www.youtube.com/playlist?list=PLnae-xjNaVaYND3eKBV4DXrLOQBeXmwyl)
- servlet-api jar 파일이 Server의 외부 라이브러리에 또 포함 되어 있어야합니다.<br>
이유 : 04.프로젝트는 Server에서 DB를 접속해서 서버 DB Connector를 포함했지만 이제 Server에서 Servlet 코드를 작성해 컴파일 해야 하기 때문에  Server에 servlet-api jar 파일이 필요합니다.
```
    Server(서버 컴퓨터)에서 수행해야할 작업입니다!
    > /usr/tomcat/lib > servlet-api.jar Copy
    > /usr/java/jdk1.8.0_211-amd64/jre/lib/ext 위치에 붙여넣기
```

```
    자신의 Server On > mysql start
    05.파일, 네트워크, 데이터베이스, 서블릿 통합 > cmd(명령 프롬프트) 실행
    Client.java 에서 원하는 코드에서 주석을 제거
    > javac *.java
    > Server의 /usr/tomcat/webapps/ROOT/WEB-INF/classes 에 ServletObject.class, Person.class를 Copy
    > Server의 /usr/tomcat/bin > ./shutdown.sh > ./startup.sh
    > java Client
```

### 06.JSON을 이용해 서블릿 통신하기
<p>사전 작업이 필요합니다.</p>

- 03.데이터베이스 내용 출력하기, 04.서블릿을 통해 받아온 내용 출력하기 프로젝트를 먼저 수행하세요.
- Clinet(내 컴퓨터), Server(서버 컴퓨터)에서 둘 다 컴파일이 가능하게 하기 위해서 다음 jar 파일을 다운로드 해주세요.
- [jacksonJAR파일다운!](https://mvnrepository.com/search?q=jackson)
- (1. Jackson Databind, 2. Jackson Core, 3. Jackson Annotations) 3개를 다운로드 해주세요.
- 본 프로젝트(#06)를 실행하는 방법에 대해 잘 모르신다면 다음 링크를 따라 해주세요.<br>
[우리 함께 JSON으로 Servlet 통신을 해봅시다!](https://www.youtube.com/playlist?list=PLnae-xjNaVaYND3eKBV4DXrLOQBeXmwyl)<br>
(아직 강의 영상을 찍지 못했음.)
```
    Server(서버 컴퓨터)에서 수행해야할 작업입니다!
    > /usr/java/jdk1.8.0_211-amd64/jre/lib/ext > 다운로드 받은 파일 3개 Copy
    Client(내 컴퓨터)에서 수행해야할 작업입니다!
    > C:\Program Files\Java\jdk1.8.0_191\jre\lib\ext > 다운로드 받은 파일 3개 Copy
    > C:\Program Files\Java\jre1.8.0_191\lib\ext > 다운로드 받은 파일 3개 Copy

```

```
    자신의 Server On > mysql start
    06.JSON을 이용해 서블릿 통신하기 > cmd(명령 프롬프트) 실행
    > javac *.java
    > Server의 /usr/tomcat/webapps/ROOT/WEB-INF/classes 에 ServletJson.class, Person.class를 Copy
    > Server의 /usr/tomcat/bin > ./shutdown.sh > ./startup.sh
    > java Client
```
<p>질문 : JSON으로 통신한다면서 왜 Person.java 클래스가 있는거죠?!?<br>
답 : Client.java 코드를 보시면 아시겠지만 Person 객체를 이용한 코드는 전혀없습니다. 따라서 Server에만 Person객체를 이용하도록 되어있습니다.<br>
이전 까지의 프로젝젝트는 Client, Server 둘다 person 객체를 이용 했지만 이 프로젝트는 Server에서만 이용한 것을 알 수 있습니다.</p>