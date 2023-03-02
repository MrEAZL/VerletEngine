package com.mreazl.util;

public class VMath
{
    public static Vector2 sub(Vector2 A, Vector2 B)
    {
        return new Vector2(A.x - B.x, A.y - B.y);
    }

    public static Vector2 add(Vector2 A, Vector2 B)
    {
        return new Vector2(A.x + B.x, A.y + B.y);
    }

    public static Vector2 div(Vector2 A, Vector2 B)
    {
        return new Vector2(A.x / B.x, A.y / B.y);
    }

    public static Vector2 div(Vector2 A, double B)
    {
        return new Vector2(A.x / B, A.y / B);
    }

    public static Vector2 mul(Vector2 A, Vector2 B)
    {
        return new Vector2(A.x * B.x, A.y * B.y);
    }

    public static Vector2 mul(Vector2 A, double B)
    {
        return new Vector2(A.x * B, A.y * B);
    }
}
