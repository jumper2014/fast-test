# 学习笔记

- serialVersionUID用于Java的序列化机制。序列化操作的时候系统会把当前类的serialVersionUID写入到序列化文件中，当反序列化时系统会去检测文件中的serialVersionUID，判断它是否与当前类的serialVersionUID一致，如果一致就说明序列化类的版本与当前类版本是一样的，可以反序列化成功，否则失败。
- slf4j只是一个日志标准，并不是日志系统的具体实现.是一个抽象层，它允许你在后台使用任意一个日志类库
- 抽象类实现接口:使用普通类来实现接口，这个普通类就必须实现接口中所有的方法，这样的结果就是普通类中就需要实现多余的方法.但是如果我们使用的是抽象类来实现接口，那么就可以只实现接口中的部分方法，并且当其他类继承这个抽象类时，仍然可以实现接口中有但抽象类并未实现的方法。
- 