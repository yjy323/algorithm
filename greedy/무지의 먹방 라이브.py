'''
	프로그래머스 Lv.4
  
	1회 20240613
	2회
	3회

	아이디어
		1. 현재 상태까지 먹방한 시간의 합이 k를 넘지 않을 때까지 그리디 알고리즘을 적용한다.
    2. 현재 상태에서 최선(최소 값)의 값을 이용해 업데이트한다.
    3. previous = now, sum_times += (now - previous)는 그리디하게 증명된다.
'''

import heapq

def solution(food_times, k):
    if sum(food_times) <= k:
        return -1
    
    answer = 0
    
    q = []
    for i, t in enumerate(food_times):
        heapq.heappush(q, (t, i + 1))
    
    sum_times = 0
    previous = 0
    n = len(food_times)
    while sum_times + ((q[0][0] - previous) * n) <= k:
        now = heapq.heappop(q)[0]
        sum_times += (now - previous) * n
        previous = now
        n -= 1
    
    answer = sorted(q, key=lambda x:x[1])
    return answer[(k - sum_times) % n][1]
