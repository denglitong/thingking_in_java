# 异常

> Java的基本理念是"结构不佳的代码不能运行"  
> 要想创建健壮的系统，它的每一个构建都必须是健壮的

> 要想构造大型、健壮、可维护的程序而言，需要用强制规定的兴衰来消除错误处理过程中随心所欲的因素

> 异常在一个恰当的异常处理程序中得到解决

> 异常监控区域（guarded region）  
它是一段可能产生异常的代码，并且后面跟着处理这些异常的代码

> 终止模型与恢复模型

> 可以声明方法将抛出异常，实际上却不抛出  
编译器相信了这个声明，并强制此方法的用户真的像抛出异常那样使用这个方法  
这样做的好处是，为异常先占个位子，以后就可以抛出这种异常而不用修改已有的代码  
在定义抽象类基类和接口时这种能力很重要  
这种在编译时被强制检查的异常成为被检查的异常

> 异常对象都是用 new 在堆上创建的，垃圾回收器会自动回收

> 不再需要在异常说明中声明方法将抛出 RuntimeException 类型的异常（或者任何从 RuntimeException 继承的异常）  
它们也被称为"不接受检查异常"。这种异常属于错误，将被自动捕获。  
RuntimeException 代表的是编程错误：  
1.无法预料的错误，比如在控制范围之外传递进来的 null 引用  
2.作为程序员，应该在代码中进行检查的错误。在一个地方发生的异常，常常会在另一个地方导致错误  

> 如果不捕获 RuntimeException 异常，因为编译器没有在这个问题上对异常说明进行强制检查，  
RuntimeException 类型的异常也许会穿越所有的执行路径直达 main() 方法    

> 如果异常发生了，所有东西能被正确的清理吗？  
对于在构造器内抛出的异常需要格外小心，构造器会把对象成安全的初始状态，但还会有别的动作，  
比如打开一个文件，这样的动作只有在对象使用完毕并且用户调研了特殊的清理方法之后才能清理。  
如果在构造器内抛出了一次，这些清理行为也许就不能正常工作了。  
如果构造器在执行过程中半途而废，也许该对象的某些部分还没有被成功创建    

> 开发异常处理的初衷是为了方便程序员处理错误  
异常处理的一个重要原则是 "只有你知道如何处理的情况下才捕获异常"  
实际上，异常处理的一个重要目标就是把错误处理的代码桐错误发生的地点项分离  
> "被检查的异常" 使得这个问题变得有些复杂，因为它们强制你在可能还没准备好处理错误的时候  
被迫加上 catch 子句，这就导致了 吞食则有害（harmful if swallowed）的问题：  
try {
    // ... to do something useful
} catch(ObligatoryException e) {} // Gulp!

> Java 里面有2种类型的异常，一种是 checked exception，
即被检查的异常，这种异常要求调用方必须捕获或必须抛出  
还有一种是 unchecked exception，其基类是 RuntimeException，可以在调用方不捕获，但是运行时会抛出

> 异常指南：  
应该在下列指南下使用异常：  
1.尽可能使用 try-with-resources  
2.在恰当的级别处理问题（在知道该如何处理的情况下才捕获异常）  
3.解决问题并且重新调用产生异常的方法  
4.进行少许修补，然后绕过异常发生的地方继续执行    
6.把当前运行环境下能做的事情尽量做完，然后把相同的异常重抛到更高层  
7.终止程序  
8.进行简化（如果你的异常磨损使问题变得太复杂，那用起来会非常痛苦也很烦人）    
10.让类库和程序更安全（这既是在为调试做短期投资，也是在为程序的健壮做长期投资）  