package com.mreazl.gui;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame
{
    public Frame(int width, int height)
    {
        this.setPreferredSize(new Dimension(width, height));
        this.setVisible(true);
        this.setTitle("Verlet Engine");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }
}
