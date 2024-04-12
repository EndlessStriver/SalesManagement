package vn.thienphu.quanlybanhang.item;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import vn.thienphu.quanlybanhang.model.HoaDon;
import com.toedter.calendar.JDateChooser;

public class FormTimKiemHoaDon extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private List<HoaDon> danhSachHoaDon;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					FormTimKiemHoaDon frame = new FormTimKiemHoaDon();
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
	public FormTimKiemHoaDon(List<HoaDon> danhSachHoaDon) {
		this.danhSachHoaDon = danhSachHoaDon;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 422, 227);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Tìm kiếm");
		btnNewButton.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		btnNewButton.setBounds(139, 131, 186, 38);
		contentPane.add(btnNewButton);
		
		JLabel lblMaHoan = new JLabel("Mã hóa đơn");
		lblMaHoan.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblMaHoan.setBounds(35, 11, 94, 29);
		contentPane.add(lblMaHoan);
		
		textField = new JTextField();
		textField.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		textField.setColumns(10);
		textField.setBounds(139, 11, 186, 29);
		contentPane.add(textField);
		
		JLabel lblMaNhnVin = new JLabel("Mã nhân viên");
		lblMaNhnVin.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblMaNhnVin.setBounds(35, 51, 94, 29);
		contentPane.add(lblMaNhnVin);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		textField_1.setColumns(10);
		textField_1.setBounds(139, 51, 186, 29);
		contentPane.add(textField_1);
		
		JLabel lblNgayLp = new JLabel("Ngày lập");
		lblNgayLp.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblNgayLp.setBounds(35, 91, 94, 29);
		contentPane.add(lblNgayLp);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("dd/MM/yyyy");
		dateChooser.setBounds(139, 91, 186, 29);
		contentPane.add(dateChooser);
		
		JButton btnTim = new JButton("Tìm");
		btnTim.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		btnTim.setBounds(335, 51, 58, 29);
		contentPane.add(btnTim);
	}
}
