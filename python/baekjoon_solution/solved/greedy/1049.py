"""
입력:
기타줄 갯수, 기타줄 브랜드
6개 세트 가격, 1개 단품 가격
모든 매장 활용해서 가장 싸게 사면 됨.
"""

from sys import stdin


def input():
    return stdin.readline().rstrip()


N, M = map(int, input().split())  # 필요 기타줄 N개
package_min = float("inf")
piece_min = float("inf")
for _ in range(M):
    package_price, piece_price = map(int, input().split())
    package_min = min(package_min, package_price)
    piece_min = min(piece_min, piece_price)

A = N // 6
B = N % 6

print(
    min(
        A * package_min + B * piece_min,
        N * piece_min,
        (A + 1) * package_min
    )
)