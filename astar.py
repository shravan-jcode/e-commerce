import heapq

graph = {
    'A':{'Z':75,'T':118,'S':140},
    'B':{'U':85,'G':90,'P':101,'F':211},
    'C':{'D':120,'P':138,'R':146},
    'D':{'M':75,'C':120},
    'E':{'H':86},
    'F':{'S':99,'B':211},
    'G':{'B':90},
    'H':{'E':86,'U':98},
    'I':{'N':87,'V':92},
    'L':{'M':70,'T':111},
    'M':{'L':70,'D':75},
    'N':{'I':87},
    'O':{'Z':71,'S':151},
    'P':{'R':97,'B':101,'C':138},
    'R':{'S':80,'P':97,'C':146},
    'S':{'R':80,'F':99,'A':140,'O':151},
    'T':{'L':111,'A':118},
    'U':{'B':85,'H':98,'V':143},
    'V':{'I':92,'U':142},
    'Z':{'O':71,'A':75}
}

heuristic = {'A':336,'B':0,'C':160,'D':242,'E':161,'F':176,'G':77,'H':151,
             'I':226,'L':244,'M':241,'N':234,'O':380,'P':100,'R':193,'S':253,
             'T':329,'U':80,'V':199,'Z':374}

def a_star(start, goal):
    open_list = []
    heapq.heappush(open_list, (heuristic[start], 0, [start]))  # (f, g, path)
    
    while open_list:
        f, g, path = heapq.heappop(open_list)
        node = path[-1]
        if node == goal:
            return path, g
        for neighbor, cost in graph.get(node, {}).items():
            if neighbor not in path:
                new_g = g + cost
                new_f = new_g + heuristic[neighbor]
                heapq.heappush(open_list, (new_f, new_g, path + [neighbor]))


path, total_cost = a_star('A','B')
print("A* path:", path)
print("Total cost:", total_cost)

# ------------------------------------------------------
# RBFS
import math

def rbfs(node, goal, path, f_limit):
    if node == goal:
        return path, 0  # path found
    successors = []
    for neighbor, cost in graph.get(node, {}).items():
        if neighbor not in path:
            g = sum(graph[path[i]][path[i+1]] for i in range(len(path)-1)) + cost
            f = g + heuristic[neighbor]
            successors.append((neighbor, path + [neighbor], f))
    if not successors:
        return None, math.inf
    successors.sort(key=lambda x: x[2])  # sort by f
    while successors:
        best = successors[0]
        if best[2] > f_limit:
            return None, best[2]
        alternative = successors[1][2] if len(successors) > 1 else math.inf
        result, best_f = rbfs(best[0], goal, best[1], min(f_limit, alternative))
        successors[0] = (best[0], best[1], best_f)
        if result:
            return result, best_f
        successors.sort(key=lambda x: x[2])

path, _ = rbfs('A','B',['A'], math.inf)
print("RBFS path:", path)


