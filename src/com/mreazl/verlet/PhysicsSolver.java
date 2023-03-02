package com.mreazl.verlet;

import com.mreazl.util.VMath;
import com.mreazl.util.Vector2;

import java.awt.*;
import java.util.Vector;

public class PhysicsSolver
{
    Vector<VerletObject> objects;
    static final Vector2 Gravity = new Vector2(0, 1000);

    static final Vector2 constraintPosition = new Vector2(300, 300);
    static final double constraintRadius = 100.0;

    static final double collisionCo = 0.75;
    static final double friction = 0.98;
    static final int steps = 50;

    public PhysicsSolver()
    {
        objects = new Vector<>();
    }

    public void addObject(double radius, Vector2 position)
    {
        VerletObject object = new VerletObject(radius);
        object.position = position;

        objects.add(object);
    }

    public void applyGravity(VerletObject object, double dt)
    {
        object.accelerate(Gravity);
    }

    public void applyConstraint(VerletObject object, double dt)
    {
        final Vector2 toObj = VMath.sub(object.position, constraintPosition);
        final double dist2 = toObj.sqrLength();
        final double req = constraintRadius - object.radius;
        if (dist2 > req * req)
        {
            final double dist = Math.sqrt(dist2);
            final Vector2 n = VMath.div(toObj, dist);

            object.position = VMath.add(constraintPosition, n.mul(req));
        }
    }

    public void applyCollisions(VerletObject object, double dt)
    {
        objects.forEach(object2 -> {
            final double req = (object.radius + object2.radius) / 2;
            final Vector2 axis = VMath.sub(object.position, object2.position);
            final double dist2 = axis.sqrLength();

            if (dist2 < req * req)
            {
                final double dist = Math.sqrt(dist2);
                final Vector2 n = VMath.div(axis, dist);
                final double delta = 0.5 * collisionCo * (dist - req);
                final double mass1 = object.radius / req;
                final double mass2 = object2.radius / req;

                object.position.sub(n.mul(delta * mass2));
                object2.position.add(n.mul(delta * mass1));
            }
        });
    }

    public void update(double dt)
    {
        objects.forEach(object -> {
            applyGravity(object, dt);
            for (int i = 0; i < steps; i++)
            {
                applyConstraint(object, dt);
                applyCollisions(object, dt);
            }
            object.applyPosition(dt, friction);
        });
    }

    public void draw(Graphics g)
    {
        objects.forEach(object -> {
            object.draw(g);
        });
    }
}
