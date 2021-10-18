import com.itheima_03.MyService;

module MyClassOne {
    exports com.itheima;
    exports com.itheima_02;
    exports com.itheima_03;

    //provides MyService with com.itheima_03.impl.one;
    provides MyService with com.itheima_03.impl.two;
}