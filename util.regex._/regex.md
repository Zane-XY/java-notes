regex
======

## Cheat Sheet
usage         | example
------------- | -------------
named group | just like in Perl: `(?<group-name>)`
pattern and macher |  `Pattern p = Pattern.compile("a*b");` <br> `Matcher m = p.matcher("aaaaab");`
`match()` vs `find()` | `match()` matches all entire input against regex, `find()` only finds existence.
progressive find | `while(matcher.find()) {...}`


## match mode
type | example
------------- | -------------
single line mode aka `Pattern.DOTALL` |`(?s)`
multiline mode aka `Pattern.MULTILINE` | `(?m)`


## look arounds
type        |  exp | example
------------- | ------------- | -------------
look ahead (positive)   | followed by  | anything followed by `&` `((.(?=&))+)`
look ahead (negative)   | not followed by | anything not followed by `&` `((.(?!&))+)`
look behind(positive)   | prefixed by | `(?<=)` 
look behind(negative)   | not prefixed by | `(?<!)`

## Repetition greey and lazy
usage         | example
------------- | -------------
greedy one or many | `+`
lazy one or many | `+?`

## String.replaceAll with  captured group

- split chars by two, with a delimiter:
  - with ending space:
    `s = s.replaceAll("..", "$0 ");`
  - remove ending spaces:
    `s = s.replaceAll("..(?!$)", "$0 ");`

