package com.taobao.wireless.wuzhong;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.application.Application;
import com.intellij.openapi.application.ApplicationManager;

/**
 * Created with IntelliJ IDEA.
 * User: luu
 * Date: 12-8-11
 * Time: 上午9:24
 * To change this template use File | Settings | File Templates.
 */
public class HelloAction extends AnAction {
    public void actionPerformed(AnActionEvent e) {
        // TODO: insert action logic here
        Application application = ApplicationManager.getApplication();

        HelloApp helloApp = application.getComponent(HelloApp.class);

        helloApp.sayHello();
    }
}
