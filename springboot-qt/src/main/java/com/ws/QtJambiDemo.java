package com.ws;

import io.qt.widgets.*;

public class QtJambiDemo extends QWidget {
    public QtJambiDemo() {
        // 创建按钮
        QPushButton button = new QPushButton("Click me", this);
        button.clicked.connect(this, "showMessage()");

        // 设置布局
        QVBoxLayout layout = new QVBoxLayout();
        layout.addWidget(button);
        setLayout(layout);

        // 设置窗口属性
        setWindowTitle("Qt Jambi Demo");
        resize(300, 200);
    }

    // 显示消息框
    public void showMessage() {
        QMessageBox.information(this, "Message", "Button clicked!");
    }

    public static void main(String[] args) {
        // 初始化 Qt Jambi 应用程序
        QApplication.initialize(args);

        // 创建并显示窗口
        QtJambiDemo window = new QtJambiDemo();
        window.show();

        // 启动 Qt Jambi 应用程序
        QApplication.exec();
    }
}
