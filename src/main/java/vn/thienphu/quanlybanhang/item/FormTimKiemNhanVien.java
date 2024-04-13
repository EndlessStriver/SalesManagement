package vn.thienphu.quanlybanhang.item;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.Color;

public class FormTimKiemNhanVien extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FormTimKiemNhanVien dialog = new FormTimKiemNhanVien();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FormTimKiemNhanVien() {
		setModal(true);
		setBounds(100, 100, 329, 300);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Mã nhân viên");
			lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
			lblNewLabel.setBounds(10, 11, 94, 29);
			contentPanel.add(lblNewLabel);
		}
		{
			textField = new JTextField();
			textField.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
			textField.setColumns(10);
			textField.setBounds(114, 11, 186, 29);
			contentPanel.add(textField);
		}
		{
			textField_1 = new JTextField();
			textField_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
			textField_1.setColumns(10);
			textField_1.setBounds(114, 51, 186, 29);
			contentPanel.add(textField_1);
		}
		{
			JLabel lblHoVaTn = new JLabel("Họ và tên");
			lblHoVaTn.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
			lblHoVaTn.setBounds(10, 51, 94, 29);
			contentPanel.add(lblHoVaTn);
		}
		{
			JLabel lblSinThoai = new JLabel("Số điện thoại");
			lblSinThoai.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
			lblSinThoai.setBounds(10, 91, 94, 29);
			contentPanel.add(lblSinThoai);
		}
		{
			textField_2 = new JTextField();
			textField_2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
			textField_2.setColumns(10);
			textField_2.setBounds(114, 91, 186, 29);
			contentPanel.add(textField_2);
		}
		{
			JLabel lblGiiTinh = new JLabel("Giới tính");
			lblGiiTinh.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
			lblGiiTinh.setBounds(10, 127, 94, 29);
			contentPanel.add(lblGiiTinh);
		}
		{
			JRadioButton rdbtnNewRadioButton = new JRadioButton("Nam");
			rdbtnNewRadioButton.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
			rdbtnNewRadioButton.setBackground(Color.WHITE);
			rdbtnNewRadioButton.setBounds(114, 131, 109, 23);
			contentPanel.add(rdbtnNewRadioButton);
		}
		{
			JRadioButton rdbtnN = new JRadioButton("Nữ");
			rdbtnN.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
			rdbtnN.setBackground(Color.WHITE);
			rdbtnN.setBounds(114, 167, 109, 23);
			contentPanel.add(rdbtnN);
		}
		{
			JButton btnNewButton = new JButton("Tìm kiếm");
			btnNewButton.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
			btnNewButton.setBounds(114, 211, 186, 38);
			contentPanel.add(btnNewButton);
		}
	}

}
