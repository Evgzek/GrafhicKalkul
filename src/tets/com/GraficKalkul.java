package tets.com;
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
        ActionListener insert = new InsertAction();
        ActionListener command = new CommandAction();
        panel = new JPanel();
        panel.setLayout(new GridLayout(4,4));
        addButton("7", insert);
        addButton("8", insert);
        addButton("9", insert);
        addButton("/", insert);
        addButton("4", insert);
        addButton("5", insert);
        addButton("6", insert);
        addButton("*", insert);
        addButton("1", insert);
        addButton("2", insert);
        addButton("3", insert);
        addButton("-", insert);
        addButton("0", insert);
        addButton(".", insert);
        addButton("=", insert);
        addButton("+", insert);
        add(panel, BorderLayout.CENTER);
    }
}
    private void addButton (String label, ActionListener listener){
        JButton button = new JButton(label);
        button.setFont(button.getFont().deriveFont(20f));
        button.addActionListener(listener);
        panel.add(button);
    }
private class InsertAction implements ActionListener{
}
private class CommandAction implements ActionListener {
    public void actionPerformed(ActionEvent event) {
        String command = event.getActionCommand();
        if (start) {
            if (command.equals("-")) {
                start = false;
            } else lastCommand = command;
        } else {
            calculate(new BigDecimal(display.getText()));
            lastCommand = command;
            start = true;
        }
    }
}
public void calculate (BigDecimal x){
}


