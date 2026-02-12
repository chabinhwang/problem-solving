<!-- 백준 티어표 (v2.0) -->
<div align="center">
  <img src="http://mazassumnida.wtf/api/v2/generate_badge?boj=chabin37" alt="백준티어"/>
</div>


# 📚 코딩 테스트 연습 리포지토리


## 🚀 소개
이 리포지토리는 코딩 테스트와 기술 인터뷰 준비를 위해 풀었던 알고리즘 문제와 솔루션을 모아둔 공간입니다. 문제 해결 과정을 기록하고, 학습한 내용을 체계적으로 관리하기 위해 제작되었습니다.


## 🗂️ 리포지토리 구조

리포지토리는 다음과 같은 구조로 구성되어 있습니다:
```
📂 /JAVA
   ├── 📂 BackTracking (백트래킹)
   ├── 📂 BFS (너비 우선 탐색)
   ├── 📂 DataStructure (자료구조)
   ├── 📂 DFS (깊이 우선 탐색)
   ├── 📂 Dynamic Programming (동적 계획법)
   ├── 📂 Greedy (탐욕법)
   ├── 📂 Sorting (정렬)
   ├── 📂 String (문자열)
   ├── 📂 ect (기타)
   └── 📂 복사용

📂 /python
   ├── 📂 baekjoon_solution
   │   ├── 📂 not_solved (미해결)
   │   └── 📂 solved (해결완료)
   ├── 📂 KUPC2023
   └── 📂 solve_with_programming_1_2

📂 /SQL
   └── 📂 programmers
```

## 🏆 목표
- 알고리즘 문제 해결 능력 향상
- 코딩 인터뷰 완벽 준비
- 다양한 프로그래밍 패러다임 탐구 및 구현
<br>

## VSCode 자동완성 방지
> 폴더 내 .vscode 폴더에 settings.json 파일을 생성하고 아래 내용을 추가

```JSON
{
    "editor.quickSuggestions": false,
    "editor.suggestOnTriggerCharacters": false,
    "editor.wordBasedSuggestions": false,
    "editor.parameterHints.enabled": false,
    "editor.suggest.snippetsPreventQuickSuggestions": false,
    "editor.snippetSuggestions": "none",
    "editor.hover.enabled": false,
    "github.copilot.enable": false
}
```

> 혹은, .code-workspace 파일의 settings에 아래 내용을 추가
```JSON
{
    "editor.quickSuggestions": {
        "comments": "off",
        "strings": "off",
        "other": "off"
    },
    "editor.suggestOnTriggerCharacters": false,
    "editor.wordBasedSuggestions": "off",
    "editor.parameterHints.enabled": false,
    "editor.suggest.snippetsPreventQuickSuggestions": false,
    "editor.snippetSuggestions": "none",
    "github.copilot.enable": false,
    "editor.hover.enabled": "off",
    "editor.acceptSuggestionOnEnter": "off",
    "editor.tabCompletion": "off",
    "editor.inlineSuggest.enabled": false,
    "editor.codeLens": false,
    "editor.lightbulb.enabled": "off"

}
```