
fun main() {
    helloKotlin()
    println(add(4, 5))
    printInfo()
    maxByTest()
    checkNum(2)
    checkNum(4)
}
//1. 함수 생성
fun helloKotlin(): Unit { // Unit는 생략가능
    println("Hello Kotlin-Basic!")
}

fun add(a: Int, b: Int): Int {
    return a + b
}

// 2. 문자열 템플릿과 주석
fun printInfo(){
    var name : String = "meda"
    val lastName = "ndro"
    println("닉네임:${name}")
    println("풀네임:${name + lastName}")
    println("뒤에 공백으로 구분되면 $name 처럼 중괄호 생략 가능")
    println("\$ 표시는 \\(백슬래시) 이스케이프 문자 사용")
    println("주석은 //으로 가능합니다.")//이렇게
    println("여러줄 주석은 /* */으로 가능합니다")/*
    이렇게 */
}

// 3. 조건식과 상수, 변수
fun maxBy1(a: Int, b: Int): Int {
    if (a > b) {
        return a
    }else{
        return b
    }
}

fun maxBy2(a: Int, b: Int) = if (a > b) a else b
// maxBy1과 같은 동작을 한다,
// 자바 삼항연산자 (a > b) ? a : b 와 비슷하다

fun maxByTest(){
    val a : Int = 10 // val 은 Value 상수
    var b : Int = 9 // var 는 Variable 변수
    var c = 7 // 타입 자동 추론 가능

    //a = 20   //상수는 수정 불가능
    b = 20   //변수는 수정 가능

    println("일반적인 방법 ${maxBy1(a,b)}")
    println("간결한 방법 ${maxBy2(a,b)}")

}

fun checkNum(score : Int): Unit{ // 모든 함수는 expression 이다 (Unit 반환)
    when(score){
        0 -> println("$score is 0")
        1 -> println("$score is 1")
        2,3 -> println("$score is 2 or 3")
    }// switch case 문과 비슷한 when 구문, 명령문(statement)

    var intToString = when(score){
        0 -> "0"
        1 -> "1"
        2,3 -> "2 or 3"
        else -> "not 0 to 3"
    }// 변수에 대입할때는 else문이 필수이다, 표현식(expression)

    println("$score 문자열 변환 결과 : ${intToString}")

    when(score){ // A..B를 사용하면 A 이상과 B 이하이다
        in 9..10 -> print("천재")
        in 4..9 -> print("괜춘")
        else -> println("노력하세요")
    }
}
// 표현식(expression) : 값을 만들어 반환
// 명령문(statement) : 값을 만들지 않음