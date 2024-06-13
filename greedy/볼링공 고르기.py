'''
	1회 20240613
	2회
	3회

	아이디어
		1. 공의 무게는 최대 10으로 정해져 있다.
		2. 무게 별로 공이 몇개씩 주어졌는지 리스트에 저장한다.
		3. 조합의 원리를 이용해 낮은 무게부터 특정한다.
'''

n,m = map(int, input().split())
data = list(map(int, input().split()))
arr = [0] * 11

for i in data:
	arr[i] += 1

result = 0
for i in range(1, n + 1):
	n -= arr[i]
	result += n * arr[i]
print(result)
