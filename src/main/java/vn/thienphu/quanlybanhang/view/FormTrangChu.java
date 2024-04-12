package vn.thienphu.quanlybanhang.view;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import java.awt.CardLayout;

public class FormTrangChu extends JPanel {

	private static final long serialVersionUID = 1L;
	private ImageIcon imageIcon;
	private JPanel panel;
	private int currentIndex = 0;

	/**
	 * Create the panel.
	 */
	public FormTrangChu() {
		setLayout(null);
		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 1131, 753);
		add(panel);
		panel.setLayout(new CardLayout(0, 0));
		addImageCarousel();
	}
	
	private void addImageCarousel() {
		for (int i = 1; i <= 5; i++) {
            ImageIcon icon = new ImageIcon(FormTrangChu.class.getResource("/vn/thienphu/quanlybanhang/view/images/banner" + i + ".jpg"));
            JLabel label = new JLabel(icon);
            label.setHorizontalAlignment(SwingConstants.CENTER);
            this.panel.add(label, "banner" + i);
        }
		
		Timer timer = new Timer(5000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showNextImage();
            }
        });
        timer.start();
	}
	
	private void showNextImage() {
        currentIndex = (currentIndex + 1) % 5;
        CardLayout layout = (CardLayout) panel.getLayout();
        layout.show(panel, "banner" + (currentIndex + 1));
    }

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g.create();
        double scaleX = (double) getWidth() / imageIcon.getIconWidth();
        double scaleY = (double) getHeight() / imageIcon.getIconHeight();
        double scale = Math.min(scaleX, scaleY);
        int width = (int) (imageIcon.getIconWidth() * scale);
        int height = (int) (imageIcon.getIconHeight() * scale);
        int x = (getWidth() - width) / 2;
        int y = (getHeight() - height) / 2;
        g2d.drawImage(imageIcon.getImage(), x, y, width, height, this);
        g2d.dispose();
	}
}
