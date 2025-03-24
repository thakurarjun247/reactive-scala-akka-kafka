object SGN extends App{
  print("SGN")
  val name: String ="Arjun"
  val age:Int=37
  //var is not recommended
  /*both comments style same as in
  java*/
  val canVote: String=if age>18 then "sure" else "no"
  print(canVote)
  //scala has no semicolons
  //it has implicit returns meaning not return keyword
  //function return type is written after the function, arg data type after the args.
  //In Java, function definitions use curly braces {} and the return keyword,
  // but in Scala, = is used to associate the function name with its body.
  def sum(x:Int, y:Int):Int=x+y
  //Use = when defining a named function with a return value.
 
  //Use => for inline lambda expressions (anonymous functions).
  //here the return type is inferred and optional

  //lambda or arrow function
  //just like js, scala has => operator unlike java which has ->

  val multiply= (x:Int,y:Int)=> x*y
  //another way we explicit return type
  val multiply1: (Int, Int) => Int = (x, y) => x * y

  println(multiply(3,4))
  //lazy val

  /*
  +------------+------------+------------+------------+
  | Feature    | val        | var        | lazy val   |
  +------------+------------+------------+------------+
  | Immutable? | ✅ Yes     | ❌ No      | ✅ Yes     |
  | Reassign?  | ❌ No      | ✅ Yes     | ❌ No      |
  | Evaluated? | ✅ At init | ✅ At init | ❌ When used |
  | Cached?    | ✅ Yes     | ✅ Yes     | ✅ Yes     |
  | Use case?  | Safe vars  | Mutable    | Expensive ops |
  +------------+------------+------------+------------+

  //Scala is statically typed, meaning types are checked at compile-time. However, Scala has type inference,
  // which lets the compiler determine the type for you.

    🔹 When to Use Explicit Types ?
    ✅ Public API Methods → Improves readability and avoids ambiguity
.
  ✅ Complex Expressions → Makes the   type clear   to developers
.
  ✅ Avoiding Unexpected Inference → Helps prevent wrong assumptions.

  In Scala, just like in JS,  functions are first-class citizens, meaning:
  ✅ You can pass functions as arguments to other functions.
  ✅ You can return functions from other functions.
  ✅ You can assign functions to variables just like values.
  Unit data type is similar to void in java
  */
  def applyOperation(x:Int , y:Int, operation: (Int, Int)=>Int ):Int={
    operation(x,y)
  }



}
