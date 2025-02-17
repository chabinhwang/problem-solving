from sys import stdin
def input():
    return stdin.readline().rstrip()

N=int(input())
# 정렬시 int 지정 안하면 문자열로 인식 - 숫자 크기순이 아니라 문자 사전식으로 정렬 주의 요망
user_list=sorted(list(input().split() for _ in range(N)), key=lambda x:int(x[0]))

for i in user_list:print(*i)