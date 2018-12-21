# Grade for assignment 8

| Criterion                    | Points Earned / Total Points    | 
|:---------------              | -------------------------------:| 
| General                      |             30/35               | 
| Command Line                 |             18/20               | 
| Building Graph               |             17/20               | 
| Criteria 1, 2, 3             |             30/30               | 
| Output File                  |             18/20               | 
| **Grand Total**              |           **110/125**            | 


## General (35 - 5 = 30)
- Maven built successful
- -2 Many violations in PMD
- WARNING: Many violations in Checkstyle
- -2 Many violations in Findbugs
- Good work with Jacoco
- -1 Missing javadoc for RecommendationSystem::recommendInOrder()


## Command Line (20 - 3 = 18)
- -1 Incorrect error message thrown if the number of recommendations is not an integer.
- -2 Required arguments are not properly checked. If I pass just the optional arguments so thta my args.length > 3 then it would pass the required argument test.
- Warning: Validity of the files (if they ends with .csv) is not checked while checking command line arguments.

## Building Graph (20 - 1 = 19)
- -1 Input file reader is not generic. It should take a file name and should return the content. However you are reading both the files inside a method sequentially, thus this file reader class cannot be used for any other file.
- Each file is read only once and the information is stores at only one place [GOOD]
- GraphDatabase class has a goog design

## Criteria 1, 2, 3 (30 - 0 = 30)
- Good work creating different classes for each recommendation.
- Nicely written code and good implementation.

## Output File(20 - 2 = 18)
- -2 Write::writeToCSVFile() should only be responsible for writing to CSV. However it is also responsible for calling different recommedations, which is bad.
- Contents in the output files is correct and correctly formatted
- Overall time and memory complexity of writing to the file is reasonable
