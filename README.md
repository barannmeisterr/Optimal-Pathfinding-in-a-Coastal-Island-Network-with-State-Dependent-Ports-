# Optimal Pathfinding in a Coastal Island Network with State-Dependent Ports

This project aims to solve the problem of finding the lexicographically smallest path that takes the minimum amount of time to travel between two islands in a coastal city. The city consists of N islands connected by M undirected boat routes. Each island has a port that alternates between two states: loading and running.

Loading State: Passengers board the boats.
Running State: Boats depart to the next island.
All ports switch states simultaneously every T minutes, starting in the running state. The travel time between any two connected islands is a constant C minutes.

Given the initial configuration of the islands, connections, and the specified starting and ending islands, the objective is to determine the optimal path in terms of both time efficiency and lexicographical order.

## Author

- Arda Baran

  
## Features
- Parsing the input to extract the number of islands, connections, state-switch interval, and travel time.
- Modeling the network of islands and their connections.
- Implementing an algorithm to find the lexicographically smallest path that minimizes travel time,considering the alternating port states. 
- Careful attention to the timing of port state changes and the synchronization of travel plans to ensure the minimal and optimal path is found. 

## Technologies And Data Structures Used
- Java
- Undirected Graph
- Array
- Two Dimensional Array For Adjacency Matrix
- Stack Array Implementation
- Queue Array Implementation
- BFS Algorithm
- DFS Algorithm
- Object Oriented Programming
  

## File Structure
- src/: Contains the Java source code
