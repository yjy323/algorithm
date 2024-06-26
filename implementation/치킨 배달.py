'''
	1회 20240626
	2회
	3회

	아이디어
		1. 완전 탐색
		2. 주어진 정보를 입력받고 적절한 자료구조로 변환한다.
			1. 리스트로 집, 치킨집의 좌표를 각각 저장한다.
		3. 전체 치킨 집의 수를 k, 최대 치킨 집의 수를 m이라고 할 때, kCm의 경우만큼 치킨 거리를 계산한다.
			1. 조합의 모든 경우의 수에 대해 치킨 거리를 계산한다.
			2. 이 때 시간 복잡도는 O(kCm * (2n * m))이다. 집의 개수는 최대 2n이다.
'''
from itertools import combinations

n, m = map(int, input().split())
home, chicken = [], []

for r in range(n):
	data = list(map(int, input().split()))
	for c in range(n):
		if data[c] == 1:
			home.append((r, c))
		elif data[c] == 2:
			chicken.append((r, c))

candidates = list(combinations(chicken, m))

def distance(coord1, coord2):
	return abs(coord1[0] - coord2[0]) + abs(coord1[1] - coord2[1])

def chicken_dist(candidate):
	sum_dist = 0
	for h in home:
		dist = 1e10
		for c in candidate:
			dist = min(dist, distance(h, c))
		sum_dist += dist
	return sum_dist
		
min_chicken_dist = 1e10
for candidate in candidates:
	min_chicken_dist = min(min_chicken_dist, chicken_dist(candidate))
print(min_chicken_dist)
