'''
	1회 20240728
	2회
	3회

	아이디어
		1.
'''
import heapq
import sys

input = sys.stdin.readline

n = int(input())
cards = list(int(input()) for _ in range(n))
heapq.heapify(cards)

answer = 0
while len(cards) > 1:
	count = heapq.heappop(cards) + heapq.heappop(cards)
	answer += count

	heapq.heappush(cards, count)
print(answer)
