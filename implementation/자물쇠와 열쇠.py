'''
	1회 20240615
	2회 20240618
	3회

	아이디어
		1. 완전 탐색: N과 M이 충분히 작기 때문이다.
    2. 열쇠를 90도씩 회전한다.
    3. 열쇠의 일부분을 이용해 자물쇠를 열 수 있다는 조건을 이용하기 위해 데이터를 수정한다.
    	1. 자물쇠에 0 패딩을 준다.
      2. 이 때, 최대 3배수로 패딩을 준다.(M < N)
    4. 모든 자물쇠 영역에 완전탐색을 수행한다.
    	1. 자물쇠를 열 수 있는지 확인한다.
      	1. 자물쇠와 열쇠를 합 연산한다.
      	2. 자물쇠의 모든 영역이 1이라면 열린다.
'''

def rotate_matrix_by_90_degree(a):
    n = len(a)
    m = len(a[0])
    rot = [[0] * n for _ in range(m)]
    for i in range(n):
        for j in range(m):
            rot[j][n - 1 - i] = a[i][j]
    return rot

def is_open(new_lock):
    n = len(new_lock) // 3
    for i in range(n, n * 2):
        for j in range(n, n * 2):
            if new_lock[i][j] != 1:
                return False
    return True

def solution(key, lock):
    n = len(lock)
    m = len(key)
    new_lock = [[0] * (n * 3) for _ in range(n * 3)]
    for i in range(n):
        for j in range(n):
            new_lock[i + n][j + n] = lock[i][j]
    for _ in range(4):
        key = rotate_matrix_by_90_degree(key)
        for ni in range(n * 2):
            for nj in range(n * 2):
                
                for mi in range(m):
                    for mj in range(m):
                        new_lock[ni + mi][nj + mj] += key[mi][mj]
                if is_open(new_lock) is True:
                    return True
                for mi in range(m):
                    for mj in range(m):
                        new_lock[ni + mi][nj + mj] -= key[mi][mj]
    return False


