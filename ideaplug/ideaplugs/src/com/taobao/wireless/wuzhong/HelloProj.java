package com.taobao.wireless.wuzhong;

import com.intellij.openapi.components.ProjectComponent;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;

/**
 * Created with IntelliJ IDEA.
 * User: luu
 * Date: 12-8-11
 * Time: 上午9:20
 * To change this template use File | Settings | File Templates.
 */
public class HelloProj implements ProjectComponent {
    public HelloProj(Project project) {
    }

    public void initComponent() {
        // TODO: insert component initialization logic here
    }

    public void disposeComponent() {
        // TODO: insert component disposal logic here
    }

    @NotNull
    public String getComponentName() {
        return "HelloProj";
    }

    public void projectOpened() {
        // called when project is opened
    }

    public void projectClosed() {
        // called when project is being closed
    }
}
