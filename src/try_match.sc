// `case _`表示通配符
val result_try = try {
  Integer.parseInt("dog")
} catch {
  case _ => 0
} finally {
  println("always be printed")
}

val code = 1
val result_match = code match {
  case 1 => "one"
  case 2 => "two"
  case _ => "others"
}