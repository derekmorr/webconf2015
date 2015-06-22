class Patterns {

  // it's like switch on steroids.
  def labelQuantity(qty: Int) = qty match {
    case 0 => "None"
    case 1 => "One"
    case 2 => "A pair"
    case 3 => "A few"
    case _ => "A lot"
  }

  def mixAndMatch(x: Any): Any = x match {
    case true => Math.PI
    case "howdy" => false
    case Nil => "foobar"
    case 5 => List(1, 2, 3)
  }

  def whatIsIt(x: Any): String = x match {
    case i: Int     => "it's an integer: " + i
    case s: String  => "it's a string: " + s
    case b: Boolean => "it's a Boolean: " + b
    case _ => "unknown"
  }

  val numbers = List(1, 2, 3)
  def printList(list: List[Int]): Unit = list match {
    case Nil => println("Nil")
    case foo :: bar => {
      println(foo)
      printList(bar)
    }
  }

  printList(numbers)

}















