'''
	1회 20240611
	2회
	3회

	아이디어
		1. 공포도 기준 오름차순 정렬한다.
		2. 모험을 떠나기 위한 조건을 만족하는지 순차적으로 검증한다.
			- 같은 그룸의 인원을 매 반복마다 1씩 카운트한다.
			- 같은 그룹의 인원이 현재 공포도와 크거나 같다면 모험을 떠나기 위한 조건을 만족한다.
				- data가 정렬되어있고, m은 1씩 카운트되기 때문에 크다 조건은 필요없다고 생각한다.
			- 조건을 만족한다면 그룹을 초기화한다.
'''

import sys
input = sys.stdin.readline

n = int(input().rstrip())
data = list(map(int, input().split()))
data.sort()

group = 0
m = 0
for v in data:
	m += 1
	if m >= v:
		m = 0
		group += 1

print(group)
