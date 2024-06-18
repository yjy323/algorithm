def rotate_matrix_by_90_degree(arr):
	n = len(arr)
	m = len(arr[0])
	result = [[0] * n for _ in range(m)]
	for i in range(n):
		for j in range(m):
			result[j][n - i - 1] = arr[i][j]
	return result
