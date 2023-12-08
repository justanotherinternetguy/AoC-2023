def parse_input(input_str):
    lines = input_str.strip().split('\n')
    instructions = lines[0].strip()
    nodes = {}
    
    for line in lines[1:]:
        parts = line.strip().split(' = ')
        node_name = parts[0]
        connections = tuple(parts[1].split(', '))
        nodes[node_name] = connections

    return instructions, nodes

def navigate_network(instructions, nodes):
    current_node = 'AAA'
    steps = 0
    
    for instruction in instructions:
        if instruction == 'L':
            current_node = nodes[current_node][0]
        elif instruction == 'R':
            current_node = nodes[current_node][1]
        
        steps += 1

    return steps

def main():
    with open('test.in', 'r') as file:
        puzzle_input = file.read()

    instructions, nodes = parse_input(puzzle_input)
    total_steps = navigate_network(instructions, nodes)

    print(f"Total steps to reach ZZZ: {total_steps}")

if __name__ == "__main__":
    main()
