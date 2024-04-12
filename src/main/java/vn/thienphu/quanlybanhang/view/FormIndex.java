package vn.thienphu.quanlybanhang.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import vn.thienphu.quanlybanhang.controller.MouseControllerFormIndex;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.BoxLayout;
import javax.swing.JSeparator;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.UIManager;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;
import java.util.TimeZone;

public class FormIndex extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTabbedPane tabbedPane;
	private MouseControllerFormIndex mouseControllerFormIndex = new MouseControllerFormIndex(this);
	private FormTrangChu trangChu = new FormTrangChu();
	private FormQuanTri quanTri = new FormQuanTri();
	private FormThanhToan thanhToan = new FormThanhToan();
	private FormTraCuuThongTin traCuuThongTin = new FormTraCuuThongTin();
	public JPanel panel_btnTrangChu;
	public JPanel panel_btn_traCuuThongTin;
	public JPanel panel_btnQuanTri;
	public JPanel panel_btnThanhToanHoaDon;
	public JLabel lblMenuTrangChu;
	public JLabel lblMenuTraCuuThongTin;
	public JLabel lblMenuQuanTri;
	public JLabel lblMenuThanhToanHoaDon;
	public JLabel lblCloclk;
	private JSeparator separator;
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					cấu hình giao diện look and feel của window
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					FormIndex frame = new FormIndex();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FormIndex() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1412, 792);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(123, 104, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(new Color(123, 104, 238));
		panel.setBounds(265, 0, 1131, 52);
		contentPane.add(panel);
		
				lblCloclk = new JLabel("00:00:00");
				panel.add(lblCloclk);
				lblCloclk.setFont(new Font("Segoe UI Black", Font.PLAIN, 30));

		JPanel menu = new JPanel();
		menu.setBackground(new Color(123, 104, 238));
		menu.setBounds(0, 0, 267, 753);
		contentPane.add(menu);
		menu.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(
				FormIndex.class.getResource("/vn/thienphu/quanlybanhang/view/images/cart-remove-icon.png")));
		lblNewLabel_1.setBounds(66, 11, 128, 128);
		menu.add(lblNewLabel_1);

		JLabel lblNewLabel = new JLabel("ThanhHoaShop");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 24));
		lblNewLabel.setBounds(36, 150, 198, 52);
		menu.add(lblNewLabel);

		panel_btnTrangChu = new JPanel();
		panel_btnTrangChu.setBackground(new Color(255, 165, 0));
		panel_btnTrangChu.setBounds(0, 234, 267, 52);
		panel_btnTrangChu.addMouseListener(mouseControllerFormIndex);
		menu.add(panel_btnTrangChu);
		panel_btnTrangChu.setLayout(null);

		lblMenuTrangChu = new JLabel("Trang Chủ");
		lblMenuTrangChu.setForeground(new Color(255, 255, 255));
		lblMenuTrangChu.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
		lblMenuTrangChu.setBounds(78, 11, 114, 30);
		panel_btnTrangChu.add(lblMenuTrangChu);

		panel_btn_traCuuThongTin = new JPanel();
		panel_btn_traCuuThongTin.setLayout(null);
		panel_btn_traCuuThongTin.setBounds(0, 297, 267, 52);
		panel_btn_traCuuThongTin.addMouseListener(mouseControllerFormIndex);
		menu.add(panel_btn_traCuuThongTin);

		lblMenuTraCuuThongTin = new JLabel("Tra Cứu Thông Tin");
		lblMenuTraCuuThongTin.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
		lblMenuTraCuuThongTin.setBounds(34, 11, 203, 30);
		panel_btn_traCuuThongTin.add(lblMenuTraCuuThongTin);

		panel_btnQuanTri = new JPanel();
		panel_btnQuanTri.setLayout(null);
		panel_btnQuanTri.setBounds(0, 360, 267, 52);
		panel_btnQuanTri.addMouseListener(mouseControllerFormIndex);
		menu.add(panel_btnQuanTri);

		lblMenuQuanTri = new JLabel("Quản Trị");
		lblMenuQuanTri.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
		lblMenuQuanTri.setBounds(86, 11, 99, 30);
		panel_btnQuanTri.add(lblMenuQuanTri);

		panel_btnThanhToanHoaDon = new JPanel();
		panel_btnThanhToanHoaDon.setLayout(null);
		panel_btnThanhToanHoaDon.setBounds(0, 423, 267, 52);
		panel_btnThanhToanHoaDon.addMouseListener(mouseControllerFormIndex);
		menu.add(panel_btnThanhToanHoaDon);

		lblMenuThanhToanHoaDon = new JLabel("Thanh Toán Hóa Đơn");
		lblMenuThanhToanHoaDon.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
		lblMenuThanhToanHoaDon.setBounds(22, 11, 226, 30);
		panel_btnThanhToanHoaDon.add(lblMenuThanhToanHoaDon);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(
				new ImageIcon(FormIndex.class.getResource("/vn/thienphu/quanlybanhang/view/images/User-icon.png")));
		lblNewLabel_3.setBounds(10, 648, 48, 48);
		menu.add(lblNewLabel_3);

		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("Trần Hoài Thanh");
		lblNewLabel_2_1_1_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_1_1_1_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		lblNewLabel_2_1_1_1_1.setBounds(66, 657, 191, 30);
		menu.add(lblNewLabel_2_1_1_1_1);

		JPanel panel_6 = new JPanel();
		panel_6.setBounds(10, 700, 247, 42);
		menu.add(panel_6);
		panel_6.setLayout(null);

		JLabel lblNewLabel_7 = new JLabel("Đăng Xuất");
		lblNewLabel_7.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		lblNewLabel_7.setBounds(84, 11, 81, 19);
		panel_6.add(lblNewLabel_7);
		
		separator = new JSeparator();
		separator.setBounds(25, 200, 209, 2);
		menu.add(separator);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setEnabled(false);
		tabbedPane.setBackground(new Color(255, 255, 255));
		tabbedPane.setBounds(265, 23, 1134, 730);
		tabbedPane.addTab("Trang Chủ", null, trangChu, null);
		tabbedPane.addTab("Tra Cứu Thông Tin", null, traCuuThongTin, null);
		tabbedPane.addTab("Quản Trị", null, quanTri, null);
		tabbedPane.addTab("Thanh Toán Hóa Đơn", null, thanhToan, null);
		contentPane.add(tabbedPane);
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	TimeZone timeZone = TimeZone.getTimeZone("Asia/Ho_Chi_Minh");
                Calendar calendar = Calendar.getInstance(timeZone);
                long currentTime = System.currentTimeMillis();
                calendar.setTimeInMillis(currentTime);
                String timeString = String.format("%02d:%02d:%02d",
                        calendar.get(Calendar.HOUR_OF_DAY),
                        calendar.get(Calendar.MINUTE),
                        calendar.get(Calendar.SECOND));
                lblCloclk.setText(timeString);
            }
        });
        timer.start();
	}
}
