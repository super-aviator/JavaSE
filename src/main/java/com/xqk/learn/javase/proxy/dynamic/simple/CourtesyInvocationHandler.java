package com.xqk.learn.javase.proxy.dynamic.simple;

import com.xqk.learn.javase.proxy.dynamic.simple.interfaces.CourtesyInterface;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * InvocationHandler接口的实现，需要将一个动态代理接口的实现类impl作为成员变量
 * <p>
 * 知识要点：
 * 1. 当代理类的两个或多个接口包含具有相同名称和参数签名的方法时，代理类的接口的顺序将变得很重要。
 * 在代理实例上调用这种重复方法时，传递给调用处理程序的Method对象不一定是其声明类可从调用代理
 * 方法的接口的引用类型中分配的对象。存在此限制是因为生成的代理类中的相应方法实现无法确定通过哪
 * 个接口调用了该接口。因此，当在代理实例上调用重复方法时，代理类的接口列表中包含该方法（直接或
 * 通过超接口继承）的最前接口中的方法的Method对象将传递给调用处理程序的调用方法，无论通过哪种引
 * 用类型进行方法调用。
 * <p>
 * 2. 如果代理接口包含与java.lang.Object的hashCode，equals或toString方法具有相同名称和参数签名
 * 的方法，则在代理实例上调用该方法时，传递给调用处理程序的Method对象将将java.lang.Object作为
 * 其声明类。换句话说，java.lang.Object的公共非最终方法在逻辑上位于所有代理接口之前，以确定将
 * 哪个Method对象传递给调用处理程序。
 * <p>
 * 3. 还要注意，当将重复方法分派给调用处理程序时，invoke方法只能在可调用它的所有代理接口中引发可分
 * 配给该方法的throws子句中的异常类型之一的已检查异常类型。通过。如果invoke方法引发了一个检查后
 * 的异常，该异常无法分配给该方法在可以通过其调用的一个代理接口中声明的任何异常类型，则对该代理实
 * 例的调用将引发未经检查的UndeclaredThrowableException。此限制意味着，并非所有通过传递给invoke
 * 方法的Method对象上的getExceptionTypes调用而返回的异常类型都必然会由invoke方法成功抛出。
 *
 * @author 熊乾坤
 * @date 2020-02-04 20:58
 */
public class CourtesyInvocationHandler implements InvocationHandler {
    private CourtesyInterface ci;

    CourtesyInvocationHandler(CourtesyInterface ci) {
        this.ci = ci;
    }

    /**
     * @param proxy  此处的proxy是运行时自动创建的代理实例
     * @param method 代理接口或者从Object类中继承的方法
     * @param args   参数
     * @return 函数调用返回的对象
     * @throws Throwable 异常基类
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //此处的proxy是运行时自动创建的代理实例
        System.out.println("proxy.getClass().toString(): " + proxy.getClass().toString());
        //此处的method参数绑定的类是根据实现类所实现的接口的顺序来决定的，Object中方法在所有方法之前
        System.out.println("method.getDeclaringClass().getName() " + method.getDeclaringClass().getName());

        System.out.println("在打招呼之前，一定要注意自己的仪表");
        System.out.println("同时需要面带微笑，坚持才是胜利，加油，奥利给！");
        Object result = method.invoke(ci, args);
        System.out.println("在打招呼之后，自己也会获得一个好的心情");
        System.out.println("期待明天的再次见面，加油，奥利给！");
        return result;
    }
}
