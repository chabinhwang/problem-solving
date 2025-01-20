N, S = map(int, input().split())
arr = list(map(int, input().split()))
sep = []
result = 0


def backtracking(idx):
    global result
    if sum(sep) == S and len(sep) > 0:
        result += 1
    for i in range(idx, N):
        sep.append(arr[i])
        backtracking(i + 1)
        sep.pop()


backtracking(0)
print(result)
