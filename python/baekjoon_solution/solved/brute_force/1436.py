from sys import stdin
def input():
    return stdin.readline().rstrip()
N=int(input())
arr=[]
for i in range(666,99999999999999):
    if '666'in str(i):
      arr.append(i)
    if len(arr)==N:
        break
print(arr[-1])