"""
키가 1인 사람부터 차례대로 [자기보다 키가 큰 사람이 왼쪽에 몇명] 있었는지 주어짐.
왼쪽에 본인보다 키 큰사람 몇명 있었는지 기억할 때, 키 순서.
    
sol : 0 칸 N개 만들고, n번째 사람이 m이면 본인 앞에 0이 m개 있어야 함. 무조건 0
"""

from sys import stdin


def input():
    return stdin.readline().rstrip()


N = int(input())
survey = list(map(int, input().split()))

# 사람들 위치 칸
people = [0] * N
for i in range(N):
    # i+1 번째 키의 사람 앞에 존재해야 하는 0의 갯수
    count = survey[i]
    count+=1 # 내가 들어갈 위치도 0이여야 함
    # 0이 index에 위치하면 count 깎고, 아니면 index+=1 해서 탐색. count가 0이 되면 index+=1에 i+1번째 사람이 위치함
    index = 0
    #print(f"{i+1}번째 사람 추가 시작. count = {count}, index = {index}")
    while count!=0:
        if people[index]==0:
            count-=1
            if count!=0:
                index+=1
            else:
                break
        else:
            index+=1
        
        #print(f"index={index},count={count}")
    people[index]=i+1
    #print(f"{i+1}번째 사람을 추가 한 뒤 people : {people}")
print(' '.join(map(str,people)))
