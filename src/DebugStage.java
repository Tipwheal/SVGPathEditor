import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * Created by Administrator on 2017/4/21.
 */
public class DebugStage {
    private AnchorPane debugPane;
    private double offsetX, offsetY;
    private Label currentLabel, layoutXLabel, layoutYLabel, xLabel, yLabel, sceneXLabel, sceneYLabel, screenXLabel, screenYLabel;
    private Stage stage;

    public boolean isActive() {
        return stage.isShowing();
    }

    public void show() {
        if (!stage.isShowing()) {
            stage.show();
        }
    }

    public void hide() {
        if (stage.isShowing()) {
            stage.hide();
        }
    }

    public DebugStage() {
        stage = new Stage();
        stage.setX(0);
        stage.setY(0);
        setUpDebugPane();
        stage.setScene(new Scene(debugPane));
        stage.setAlwaysOnTop(true);
        show();
    }

    private void setUpDebugPane() {
        debugPane = new AnchorPane();
        debugPane.setPrefWidth(200);
        debugPane.setPrefHeight(200);
        layoutXLabel = new Label();
        layoutXLabel.setLayoutY(30);
        layoutYLabel = new Label();
        layoutYLabel.setLayoutY(60);
        xLabel = new Label();
        xLabel.setLayoutY(90);
        yLabel = new Label();
        yLabel.setLayoutY(120);
        sceneXLabel = new Label();
        sceneXLabel.setLayoutY(150);
        sceneYLabel = new Label();
        sceneYLabel.setLayoutY(180);
        screenXLabel = new Label();
        screenXLabel.setLayoutY(210);
        screenYLabel = new Label();
        screenYLabel.setLayoutY(240);
        currentLabel = new Label();
        debugPane.getChildren().addAll(currentLabel, layoutXLabel, layoutYLabel, xLabel, yLabel, sceneXLabel, sceneYLabel, screenXLabel, screenYLabel);
    }

    public void addDebug(Node... nodes) {
        for (Node node : nodes) {
            node.setOnMousePressed(e -> {
                e.consume();
                offsetX = e.getX();
                offsetY = e.getY();
            });
            node.setOnMouseDragged(e -> {
                e.consume();
                node.setLayoutX(e.getSceneX() - offsetX);
                node.setLayoutY(e.getSceneY() - offsetY);
                currentLabel.setText(node.toString());
                layoutXLabel.setText("layoutX" + node.getLayoutX());
                layoutYLabel.setText("layoutY" + node.getLayoutY());
                xLabel.setText("x" + e.getX());
                yLabel.setText("y" + e.getY());
                sceneXLabel.setText("sceneX" + e.getSceneX());
                sceneYLabel.setText("sceneY" + e.getSceneY());
                screenXLabel.setText("screenX" + e.getScreenX());
                screenYLabel.setText("screenY" + e.getScreenY());
            });
        }
    }
}
