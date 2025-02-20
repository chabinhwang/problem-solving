"""
큰 수를 R, 작은수가 L일 때.
맨 앞자리부터 8이 연속으로 몇 개 있나 확인
"""

from sys import stdin


def input():
    return stdin.readline().rstrip()


L, R = map(int, input().split())
count = 0
temp = 0
flag = False
for i in range(11):
    if L // (10 ** (10 - i)) and R // (10 ** (10 - i)):  # 자릿수가 같은지 확인
        if (
            L // (10 ** (10 - i)) % 10 == R // (10 ** (10 - i)) % 10 == 8
        ):  # 그 자릿수가 8로 같다면
            if flag:  # 이어지고있다면
                count += 1
            else:  # 처음이면
                flag = True
                count += 1
        elif L // (10 ** (10 - i)) % 10 != R // (10 ** (10 - i)) % 10:
            # 자릿수가 같은데, 첫부분이 같지 않다면. e.g: 188 ~ 288
            break
        else:# 자릿수가 같은데, 첫부분이 같다면. e.g: 288 ~ 289
            continue
    elif R // (10 ** (10 - i)):  # 자릿수가 다르다면
        break

print(count)
