# The Monty Hall Problem
This program simulates the Monty Hall Problem a chosen number of times and gives the results of how many times the contestant would win by sticking with their first choice or changing their choice after a non-winning box has been revealed.

To read about the Monty Hall Problem, please visit https://en.wikipedia.org/wiki/Monty_Hall_problem.

## Assumptions

Only three boxes are being used.

## To run

Maven is used to compile and run.

First compile the program using:\
```mvn compile```

Then use one of the following commands to run the compiled program

To run with default number of tries (10 000 000):\
```mvn exec:java -Dexec.mainClass="com.robinch.montyhall.client.Client"```

To run with a custom number of times replace `{NR_OF_TIMES}` with that custom number:\
```mvn exec:java -Dexec.mainClass="com.robinch.montyhall.client.Client" -Dexec.args="{NR_OF_TIMES}"```


## To Test
To test the app use:\
`mvn test`
