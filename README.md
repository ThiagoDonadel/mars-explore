# Mars Exploration

This project represent a robot that is used by NASA engineers to explore the mars terrain. 
A command is sent to robot to move and at the end of the movement it returns to the position where it stopped.

## How to run 

To run this project first clone this repository, then use the following command to compile:

```
.\mvnw clean install
```

Then to run use the following command:

```
java -jar .\target\mars-explore.jar
```

## How to use

To send messages to the robot use the following endpoint:

```
http://localhost:8080/rest/mars/{command}
```

The command parameter is a combination of three possible letters:

> **R:** Make the robot rotate to right 

> **L** Make the robot rotate to left

> **M** Make the robot walk one position to the side (NORTH, SOUTH, EAST, WEST) he is facing.

**Important:** 
The robot always start at (0,0,N)
The allowed range of movement is a matrix of 5x5 
 
**Examples:**

```
http://localhost:8080/rest/mars/MMRMMRMM 
Output: (2, 0, S)
```

```
http://localhost:8080/rest/mars/MML 
Output: (0, 2, W)
```

```
http://localhost:8080/rest/mars/AAA 
Output: 400 Bad Request
```

```
http://localhost:8080/rest/mars/MMMMMMMMMMMMMMMMMMMMMMMM 
Output: 400 Bad Request
```