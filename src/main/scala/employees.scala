import scala.collection.mutable.ListBuffer

case class Employee(id: Long,
                    first: String,
                    last: String,
                    city: String,
                    active: Boolean)

class MapDemo {

  val employees = List(
    Employee(1, "John", "Doe", "State College", true),
    Employee(2, "Sue", "Smith", "Harrisburg", false),
    Employee(3, "Aaron", "Jones", "State College", true),
    Employee(4, "Pat", "Jackson", "Erie", false),
    Employee(5, "Ellen", "Jackson", "Erie", true)
  )

  // classic mutable approach:
  val out = ListBuffer.empty[String]
  for (e <- employees) {
    if (e.active) {
      out += s"${e.first} ${e.last}"
    }
  }
  
  // a more functional approach:
  // two one-line helper functions:
  def isActive(e: Employee) = e.active
  def getName(e: Employee) = s"${e.first} ${e.last}"

  // now we describe what we want to do: filter out the inactive employees,
  // and get the full names of those left.
  val fullNames = employees.filter(isActive).map(getName)
}












