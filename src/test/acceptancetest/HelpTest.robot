*** Settings ***
Library				ArgumentParserKeywords

| *Variable*  | *Value*                                                                                                                                                                                                                                   |
| ${expected} | usage: java VolumeCalculator length width height\nCalcuate the volume of a box.\npositional arguments:\n\tlength the length of the box (float)\n\twidth the width of the box(float)\n\theight the height of the box(float) |

| *Test Case*        | *Action*                     | *Argument*         | *Argument*  |
| Test Usage Message | Start Program With Arguments | -h                 |             |
|                    | ${output}=                   | Get Program Output |             |
|                    | Should Be Equal              | ${expected}        | ${output}   |

