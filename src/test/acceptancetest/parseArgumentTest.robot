*** Settings ***
Library				keywords.ParseArgumentKeywords



| *Variable*  | *Value*                                                                                                   |
| ${expected} | usage: java VolumeCalculator length width height\nVolumeCalculator.java: error: unrecognized arguments: 43 |

| *Test Case*                            | *Action*                              | *Argument*         | *Argument*   | *Argument* | *Argument* |
| Test Volume Calculator Normal Function | Start Volume Calculator With Arguments | 7                  | 5            | 2          |            |
|                                        | ${length}=                            | keywords.ParseArgumentKeywords.Get Length         |              |            |            |
|                                        | Should Be Equal                       | 7                  | ${length}    |            |            |
|                                        | ${width}=                             | keywords.ParseArgumentKeywords.Get Width          |              |            |            |
|                                        | Should Be Equal                       | 5                  | ${width}     |            |            |
|                                        | ${height}=                            | keywords.ParseArgumentKeywords.Get Height         |              |            |            |
|                                        | Should Be Equal                       | 2                  | ${height}    |            |            |
|                                        | ${output}=                            | Get Program Output |              |            |            |
|                                        | Should Be Equal                       | ${output}          | 70           |            |            |
| Test Unrecognized Argument             | Start Volume Calculator With Arguments | 7                  | 5            | 2          | 43         |
|                                        | ${output}=                            | Get Program Output |              |            |            |
|                                        | Should Be Equal                       | ${output}          | ${expected}           |            |            |
| Test Absurd Program Normal Function    | Start Absurd Program With Arguments   | dog                | 2            | true       | 3.5        |
|                                        | ${pet}=                               | keywords.ParseArgumentKeywords.Get Pet            |              |            |            |
|                                        | Should Be Equal                       | dog                | ${pet}       |            |            |
|                                        | ${number}=                            | keywords.ParseArgumentKeywords.Get Number         |              |            |            |
|                                        | Should Be Equal                       | 2                  | ${number}    |            |            |
|                                        | ${rainy}=                             | keywords.ParseArgumentKeywords.Get Rainy          |              |            |            |
|                                        | Should Be Equal                       | true               | ${rainy}     |            |            |
|                                        | ${bathrooms}=                         | keywords.ParseArgumentKeywords.Get Bathrooms      |              |            |            |
|                                        | Should Be Equal                       | 3.5                | ${bathrooms} |            |            |