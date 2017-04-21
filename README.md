# SVGPathEditor
一个及其难以使用的svg path编辑器，用于手动制作图标。以及一个可以嵌入javafx程序的DebugStage，用于实时调整程序中组件的位置。远离fxml从我做起。

### 编辑svg path
1. 在TextArea输入字符串
2. 在小AnchorPane生成对应图片

举个画圆例子：


    M50,0
    A10,10 0,0,0 50,50
    A10,10 0,0,0 50,0
    Z
    
### DebugStage

1. 将DebugStage拿出来丢到javafx程序中
2. 在一个Controller之类的东西里new一个DebugStage
3. 调用DebugStage的addDebug方法，添加需要挪动位置的Node
4. 打开程序，拖拖拖，记住位置
5. 回到代码中修改位置

举个例子：

    DebugStage debugStage = new DebugStage();
    debugStage.addDebug(...);
