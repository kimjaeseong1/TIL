## DAY 1 Git

#목표
`
- git을 사용하기 위해 CLI Shell command와 Vim editor를 다룰 수 있다.

- 코드 관리를 위한 git의 정확한 사용법을 이해한다.

- git의 저장소 개념을 이해하고, 원격 저장소 서비스의 차이를 인식한다.

- git을 사용하면서 발생하는 다양한 상황을 해결할 수 있다.

- commit의 보편적인 작성법을 이해하고 이를 활용하여 commit을 작성할 수 있다.

- hexo를 활용하여 github pages에 blog를 생성하고 포스트를 작성할 수 있다.

- git의 branch model을 활용해 능숙하게 코드관리할 수 있다.

- git의 다양한 branch 전략을 이해하고 널리 사용되는 git flow 전략을 활용하여 프로젝트를 수행할 수 있다.

- github projects와 issue로 프로젝트 이슈를 관리할 수 있다.

- git으로 타인과 협업하며, 다른 프로젝트에 기여할 수 있다.`




#기초 shell Command
- ls 	: 해당 위치에 하위폴더를 볼 수 있음
- ls -a : 숨김파일 까지 볼 수 있다. 
- ls -l	: 하위폴더들의 속성을 볼  있다.
- mkdir : 디렉토리 생성
- touch : 파일을 생성을 할 수 있다.
- mv 	: 파일을 이동을 시킬 수 있다
- rm	: 파일을 삭제할 수 있다.

#vi command
- YY 		: 커서가 있는 줄 복사
- x 		: 커서 오른쪽 글자 살게 (delete키와 동일)
- :w 		: 저장
- :w 파일명 	: 해당 이름으로 저장
- :q 		: 종료
- :wq 		: 저장하고 종료

# vi서 사용하는  git 명령어
- git status
- git add 파일명 
- git commit
- git push origin main

# commit 할 때 기억해야 할것
- commit은 동작 가능한 최소단위로 자주 할 것.
- 해당 작업단위에 수행된 모든 파일 변화가 해당 commit에 포함되어야 함.
- 모두가 이해할 수 있는 log를 작성할 것.
- Open Source Contribution시 영어가 강제되지만, 그렇지 않을 경우 팀 내 사용 언어를따라 쓸 것.
- 제목은 축약하여 쓰되(50자 이내), 내용은 문장형으로 작성하여 추가설명 할 것.
- 제목과 내용은 한 줄 띄워 분리할 것.
- 내용은 이 commit의 구성과 의도를 충실히 작성할 것.

# README.md
- 프로젝트와 Repository를 설명하는 책의 표지와 같은 문서 
- 나와 동료, 이 repo의 사용자를 위한 문서 

# LICENSE
- 오픈소스 프로젝트에서 가장 중요한 License는 내가 만들 때에도, 배포할 때에도 가장 신경써야 하는 일 중 하나다. 
가장 많이 사용하는 License는 다음과 같다
 - MIT License
  - MIT에서 만든 라이센스로, 모든 행동에 제약이 없으며, 저작궈자는 소프트웨어와     책입에서 자유롭다
 - Apache License 2.0
  - Apache 재단이 만든 라이센스로, 특허권 관련 내용이 포함되어있다. 
 - Gnu General Public License v3.0
  - 가장 많이 알려져있으며, 의무사항(해당 라이센스가 적용된 소스코드 사용시 GPL	    을 따라야 함) 이 존재함 

# .gitignore
- git 이 파일을 추적할 때, 어떤 파일이나 폴더 등을 추적하지 않도록 명시하기 위해 작성하며, 해당 문저세 작성된 리스트는 수정사항이 발생해도 git이 무시하게된다.
- 특정 파일 확장자를 무시하거나 이름에 패턴이 존재하는 경우, 또는 특정 디렉터리 아래의 모든 파일을 무시할 수 있다. 


# Branch

- 분기점을 생성하여 독립적으로 코드를 변경할 수 있도록 도와주는 모델

-- 명령어
- git branch 	: 지금 branch가 어떤 branch 인지 알려주고 다른 branch가 있다면 보여준다.
  git branch 뒤에 내가 지정하고 싶은 이름을 적으면 branch 내가 지정하고 싶은 이름으로 생성된다.
- git switch	: git switch branch name을 적으면 해당 branch로 이동 할 수 있다. 
- git branch -D	: branch를 지울 수 있다. 
- git merge	: 같은 이름인 파일의 내용을 합칠 수 있다. 


## 느낀점 

 ● 국비 들어가기전 리눅스를 공부 했을 때 배웠던 명령어들을 다시 봐서 반가웠고 옛 기억들이 새록새록 나면서 나름 재미 있었고 git hub를 왜 열심히 사용법을 익혀야 하는지도 느끼게 된 하루였다.
