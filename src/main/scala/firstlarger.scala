class FirstLarger {

  // our data set
  val numbers = List(3, 2, 4, 7, 9, 8, 1)

  // first version.
  // imperative. mutable variables. explicit looping
  def firstLarger1(data: List[Int],
                   threshold: Int): Option[Int] = {
    // mutable variable. ew. gross.
    var result: Option[Int] = None
    val iter = data.iterator

    while (iter.hasNext && result == None) {
      val e = iter.next()
      if (e > threshold) {
        result = Option(e)
      }
    }
    result
  }

  // second version.
  // more functional
  // no mutable state.
  // but still long-winded.
  def firstLarger2(data: List[Int],
                   threshold: Int): Option[Int] = {
    if (data == Nil) {
      None
    } else {
      val head = data.head
      if (head > threshold) {
        Option(head)
      } else {
        firstLarger2(data.tail, threshold)
      }
    }

  }

  // third pass.
  // more functional. using pattern matching, but still with
  // a big imperative block
  def firstLarger3(data: List[Int],
                   threshold: Int): Option[Int] = data match {
    case Nil => None
    case head :: tail => {
      if (head > threshold) {
        Option(head)
      } else {
        firstLarger(data.tail, threshold)
      }
    }
  }


  // our final version. uses patterns exclusively.
  // describes what we want, doesn't tell how to find it.
  def firstLarger(data: List[Int],
                  threshold: Int): Option[Int] = data match {
    case Nil => None
    case head :: tail if (head > threshold) => Option(head)
    case head :: tail => firstLarger(tail, threshold)
  }


  // sme arbitrary predicates
  def gt10(n: Int): Boolean = n > 10
  def isEven(n: Int): Boolean = n % 2 == 0


  // a higher-order function.
  // this is firstLarger() generalized to take an arbitrary predicate
  def findFirst(data: List[Int],
                predicate: Int => Boolean): Option[Int] = data match {
    case Nil => None
    case head :: tail if predicate(head) => Option(head)
    case head :: tail => findFirst(tail, predicate)
  }


  // some sanity checks.
  firstLarger(numbers, 5) == Option(7)
  firstLarger(numbers, 10) == None

  findFirst(numbers, isEven)
  findFirst(numbers, gt10)


}











