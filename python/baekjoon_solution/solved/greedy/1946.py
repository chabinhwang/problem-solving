"""
문제 이해하기 어려운 문제. [남들보다 하나라도 잘하는게 있는 사람]을 채용하겠다는 뜻. 1등 4등과 2등 3등이 있으면 둘다 채용. 
전자는 서류가 2등보다 1단계 높고 후자는 면접이 4등보다 1단계 높기 때문. 단, 5등 5등은 불합
지원자 숫자가 최대 10만명, 테스트 케이스 갯수는 20개. 최대 200만개의 데이터 존재.
풀이 과정: 
서류 등수로 정렬 하고, 순회하면서 가장 낮은 면접등수가 있으면 업데이트
    ㄴ 서류 등수로 정렬했는데 (서류 1등)[0][1] 보다 면접등수가 낮으면, 합격조건(최소 하나라도 잘해라)임.
        또한 그 점수를 최고등수로 초기화하고 탐색 계속 진행. 1회 순회시 결과 도출.
"""
from sys import stdin

def input():
    return stdin.readline().rstrip()


T = int(input())

result = []
for _ in range(T):
    N = int(input())
    # 서류 등수로 정렬된 모든 유저
    all_emp = sorted(list((list(map(int, input().split()))) for _ in range(N)), key=lambda x: x[0])

    # 합격자
    pass_num=1
    
    # 가장 낮은 면접등수
    max_prize=all_emp[0][1]
    
    for i in range(1,N):
        if max_prize > all_emp[i][1]:
            max_prize=all_emp[i][1]
            pass_num+=1
    print(pass_num)
    
    



