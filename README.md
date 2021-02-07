# Calculator

This is a command-line RPN calculator.

## How to use

Build with mvn 
```bash
mvn clean install
```
Start with 
```bash
java -jar target/calculator-1.0-SNAPSHOT.jar
```

## Examples

### Example 1
```bash
5 2
stack: 5 2
```

### Example 2
```bash
2 sqrt
stack: 1.4142135623 
clear 9 sqrt
stack: 3
```

### Example 3
```bash
5 2 - 
stack: 3 
3 - 
stack: 0 
clear 
stack:
```


### Example 4
```bash
5 4 3 2
stack: 5 4 3 2 
undo undo * 
stack: 20
5 *
stack: 100 
undo
stack: 20 5
```


### Example 5
```bash
7 12 2 / 
stack: 7 6 
*
stack: 42 4 /
stack: 10.5
```

### Example 6
```bash
1 2 3 4 5
stack: 1 2 3 4 5 
*
stack: 1 2 3 20 
clear 3 4 - 
stack: -1
```


### Example 7
```bash
1 2 3 4 5
stack: 1 2 3 4 5 
* * * *
stack: 120
```


### Example 8
```bash
1 2 3 * 5 + * * 6 5
operator * (position: 15): insufficient parameters 
stack: 11
```

