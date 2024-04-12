package vn.thienphu.quanlybanhang.item;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import vn.thienphu.quanlybanhang.model.NhanVien;
import vn.thienphu.quanlybanhang.model.SanPham;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class FormTimKiemSanPham extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private List<SanPham> danhSachSanPham;
	private JTextField textField;
	private JTextField textField_1;

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
	public FormTimKiemSanPham(List<SanPham> danhSachSanPham) {
		this.danhSachSanPham = danhSachSanPham;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 422, 227);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mã sản phẩm");
		lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblNewLabel.setBounds(53, 11, 94, 29);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		textField.setColumns(10);
		textField.setBounds(157, 11, 186, 29);
		contentPane.add(textField);
		
		JLabel lblHoVaTn = new JLabel("Tên sản phẩm");
		lblHoVaTn.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblHoVaTn.setBounds(53, 51, 94, 29);
		contentPane.add(lblHoVaTn);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		textField_1.setColumns(10);
		textField_1.setBounds(157, 51, 186, 29);
		contentPane.add(textField_1);
		
		JLabel lblSinThoai = new JLabel("Loại sản phẩm");
		lblSinThoai.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblSinThoai.setBounds(53, 91, 94, 29);
		contentPane.add(lblSinThoai);
		
		JButton btnNewButton = new JButton("Tìm kiếm");
		btnNewButton.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		btnNewButton.setBounds(157, 131, 186, 38);
		contentPane.add(btnNewButton);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		comboBox.setBounds(157, 91, 186, 29);
		contentPane.add(comboBox);
	}
}
