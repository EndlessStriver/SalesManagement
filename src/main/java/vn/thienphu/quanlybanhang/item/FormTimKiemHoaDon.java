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
import com.toedter.calendar.JDateChooser;

public class FormTimKiemHoaDon extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FormTimKiemHoaDon dialog = new FormTimKiemHoaDon();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FormTimKiemHoaDon() {
		setModal(true);
		setBounds(100, 100, 409, 228);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblMaHoan = new JLabel("Mã hóa đơn");
		lblMaHoan.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblMaHoan.setBounds(10, 11, 94, 29);
		contentPanel.add(lblMaHoan);
		
		textField = new JTextField();
		textField.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		textField.setColumns(10);
		textField.setBounds(114, 11, 186, 29);
		contentPanel.add(textField);
		
		JLabel lblMaNhnVin = new JLabel("Mã nhân viên");
		lblMaNhnVin.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblMaNhnVin.setBounds(10, 51, 94, 29);
		contentPanel.add(lblMaNhnVin);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		textField_1.setColumns(10);
		textField_1.setBounds(114, 51, 186, 29);
		contentPanel.add(textField_1);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("dd/MM/yyyy");
		dateChooser.setBounds(114, 91, 186, 29);
		contentPanel.add(dateChooser);
		
		JLabel lblNgayLp = new JLabel("Ngày lập");
		lblNgayLp.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblNgayLp.setBounds(10, 91, 94, 29);
		contentPanel.add(lblNgayLp);
		
		JButton btnNewButton = new JButton("Tìm kiếm");
		btnNewButton.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		btnNewButton.setBounds(114, 131, 186, 38);
		contentPanel.add(btnNewButton);
		
		JButton btnTim = new JButton("Tìm");
		btnTim.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		btnTim.setBounds(310, 51, 58, 29);
		contentPanel.add(btnTim);
		
	}
}
