fun main() {
    println("# 12.1 코틀린 데이터 타입")
    println("## 12.1.1 정수 데이터 타입")
    val bit8: Byte = 8
    val bit16: Short = 16
    val bit32: Int = 32
    val bit64: Long = 64

    println("## 12.1.2 부동 소수점 데이터 타입")
    val floatBit32: Float = 32.0f
    val doubleBit64: Double = 64.0

    println("## 12.1.3 부동 소수점 데이터 타입")
    val bool = false

    println("## 12.1.4 문자 데이터 타입")
    // 문자를 변수에 지정할 때는 작은 따옴표 사용
    val myChar1 = 'f'
    val myChar2 = ':'
    val myChar3 = 'X'

    val myChar4 = '\u0058' // "X의 유니코드 값"

    println("$myChar1 $myChar2 $myChar3 $myChar4")

    println("## 12.1.5 String 데이터 타입")
    // 단어나 문장으로 구성된 문자열, 큰따옴표 사용
    // 코틀린에서 문자 코드는 유니코드를 사용함
    val message = "10개의 메시지가 있습니다.\n"
    println(message)
    val messageLinesTrimMargin = """
        ^여러줄을 작성할 수 있으며
        ^trimMargin()으로 여백 제거 문자를 지정할 수 있다
    """.trimMargin("^")
    val messageLinesTrimIndent = """
        trimIndent는 자동으로
        공통 여백만큼 trim해준다
    """.trimIndent()
    val messageLinesNotTrim = """
        trim을 사용 안한 경우
    """
    println(messageLinesTrimMargin)
    println(messageLinesTrimIndent)
    println(messageLinesNotTrim)

    val joinVar= """문자열, 변수, 상수, 표현식
         함수 호출을 하여 문자열을 구성 ($bit32)""".trimIndent()
    println(joinVar)
    println("\$기호를 그대로 쓰려면 \\역슬래시를 사용하지먄 \"\"\"블록은 안되는듯... ")

    println("# 12.2 가변 변수")
    var mutableVar = "가변 변수는"
    mutableVar += " 값의 변경이 가능하다"

    println("# 12.3 불변 변수")
    val immutableVar = "불변 변수는  변경이 불가능하다"
    println(immutableVar)

    println("# 12.4 가변 변수와 불변 변수의 선언")
    println("var과 val로 선언이 가능하다")

    println("# 12.5 데이터 타입은 객체다")
    val myString = "The quick brown fox".uppercase()
    println(myString)

    println("# 12.6 타입 애노테이션과 타입 추론")
    var userCount: Int = 0
    var typeInference = 10.0 // 모든 부동소수점은 Double 로 자동 추론

    val infoText:String
    infoText = "타입 애노테이션이 있으면 초기값 나중에 지정가능"
    println(infoText)

    println("# 12.7 null 가능 타입")
    // val username: String = null // 컴파일 에러
    var nullUserName:String? = null
    // val notNullUserName:String = nullUserName // null 불가능 타입을 null 가능 타입에 지정 불가능
    if (nullUserName != null) {
        val notNullUserName:String = nullUserName // null 체크시 지정 가능
    }
    println("# 12.8 안전 호출 연산자")
    // nullUserName.uppercase() // null값으로 참조되는 객체는 uppercase() 호출 불가능

    if (nullUserName != null) {
        val notNullUserName:String = nullUserName.uppercase() // null 체크시 호출 가능
    }
    // 안전호출 연산자 ?.를 사용하면 결과가 null값일 경우 null값 그대로 지정됨
    val safeNullUserName = nullUserName?.uppercase()

//    println("# 12.9 Not-null 어서션(더블 뱅!!)")
//    println("변수 이름에 !!를 붙이면 null 제약을 무시하고 컴파일되니만  런타임시 null포인터 에러")
//    // val length = nullUserName!!.length
//
//    println("# 12.10 Null가능 타입과 let함수")
//    val firstNumber = 10
//    val secondNumber = 20
}

