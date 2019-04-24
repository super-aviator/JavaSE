/**
 * Equals 
 * 
 * 1. equals方法必须遵循的5大原则，缺一不可：
 * 1.1 自反性-对于任何非空引用 x，x.equals(x) 必须返回 true。
 * 1.2 对称性-对于任何非空引用 x 和 y，如果且仅当 y.equals(x) 返回 true 时 x.equals(y) 必须返回 true。
 * 1.3 传递性-对于任何非空引用 x、y、z，如果 x.equals(y) 返回 true，y.equals(z) 返回 true，则 x.equals(z) 必须返回 true。
 * 1.4 一致性-对于任何非空引用 x 和 y，如果在 equals 比较中使用的信息没有修改，则 x.equals(y) 的多次调用必须始终返回 true 或始终返回 false。
 * 1.5. 对于任何非空引用 x，x.equals(null) 必须返回 false。
 * 
 * 2. 没有令人满意的方法来继承一个可实例化的类并添加一个值组件，但是有一个很好的变通方法：按照条目 18 的建议，“优先使用组合而不是继承”。
 * 
 * 3. java.sql.Timestamp 继承了 java.util.Date 并添加了一个 nanoseconds 字段。 
 *    Timestamp 的等价 equals 确实违反了对称性，并且如果 Timestamp 和 Date 对象在同一个集合中使用，或者以其他方式混合使用，则可能导致不稳定的行为。 
 * 
 * 
 */
public class Equals10 {

    public static void main(String[] args) {
    }
}