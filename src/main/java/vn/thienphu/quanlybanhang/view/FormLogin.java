package vn.thienphu.quanlybanhang.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class FormLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldTaiKhoan;
	private JPasswordField passwordFieldMatKhau;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormLogin frame = new FormLogin();
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
	public FormLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 816, 531);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelLeft = new JPanel();
		panelLeft.setBackground(new Color(123, 104, 238));
		panelLeft.setBounds(0, 0, 400, 496);
		contentPane.add(panelLeft);
		panelLeft.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(126, 78, 128, 137);
		panelLeft.add(lblNewLabel_2);
		lblNewLabel_2.setIcon(new ImageIcon(FormLogin.class.getResource("/vn/thienphu/quanlybanhang/view/images/cart-remove-icon.png")));
		
		JLabel lblNewLabel_3 = new JLabel("<html><div style='text-align: center;'>Thanh Toán Mua Sắm<br>Mọi Lúc Mọi Nơi</div></html>");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Segoe UI Black", Font.PLAIN, 24));
		lblNewLabel_3.setBounds(63, 235, 254, 111);
		panelLeft.add(lblNewLabel_3);
		
		JPanel panelRight = new JPanel();
		panelRight.setBounds(399, 0, 400, 496);
		contentPane.add(panelRight);
		panelRight.setLayout(null);
		
		JLabel lblDangNhap = new JLabel("ĐĂNG NHẬP");
		lblDangNhap.setFont(new Font("Segoe UI Black", Font.PLAIN, 28));
		lblDangNhap.setBounds(109, 47, 182, 71);
		panelRight.add(lblDangNhap);
		
		JLabel lblTaiKhoan = new JLabel("Tài Khoản");
		lblTaiKhoan.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblTaiKhoan.setBounds(33, 156, 75, 22);
		panelRight.add(lblTaiKhoan);
		
		textFieldTaiKhoan = new JTextField();
		textFieldTaiKhoan.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		textFieldTaiKhoan.setBounds(33, 189, 335, 41);
		panelRight.add(textFieldTaiKhoan);
		textFieldTaiKhoan.setColumns(10);
		
		JLabel lblMatKhau = new JLabel("Mật Khẩu");
		lblMatKhau.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblMatKhau.setBounds(33, 241, 75, 22);
		panelRight.add(lblMatKhau);
		
		passwordFieldMatKhau = new JPasswordField();
		passwordFieldMatKhau.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		passwordFieldMatKhau.setBounds(33, 274, 335, 41);
		panelRight.add(passwordFieldMatKhau);
		
		JButton btnDangNhap = new JButton("Đăng Nhập");
		btnDangNhap.setForeground(new Color(255, 255, 255));
		btnDangNhap.setBackground(new Color(123, 104, 238));
		btnDangNhap.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnDangNhap.setBounds(33, 326, 111, 41);
		panelRight.add(btnDangNhap);
	}
}
