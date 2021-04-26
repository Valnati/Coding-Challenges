/*********************
*Given an array of integers, find if any two values
*sum to a given third value.
*
*Time complexity is O(n), iterating through array once.
*Space complexity is O(n), using a hashSet to 
*efficiently iterate over the array.
*/

fun test(flightLength: Int, movieLengths: Array<Int>) : Boolean {
    if (movieLengths.size == 0) return false
    var set = HashSet<Int>()
    for (length in movieLengths) {
        if (set.contains(flightLength - length)) return true
       	else set.add(length)
    }
    return false
}


fun main() {
    val movies = arrayOf(45, 60, 22, 77, 30, 15)
    println(test(68, movies)) //prints false
    println(test(67, movies)) //prints true
}
