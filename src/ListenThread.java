import javafx.application.Platform;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class ListenThread implements Runnable {

    private MulticastSocket socket;
    private InetAddress group;
    private GameController gameController;
    private LogicGame logicGame;
    Thread thread;


    volatile boolean shutdown = false;

    public void shutdown() {
        shutdown = true;
    }


    public ListenThread(MulticastSocket socket, InetAddress group, GameController gameController, LogicGame logicGame) {
        this.gameController = gameController;
        this.socket = socket;
        this.group = group;
        this.logicGame = logicGame;
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {

        byte[] buf = new byte[1024];
        while (!shutdown) {
            while (true) {
                DatagramPacket recv = new DatagramPacket(buf, buf.length);

                try {
                    socket.receive(recv);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                String received = new String(recv.getData(), 0, recv.getLength());

                if (received.equals("touch00")) {
                    if (logicGame.getCircleOrCross(0, 0) == 0) {
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                gameController.setCircleOrCross(gameController.getBorderPane00(), 0, 0);
                            }
                        });
                    }
                }
                if (received.equals("touch01")) {
                    if (logicGame.getCircleOrCross(0, 1) == 0) {
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                gameController.setCircleOrCross(gameController.getBorderPane01(), 0, 1);
                            }
                        });
                    }
                }
                if (received.equals("touch02")) {
                    if (logicGame.getCircleOrCross(0, 2) == 0) {
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                gameController.setCircleOrCross(gameController.getBorderPane02(), 0, 2);
                            }
                        });
                    }
                }
                if (received.equals("touch10")) {
                    if (logicGame.getCircleOrCross(1, 0) == 0) {
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                gameController.setCircleOrCross(gameController.getBorderPane10(), 1, 0);
                            }
                        });
                    }
                }
                if (received.equals("touch11")) {
                    if (logicGame.getCircleOrCross(1, 1) == 0) {
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                gameController.setCircleOrCross(gameController.getBorderPane11(), 1, 1);
                            }
                        });
                    }
                }
                if (received.equals("touch12")) {
                    if (logicGame.getCircleOrCross(1, 2) == 0) {
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                gameController.setCircleOrCross(gameController.getBorderPane12(), 1, 2);
                            }
                        });
                    }
                }
                if (received.equals("touch20")) {
                    if (logicGame.getCircleOrCross(2, 0) == 0) {
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                gameController.setCircleOrCross(gameController.getBorderPane20(), 2, 0);
                            }
                        });
                    }
                }
                if (received.equals("touch21")) {
                    if (logicGame.getCircleOrCross(2, 1) == 0) {
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                gameController.setCircleOrCross(gameController.getBorderPane21(), 2, 1);
                            }
                        });
                    }
                }
                if (received.equals("touch22")) {
                    if (logicGame.getCircleOrCross(2, 2) == 0) {
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                gameController.setCircleOrCross(gameController.getBorderPane22(), 2, 2);
                            }
                        });
                    }
                }
            }
        }

    }
}
