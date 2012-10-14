package com.taobao.wireless.wuzhong;

import com.intellij.openapi.components.ApplicationComponent;
import com.intellij.openapi.ui.Messages;
import org.jetbrains.annotations.NotNull;

/**
 * Created with IntelliJ IDEA.
 * User: luu
 * Date: 12-8-11
 * Time: 上午9:19
 * To change this template use File | Settings | File Templates.
 */
public class HelloApp implements ApplicationComponent {
    public HelloApp() {
    }

    public void initComponent() {
        // TODO: insert component initialization logic here
    }

    public void disposeComponent() {
        // TODO: insert component disposal logic here
    }

    @NotNull
    public String getComponentName() {
        return "HelloApp";
    }

    public void sayHello(){
        Messages.showMessageDialog("hello world","hello world",Messages.getInformationIcon());
    }
}
