"""
| is a vertical pipe connecting north and south.
- is a horizontal pipe connecting east and west.
L is a 90-degree bend connecting north and east.
J is a 90-degree bend connecting north and west.
7 is a 90-degree bend connecting south and west.
F is a 90-degree bend connecting south and east.
. is ground; there is no pipe in this tile.
S is the starting position of the animal; there is a pipe on this tile, but your sketch doesn't show what shape the pipe has.
"""

# adj list

class Graph:
    def __init__(self):
        self.vertices = {}

    def add_vertex(self, vertex):
        if vertex not in self.vertices:
            self.vertices[vertex] = []

    # def add_edge(self, vertex1, vertex2):
    #     if vertex1 in self.vertices and vertex2 in self.vertices:
    #         if len(self.vertices[vertex1]) < 2 and len(self.vertices[vertex2]) < 2:
    #             self.vertices[vertex1].append(vertex2)
    #             self.vertices[vertex2].append(vertex1)
    #         else:
    #             print("Cannot connect more than two neighbors to a vertex.", vertex1, vertex2)
    def add_edge(self, vertex1, vertex2):
        if vertex1 in self.vertices and vertex2 in self.vertices:
            self.vertices[vertex1].append(vertex2)
            self.vertices[vertex2].append(vertex1)

    def length_between_vertices(self, start, end):
        if start not in self.vertices or end not in self.vertices:
            return -1  # Vertices not in the graph

        visited = set()
        queue = [(start, 0)]

        while queue:
            current, length = queue.pop(0)
            if current == end:
                return length

            visited.add(current)
            for neighbor in self.vertices[current]:
                if neighbor not in visited:
                    queue.append((neighbor, length + 1))

        return -1  # No path found
    
    def print_adj_list(self):
        for vertex, neighbors in self.vertices.items():
            print(f"{vertex} -> {neighbors}")

    def farthest_vertex(self, start):
        if start not in self.vertices:
            return None  # Start vertex not in the graph

        farthest = None
        max_distance = -1

        visited = set()
        queue = [(start, 0)]

        while queue:
            current, distance = queue.pop(0)
            visited.add(current)

            if distance > max_distance:
                farthest = current
                max_distance = distance

            for neighbor in self.vertices[current]:
                if neighbor not in visited:
                    queue.append((neighbor, distance + 1))

        return farthest


def find_index_with_substring(input_list, substring):
    for i, string in enumerate(input_list):
        if substring in string:
            return i
    return -1


def parse_input(filename):
    with open(filename, 'r') as file:
        lines = file.readlines()

    graph = Graph()

    for y, line in enumerate(lines):
        for x, char in enumerate(line.strip()):
            if char in '|-LJ7FS':
                vertex = (x, y)
                graph.add_vertex(vertex)

                if char == '|':
                    # Connect to the north and south
                    graph.add_edge(vertex, (x, y - 1))
                    graph.add_edge(vertex, (x, y + 1))
                elif char == '-':
                    # Connect to the east and west
                    graph.add_edge(vertex, (x - 1, y))
                    graph.add_edge(vertex, (x + 1, y))
                elif char == 'L':
                    # Connect to the north and east
                    graph.add_edge(vertex, (x, y - 1))
                    graph.add_edge(vertex, (x + 1, y))
                elif char == 'J':
                    # Connect to the north and west
                    graph.add_edge(vertex, (x, y - 1))
                    graph.add_edge(vertex, (x - 1, y))
                elif char == '7':
                    # Connect to the south and west
                    graph.add_edge(vertex, (x, y + 1))
                    graph.add_edge(vertex, (x - 1, y))
                elif char == 'F':
                    # Connect to the south and east
                    graph.add_edge(vertex, (x, y + 1))
                    graph.add_edge(vertex, (x + 1, y))
                elif char == 'S':
                    start_vertex = vertex
    return graph, start_vertex


if __name__ == "__main__":
#     with open("test.in", "r") as file:
#         f = file.read()
#         lines = f.splitlines()
#     s_row = find_index_with_substring(lines, "S")
#     s_col = lines[s_row].find("S")
#     print(s_row, s_col) # found
#     graph = Graph()
#     graph.add_vertex((s_row, s_col))
    parsed_graph, start_vertex = parse_input("test.in")
    # parsed_graph.print_adj_list()
    farthest = parsed_graph.farthest_vertex(start_vertex)
    print("Farthest vertex from starting position:", farthest)

    # Find the distance between the starting position and the farthest vertex
    distance = parsed_graph.length_between_vertices(start_vertex, farthest)
    print("Distance between start and farthest:", distance)