package com.mreazl.gui;

import com.mreazl.MainThread;
import com.mreazl.RenderThread;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel
{
    private final RenderThread renderer;

    public Panel(RenderThread renderer)
    {
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.setVisible(true);

        this.renderer = renderer;
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        if (!MainThread.running) return;
        renderer.draw(g);
    }
}
