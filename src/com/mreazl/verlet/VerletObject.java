package com.mreazl.verlet;

import com.mreazl.util.VMath;
import com.mreazl.util.Vector2;

import java.awt.*;

public class VerletObject
{
    public double radius;
    public Vector2 position = new Vector2();
    public Vector2 oldPosition = new Vector2();
    public Vector2 acceleration = new Vector2();
    public Color color;

    public VerletObject(double radius)
    {
        this.radius = radius;
    }

    public void applyPosition(double dt, double friction)
    {
        Vector2 velocity = VMath.sub(position, oldPosition);
        oldPosition = position.clone();

        position.add(velocity.mul(friction)).add(acceleration.mul(dt).mul(dt));
        acceleration.reset();
    }

    public void accelerate(Vector2 acceleration)
    {
        this.acceleration.add(acceleration);
    }

    public void draw(Graphics g)
    {
        g.setColor(color);
        g.fillArc((int)position.x, (int)position.y, (int)radius, (int)radius, 0, 360);
    }
}
