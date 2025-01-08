from sys import stdin
def input():
    return stdin.readline().rstrip()
N=int(input())
nums = list(map(int,input().split()))
# nums정렬->set으로 중복 제거->다시list로
sorted_list=sorted(list(set(nums)))
sorted_dict={sorted_list[i] : i for i in range(len(sorted_list))}
# 출력
for i in nums:
    print(sorted_dict[i],end=" ")
