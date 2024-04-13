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
import javax.swing.JComboBox;

public class FormTimKiemTaiKhoan extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FormTimKiemTaiKhoan dialog = new FormTimKiemTaiKhoan();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FormTimKiemTaiKhoan() {
		setModal(true);
		setBounds(100, 100, 336, 255);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblTnTiKhon = new JLabel("Tên tài khoản");
			lblTnTiKhon.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
			lblTnTiKhon.setBounds(10, 11, 94, 29);
			contentPanel.add(lblTnTiKhon);
		}
		{
			textField = new JTextField();
			textField.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
			textField.setColumns(10);
			textField.setBounds(114, 11, 186, 29);
			contentPanel.add(textField);
		}
		{
			JLabel lblTrngThi = new JLabel("Trạng thái");
			lblTrngThi.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
			lblTrngThi.setBounds(10, 47, 94, 29);
			contentPanel.add(lblTrngThi);
		}
		{
			JRadioButton rdbtnKchHot = new JRadioButton("Kích hoạt");
			rdbtnKchHot.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
			rdbtnKchHot.setBackground(Color.WHITE);
			rdbtnKchHot.setBounds(114, 51, 109, 23);
			contentPanel.add(rdbtnKchHot);
		}
		{
			JRadioButton rdbtnTt = new JRadioButton("Tắt");
			rdbtnTt.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
			rdbtnTt.setBackground(Color.WHITE);
			rdbtnTt.setBounds(114, 87, 109, 23);
			contentPanel.add(rdbtnTt);
		}
		{
			JButton btnNewButton = new JButton("Tìm kiếm");
			btnNewButton.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
			btnNewButton.setBounds(114, 157, 186, 38);
			contentPanel.add(btnNewButton);
		}
		
		JLabel lblQuynHn = new JLabel("Quyền hạn");
		lblQuynHn.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblQuynHn.setBounds(10, 117, 94, 29);
		contentPanel.add(lblQuynHn);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		comboBox.setBounds(114, 117, 186, 29);
		contentPanel.add(comboBox);
	}
}
