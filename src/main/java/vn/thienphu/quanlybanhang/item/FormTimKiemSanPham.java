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
import javax.swing.JComboBox;

public class FormTimKiemSanPham extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FormTimKiemSanPham dialog = new FormTimKiemSanPham();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FormTimKiemSanPham() {
		setModal(true);
		setBounds(100, 100, 325, 219);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Mã sản phẩm");
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
			JLabel lblHoVaTn = new JLabel("Tên sản phẩm");
			lblHoVaTn.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
			lblHoVaTn.setBounds(10, 51, 94, 29);
			contentPanel.add(lblHoVaTn);
		}
		{
			JLabel lblSinThoai = new JLabel("Loại sản phẩm");
			lblSinThoai.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
			lblSinThoai.setBounds(10, 91, 94, 29);
			contentPanel.add(lblSinThoai);
		}
		{
			JComboBox comboBox = new JComboBox();
			comboBox.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
			comboBox.setBounds(114, 91, 186, 29);
			contentPanel.add(comboBox);
		}
		{
			JButton btnNewButton = new JButton("Tìm kiếm");
			btnNewButton.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
			btnNewButton.setBounds(114, 131, 186, 38);
			contentPanel.add(btnNewButton);
		}
	}

}
