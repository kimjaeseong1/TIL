## git flow

# git-flow란?
git-flow는 Vincent Driessen의 "A successful git branching model"이라는 글에서 제안한 브랜치 모델을 쉽게 사용할 수 있도록 몇개의 명령으로 구현해 놓은 git의 확장이다. 간단한 명령을 이용해서 VincentDriessen의 브랜치 모델에서 필요한 브랜칭 동작들을 수행 할 수 있다. 

## git-flow는 총 5가지 브랜치를 사용해서 운영! 
- master  : 기준이 되는 브랜치로 제품을 배포하는 브랜치 입니다.
- develop : 개발 브랜치로 개발자들이 이 브랜치를 기준으로 각자 작업한 기능들을 합(Merge)칩니다.
- feature : 단위 기능을 개발하는 브랜치로 기능 개발이 완료되면 develop 브랜치에 합칩니다.
- release : 배포를 위해 master 브랜치로 보내기 전에 먼저 QA(품질검사)를 하기위한 브랜치 입니다.
- hotfix  : master 브랜치로 배포를 했는데 버그가 생겼을 떄 긴급 수정하는 브랜치 입니다.


- master와 develop가 중요한 매인 브랜치이고 나머지는 필요에 의해서 운영하는 브랜치라고 보시면 됩니다.
출처: https://ux.stories.pe.kr/183 [UX 공작소:티스토리]

## git flow strategy


## use git flow


# git 사용법 
1. 먼저 github에서 new repository를 만들어주고 주고를 복하해서 
git bash에서 git clone 복사한 주소 해가지고 디렉토리 생성을 해준다. 

2. main branch에서 .gitignore 파일 생성하고  설정해주기! 
 gitignore에 필요한 설정들은 gitignore.io에서 할 수 있다. 
 
3. .gitignore 파일 git add, commit 진행하기 

4. git flow init  초기화 진행 그럼 develop branch 생성되고 이동을 하는데 거기서 새기능 시작해야한다. 

5. git flow feature start name(하고 싶은 이름) 명령어로 새기능 시작하기 

6. 기능완료(git flow feature finish name(하고 싶은 이름))
- 기능개발을 완료하고 다음 작업을 수행한다. 

7. release 시작 
- git flow release start RELEASE [BASE]
- 릴리스를 시작하려면 git flow의 release 명령을 사용합니다.
  'develop' 브랜치로부터 'release' 브랜치를 생성합니다.

 8. release 완료
- git flow release finish RELEASE
- 'release' 브랜치를 'master' 브랜치에 병합(merge)
- 릴리스를 릴리스 이름으로 태그(tag)
- 릴리스를 'develop' 브랜치로 재병합(back-merge)
- git push --tags를 사용해 태그들을 push하는 것을 잊으면 안된다. 

## github flow
- 'release' 브랜치를 'master' 브랜치에 병합(merge)
- 릴리스를 릴리스 이름으로 태그(tag)
- 릴리스를 'develop' 브랜치로 재병합(back-merge)

## github flow
- 'release' 브랜치를 'master' 브랜치에 병합(merge)
- 릴리스를 릴리스 이름으로 태그(tag)
- 릴리스를 'develop' 브랜치로 재병합(back-merge)
