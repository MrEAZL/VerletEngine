import com.mreazl.MainThread;
import com.mreazl.RenderThread;
import com.mreazl.util.Vector2;
import com.mreazl.verlet.PhysicsSolver;

public class Main {
    public static final int WIDTH = 800;
    public static final int HEIGHT = 800;

    public static final int solverFPS = 60;
    public static final int renderFPS = 30;

    static Thread mainThread;
    static Thread renderThread;

    public static PhysicsSolver solver;

    public static void main(String[] args) {
        solver = new PhysicsSolver();

        MainThread main = new MainThread(WIDTH, HEIGHT, solver);
        mainThread = new Thread(main);
        renderThread = main.getRender();

        MainThread.framerate = (int)((1 / (double)solverFPS) * 1000);
        RenderThread.framerate = (int)((1 / (double)renderFPS) * 1000);

        System.out.println("Starting main thread");
        mainThread.start();

        System.out.println("Starting render thread");
        renderThread.start();

        for (int i = 0; i < 20; i++)
        {
            solver.addObject(20, new Vector2(300, 300));
        }
    }
}