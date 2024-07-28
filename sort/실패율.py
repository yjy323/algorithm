'''
	1회 20240727
	2회
	3회

	아이디어
		1.
'''

def solution(N, stages):
    answer = []
    length = len(stages)
    for i in range(1, N + 1):
        count = stages.count(i)
        fail = count / length if length > 0 else 0
        answer.append((i, fail))
        length -= count
    answer.sort(key = lambda x:(-x[1], x[0]))
        
    return [x[0] for x in answer]
    	

print(solution(4, [4, 4, 4, 4, 4]))
