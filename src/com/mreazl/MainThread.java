package com.mreazl;

import com.mreazl.verlet.PhysicsSolver;

public class MainThread implements Runnable
{
    public static RenderThread render;
    private static Thread renderThread;

    public static PhysicsSolver solver;
    public static boolean running;

    public static int framerate = 8;

    public MainThread(int width, int height, PhysicsSolver _solver)
    {
        render = new RenderThread(width, height);
        renderThread = new Thread(render);

        solver = _solver;
    }

    public Thread getRender()
    {
        return renderThread;
    }

    @Override
    public void run() {
        running = true;

        while (running) {
            double start = System.nanoTime();
            try {
                Thread.sleep(framerate);
            } catch (Exception e) {
                e.printStackTrace();
            }

            double dt = (System.nanoTime() - start) / 1000000000;
            solver.update(dt);
        }
    }
}
