graph = {
    'A':['Z','S','T'], 'B':['U','P','G','F'], 'C':['D','R','P'], 'D':['M'],
    'E':['H'], 'I':['N','V'], 'L':['M','T'], 'O':['S','Z'], 'P':['R','C','B'],
    'R':['S','C','P'], 'S':['A','O','R','F'], 'T':['A','L'], 'U':['B','H','V'],
    'V':['U','I'], 'Z':['A','O'], 'M':['L','D'], 'F':['S','B'], 'G':['B'], 'N':['I']
}



def bfs(graph, start, goal):
    queue = [[start]]
    visited = set()
    while queue:
        path = queue.pop(0)
        node = path[-1]
        if node == goal:
            return path
        if node not in visited:
            visited.add(node)
            for neighbor in graph[node]:
                queue.append(path + [neighbor])

print("BFS:", bfs(graph, 'A', 'B'))


def dfs(graph, start, goal):
    stack = [(start, [start])]
    visited = set()
    while stack:
        node, path = stack.pop()
        if node == goal:
            return path
        if node not in visited:
            visited.add(node)
            for neighbor in graph[node]:
                stack.append((neighbor, path + [neighbor]))

print("DFS:", dfs(graph, 'A', 'B'))



