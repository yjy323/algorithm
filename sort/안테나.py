'''
	1회 20240728
	2회
	3회

	아이디어
		1. 수학적인 풀이
		2. 한 점과 다른 모든 점 사이의 거리의 합을 구할 때, 중앙값(Median)은 항상 그 합이 최소임을 보장한다.
'''

n = int(input())
village = list(map(int, input().split()))
village.sort()

print(village[(n - 1) // 2])
