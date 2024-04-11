package ejercicio3;

// Solución 2: Sincronización con bloques de código
public class Maze2 {
    private int playerX;
    private int playerY;

    public boolean isAtExit() {
        synchronized (this) {
            return (playerX == 0 && playerY == 0);
        }
    }

    public void setPosition(int x, int y) {
        synchronized (this) {
            playerX = x;
            playerY = y;
        }
    }
}
