
//main 입력후 tab키 인텔리제이 자동완성
fun main() {
    println("Hello Kotlin!") //세미콜론 생략가능
    System.out.println("Hello Java!")
}
//shift + f10 으로 실행
//class가 없을경우 JVM에서 파일이름을 기준으로 자동 생성됨
//
//디컴파일 결과 ↓
//import kotlin.Metadata;
//
//@Metadata(
//    mv = {2, 0, 0},
//    k = 2,
//    xi = 48,
//    d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u001a\u0006\u0010\u0000\u001a\u00020\u0001¨\u0006\u0002"},
//    d2 = {"main", "", "HelloKotlin"}
//)
//public final class HelloKotlinKt {
//    public static final void main() {
//        String var0 = "Hello Kotlin!";
//        System.out.println(var0);
//        System.out.println("Hello Java!");
//    }
//
//    // $FF: synthetic method
//    public static void main(String[] args) {
//        main();
//    }
//}