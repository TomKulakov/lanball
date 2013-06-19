package com.lanball;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main {

    public static void main(String[] args) {
        LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
        cfg.title = "lanball";
        cfg.useGL20 = false;
        cfg.width = 1024;
        cfg.height = 612;
        LanBall lanBall = new LanBall();
        LwjglApplication game = new LwjglApplication(lanBall, cfg);
    }
    
}
