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
  /*
                    Any   👑 (Parent of Everything)
                /           \
        AnyVal            AnyRef  (Two main branches)
        (Primitives)      (Objects & Classes)

  ==================================================================
  | Scala Type   | Description                          | Java/JS Equivalent   |
  |-------------|----------------------------------|--------------------|
  | Any         | Parent of all types              | Object (Java)      |
  | AnyVal      | Value types (primitives)         | int, double, etc.  |
  | AnyRef      | Reference types (objects)        | Object, String     |
  | Unit        | No return value                  | void               |
  | Nothing     | Never returns (throws error)     | ❌ (No equivalent) Like a black hole—it never
                                                    returns, e.g., an Exception or infinite loop.
 |
  | Null        | Represents `null` (avoid it)     | null               |
  | None        | Safe way to handle missing value | Optional.empty()   |
                  use Some() and NOne over Null
  ==================================================================
  */

  val myName: Option[String] = Some("Arjun")  // ✅ Has a value
  val extractedName = myName.getOrElse("default name")  // Extracts "Arjun"

  val myName1: Option[String] = None  // ✅ No value
  val extractedName1 = myName1.getOrElse("default name")  // Extracts "default name"

  println(extractedName + extractedName1)  // Prints: Arjundefault name
  //val extractedName2=myName1.getOrElse(throw new Exception("exception thrown"))
  //println(extractedName2)

  //All scala primitive types are same as java, just that it's uppercase in scala e.g. Int over int, Nothing
  //is an extra data type in scala

  //collections
  val a=Array(0,1,2,3,4,5,6,7,8) //fixed size, immutable, created using constructor
  val l:List[Int]=List(1,2,3    )//fixed size, immutable, created using constructor

  private def binarySearch(a:Array[Int], key:Int, left:Int, right:Int):Int={
    if left > right then -1 // base case
    else {
      val mid = (right + left) / 2
      if key == a(mid) then mid
      else if key < a(mid) then binarySearch(a, key, left, mid - 1)
      else binarySearch(a, key, mid + 1, right)
    }

  }
  private def binarySearch(a:Array[Int], key:Int):Int=binarySearch(a, key, 0, a.length-1)
  println(binarySearch(a, 5))
  println(binarySearch(a, 50))
  /*list vs array
    +---------------+--------------------+----------------------+
    | Feature | Array | List |
    +---------------+--------------------+----------------------+
    | Mutability | ✅ Mutable | ❌ Immutable |
    | Size        | ❌ Fixed | ✅ Dynamic |
    | Random Access | ✅ O (1) Fast | ❌ O(n) Slow |
    | Modification | ✅ Can update | ❌ Cannot modify |
    | Structure | ✅ Indexed | ✅ Linked List |
    | Memory Usage | ✅ Compact | ❌ More Overhead |
    | Prepend Op | ❌ O(n) Slow | ✅ O(1) Fast |
    | Use Case | ✅ Fast Lookups | ✅ Functional Ops |
  +---------------+--------------------+----------------------+
  ✔ Objects in Scala are used for:

  Singletons (only one instance)

  Companion Objects (factory methods, static-like behavior)

  Utility methods (like Java's static)

  Extending Traits for behavior without needing multiple instances
  */

  //array ops
  a
    .filter(extractedName=> extractedName%2==0)
    .map(item => item*item)
    .foreach(item => println(item))

  //or
  a
    .filter(_%2==0)
    .map(item => item*item)
    .foreach(println)

}
