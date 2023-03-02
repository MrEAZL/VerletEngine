package com.mreazl;

import com.mreazl.gui.Frame;
import com.mreazl.gui.Panel;

import java.awt.*;

public class RenderThread implements Runnable
{
    public static Frame frame;
    public static Panel panel;

    public static int framerate = 16;

    public RenderThread(int width, int height)
    {
        frame = new Frame(width, height);
        panel = new Panel(this);

        frame.add(panel);
        frame.pack();
    }

    public void draw(Graphics g)
    {
        MainThread.solver.draw(g);
    }

    @Override
    public void run() {
        while (MainThread.running)
        {
            try {
                Thread.sleep(framerate);
            } catch (Exception e) {
                e.printStackTrace();
            }

            panel.repaint();
        }
    }
}
