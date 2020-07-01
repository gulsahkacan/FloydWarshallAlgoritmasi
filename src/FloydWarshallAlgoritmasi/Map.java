package FloydWarshallAlgoritmasi;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
 
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class Map extends JFrame {
	
	public Map() {
        super("Lines Drawing Demo");
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\earth\\Documents\\eclipse_workspace\\1_150201121_150201124\\TrHarita.png"));
 
        setSize(988, 543);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\earth\\Documents\\eclipse_workspace\\1_150201121_150201124\\TrHarita.png"));
        lblNewLabel.setBounds(0, 0, 982, 506);
        getContentPane().add(lblNewLabel);
    }
 
    void drawLines(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
 
        
        /*
        g2d.drawLine(10, 70, 988, 70);
        g2d.drawLine(10, 130, 988, 130);
        g2d.drawLine(10, 190, 988, 190);
        g2d.drawLine(10, 250, 988, 250);
        g2d.drawLine(10, 310, 988, 310);
        g2d.drawLine(10, 370, 988, 370);
        g2d.drawLine(10, 430, 988, 430);
        
        g2d.drawLine(40,30,40,543);
        g2d.drawLine(100,30,100,543);
        g2d.drawLine(160,30,160,543);
        g2d.drawLine(220,30,220,543);
        g2d.drawLine(280,30,280,543);
        g2d.drawLine(340,30,340,543);
        g2d.drawLine(400,30,400,543);
        g2d.drawLine(460,30,460,543);
        g2d.drawLine(520,30,520,543);
        g2d.drawLine(580,30,580,543);
        g2d.drawLine(640,30,640,543);
        g2d.drawLine(700,30,700,543);
        g2d.drawLine(760,30,760,543);
        g2d.drawLine(820,30,820,543);
        g2d.drawLine(880,30,880,543);
        g2d.drawLine(940,30,940,543);
      	*/
        
        //Izmit - Ankara arasi komsular uzerinden en kisa yol
        g2d.drawLine(230,120, 260,120);
        g2d.drawLine(260,120, 310,130);
        g2d.drawLine(310,130, 370,180);
        
    }

    public void paint(Graphics g) {
        super.paint(g);
        drawLines(g);
    }
 
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Map().setVisible(true);
            }
        });
    }
}