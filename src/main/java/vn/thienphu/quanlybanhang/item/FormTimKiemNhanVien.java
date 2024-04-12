package vn.thienphu.quanlybanhang.item;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import vn.thienphu.quanlybanhang.model.NhanVien;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.Color;
import javax.swing.JButton;

public class FormTimKiemNhanVien extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private List<NhanVien> danhSachNhanVien;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					FormTimKiemNhanVien frame = new FormTimKiemNhanVien();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public FormTimKiemNhanVien(List<NhanVien> danhSachNhanVien) {
		this.danhSachNhanVien = danhSachNhanVien;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 422, 299);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mã nhân viên");
		lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblNewLabel.setBounds(53, 11, 94, 29);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		textField.setColumns(10);
		textField.setBounds(157, 11, 186, 29);
		contentPane.add(textField);
		
		JLabel lblHoVaTn = new JLabel("Họ và tên");
		lblHoVaTn.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblHoVaTn.setBounds(53, 51, 94, 29);
		contentPane.add(lblHoVaTn);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		textField_1.setColumns(10);
		textField_1.setBounds(157, 51, 186, 29);
		contentPane.add(textField_1);
		
		JLabel lblSinThoai = new JLabel("Số điện thoại");
		lblSinThoai.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblSinThoai.setBounds(53, 91, 94, 29);
		contentPane.add(lblSinThoai);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		textField_2.setColumns(10);
		textField_2.setBounds(157, 91, 186, 29);
		contentPane.add(textField_2);
		
		JLabel lblGiiTinh = new JLabel("Giới tính");
		lblGiiTinh.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblGiiTinh.setBounds(53, 127, 94, 29);
		contentPane.add(lblGiiTinh);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Nam");
		rdbtnNewRadioButton.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		rdbtnNewRadioButton.setBackground(Color.WHITE);
		rdbtnNewRadioButton.setBounds(157, 131, 109, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnN = new JRadioButton("Nữ");
		rdbtnN.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		rdbtnN.setBackground(Color.WHITE);
		rdbtnN.setBounds(157, 167, 109, 23);
		contentPane.add(rdbtnN);
		
		JButton btnNewButton = new JButton("Tìm kiếm");
		btnNewButton.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		btnNewButton.setBounds(157, 211, 186, 38);
		contentPane.add(btnNewButton);
	}
}
