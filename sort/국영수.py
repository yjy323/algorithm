'''
	1회 20240727
	2회
	3회

	아이디어
		1.
'''

n = int(input())
for score in sorted([list(input().split()) for _ in range(n)], key = lambda x:(-int(x[1]), int(x[2]), -int(x[3]), x[0])):
	print(score[0])
