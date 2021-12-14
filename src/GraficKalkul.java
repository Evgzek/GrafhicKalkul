import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
public class GraficKalkul {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                CalculatorFrame frame = new CalculatorFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}
class CalculatorFrame extends JFrame{
    public CalculatorFrame(){
        setTitle("Простой калькулятор");
        CalculatorPanel panel = new CalculatorPanel();
        add(panel);
        pack();//определяет размеры рамки и всего что есть в окне
        int width = 400;
        int height = 400;
        GraphicsDevice g = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();//описание графического устройства
        int screenWidth = g.getDisplayMode().getWidth();
        int screenHeight = g.getDisplayMode().getHeight();
        setBounds(screenWidth / 2 - width / 2, screenHeight/2 - height/2,width,height);
    }
}
class CalculatorPanel extends JPanel{
    private JButton display;
    private JPanel panel;
    private BigDecimal result;//для вычисления с более высокой точностью
    private String lastCommand;
    private boolean start;
    public CalculatorPanel(){
        setLayout(new BorderLayout());//Создает новый макет границы без пробелов между компонентами
        result = BigDecimal.ZERO;
        lastCommand = "=";
        start = true;
        display = new JButton("0");
        display.setEnabled(false);
        display.setFont(display.getFont().deriveFont(50f));//Создает новый объект шрифта, копируя текущий объект шрифта и применяя к нему новый размер
        add(display, BorderLayout.NORTH);
    }
}

