package com.mreazl.util;

public class Vector2 implements Cloneable
{
    public double x = 0.0;
    public double y = 0.0;

    double n(double x)
    {
        return Double.isNaN(x) ? 0 : x;
    }

    public Vector2(){}

    public Vector2(double x, double y)
    {
        this.x = n(x);
        this.y = n(y);
    }

    public Vector2 sub(Vector2 B)
    {
        x -= B.x;
        y -= B.y;
        return this;
    }

    public Vector2 add(Vector2 B)
    {
        x += B.x;
        y += B.y;
        return this;
    }

    public Vector2 div(Vector2 B)
    {
        x /= B.x;
        y /= B.y;
        return this;
    }

    public Vector2 div(double B)
    {
        x /= B;
        y /= B;
        return this;
    }

    public Vector2 mul(Vector2 B)
    {
        x *= B.x;
        y *= B.y;
        return this;
    }

    public Vector2 mul(double B)
    {
        x *= B;
        y *= B;
        return this;
    }

    public Vector2 reset()
    {
        this.x = 0;
        this.y = 0;
        return this;
    }

    public double length()
    {
        return Math.sqrt(sqrLength());
    }

    public double sqrLength()
    {
        return x*x + y*y;
    }

    @Override
    public String toString()
    {
        return x + " " + y;
    }

    @Override
    public Vector2 clone() {
        try {
            Vector2 clone = (Vector2) super.clone();
            clone.x = x;
            clone.y = y;
            return clone;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return null;
    }
}
