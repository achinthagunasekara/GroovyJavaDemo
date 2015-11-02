/* 
 * @title: Groovy Tutorial
 * @author: Archie Gunsekara
 * @date: 2015.09.03
 */

/* Defineing a simple parameter and accessing the value */
def name='archieg'
println "Hello $name!"

println ""

/* Defineing a multi line parameter and accessing the value */
def s = """This is
a multiline
string"""
println s

println ""

/* Defining a pattern parameter */
def pattern = ~/a slash must be escaped \/ but backslash, like in a digit match \d does not/
println pattern.getClass()
println pattern

println ""

/* Matching a pattern parameter with a another parameter */
def patternToMatch = "Galaxy"
def matcher = "The Hitchhiker's Guide to the Galaxy" =~ /$patternToMatch/
if (matcher) {
  println "Found the word '$patternToMatch'"
}

println ""

/* simple closure with a parameter */
def helloWorld = { String value ->
   
    println "Hello $value"
}
helloWorld("achintha")

println ""

/* simple closure with multiple parameters */
def power = { int x, int y ->
    return Math.pow(x, y)
}
println power(2, 3)

println ""

/* 
 * use of the special parameter 'it'. Please note 'it' is the first parameter 
 * You do not need specify a parameter if it's just a single parameter closer
 * just use 'it'
 */
def sayIt = { println it }
sayIt("Hi This is the Computer")

println ""

/* more 'it' examples */
def square = { it * it }
println square(4)

println ""

/* passing a closure into a closure */
def returnIt = { return it }
def transform = { str, transformation ->
  transformation(str)
}
println transform("Hello World by passing in a fun", returnIt)

println ""

/* assinging a closure to a parameter */

def createGreeter = { name1 ->
  return {
    def day = new Date().getDay()
    if (day == 0 || day == 1) {
      println "Nice Weekend, $name1"
    } else {
      println "Hello, $name1"
    }
  }
}
def greetWorld = createGreeter("Achintha")
greetWorld()

println ""

/* creating a list and access a list */

def list = [1,1,2,3,5,6]
println list[0] //accss the first element
println list[-1] //access the first element from the back

println ""

/* print all items in a list */
list.each {
    println it
}

println ""

/* 
 * find all items in a list matching a condition and 
 * creating a new list with the results
 */
def odd = list.findAll { it % 2 != 0 }
odd.each {
    println it
}

println ""

/*
 * altering each element in a list and
 * creating a new list
 */
def squaredList = list.collect { it * it }
squaredList.each {
    println it
}

println ""

/* more examples */

def upper = ["Hello", "World"].collect { it.toUpperCase() }
upper.each {
    println it
}

println ""

/* some more examples */

def upper2 = ["Hello", "World", "you", "are", "cool"]*.toUpperCase()
upper2.each {
    println it
}

println ""

/* creating a map */

def keyTest = 'Key3'
def aMap = [
            'Key1': 'Value 1',
            Key2: 'Value 2',
            (keyTest): 'Another value', // parameter must be in ()
            achintha: 'Test Value for Achintha' //strings can be within '', "" or nothing
]

println aMap['Key1']
println aMap[keyTest]
println aMap.Key1
println aMap.archie

println ""

/* printing each key value pair in the map */
aMap.each {
    println it.key + " => " + it.value
}

println ""

/* 
 * finding keys or values that matches a criteria
 * and creating a list with the results
 */
def aList2 = aMap.findAll{ it.key == "achintha" }
aList2.each {
    println it
}

println ""

/*
 * altering each element in the map
 */
def aList3 = aMap.collect{ it.value + " " + it.value }
aList3.each {
    println it
}

println ""

/*
 * altering each element in the map - more examples
 */

def aMap2 = aMap.collectEntries { key, value ->
    def newKey = key + "^2"
    return [(key): value, (newKey): value + " AAAA " + value]
}
aMap2.each {
    println it.key + " => " + it.value
}
