package item;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import model.HoaDon;
import util.ConnectServer;
import view.FormQuanTriHoaDon;
import view.FormTraCuuHoaDon;

import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;

public class FormTimKiemHoaDon extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldMaHoaDon;
	public JTextField textFieldMaNhanVien;
	private JPanel myView;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			FormTimKiemHoaDon dialog = new FormTimKiemHoaDon();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	public FormTimKiemHoaDon(JPanel myView1) {
		myView = myView1;
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

		textFieldMaHoaDon = new JTextField();
		textFieldMaHoaDon.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		textFieldMaHoaDon.setColumns(10);
		textFieldMaHoaDon.setBounds(114, 11, 186, 29);
		contentPanel.add(textFieldMaHoaDon);

		JLabel lblMaNhnVin = new JLabel("Mã nhân viên");
		lblMaNhnVin.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblMaNhnVin.setBounds(10, 51, 94, 29);
		contentPanel.add(lblMaNhnVin);

		textFieldMaNhanVien = new JTextField();
		textFieldMaNhanVien.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		textFieldMaNhanVien.setColumns(10);
		textFieldMaNhanVien.setBounds(114, 51, 186, 29);
		contentPanel.add(textFieldMaNhanVien);

		JDateChooser dateChooserNgayLap = new JDateChooser();
		dateChooserNgayLap.setDateFormatString("dd/MM/yyyy");
		dateChooserNgayLap.setBounds(114, 91, 186, 29);
		contentPanel.add(dateChooserNgayLap);

		JLabel lblNgayLp = new JLabel("Ngày lập");
		lblNgayLp.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblNgayLp.setBounds(10, 91, 94, 29);
		contentPanel.add(lblNgayLp);

		JButton btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (myView instanceof FormTraCuuHoaDon) {
					
					FormTraCuuHoaDon formTraCuuHoaDon = (FormTraCuuHoaDon) FormTimKiemHoaDon.this.myView;
					
					String maHoaDon = textFieldMaHoaDon.getText();
					String maNhanVien = textFieldMaNhanVien.getText();
					Date ngayLap = dateChooserNgayLap.getDate();

					try {
						List<HoaDon> listHoaDon = ConnectServer.hoaDonInf.timKiemHoaDon(maHoaDon, maNhanVien, ngayLap);
						formTraCuuHoaDon.hienThiDanhSachTimKiemHoaDon(listHoaDon);
						dispose();
					} catch (RemoteException e1) {
						e1.printStackTrace();
					}
				}
				
				if(myView instanceof FormQuanTriHoaDon) {

					FormQuanTriHoaDon formQuanTriHoaDon = (FormQuanTriHoaDon) FormTimKiemHoaDon.this.myView;

					String maHoaDon = textFieldMaHoaDon.getText();
					String maNhanVien = textFieldMaNhanVien.getText();
					Date ngayLap = dateChooserNgayLap.getDate();

					try {
						List<HoaDon> listHoaDon = ConnectServer.hoaDonInf.timKiemHoaDon(maHoaDon, maNhanVien, ngayLap);
						formQuanTriHoaDon.hienThiDanhSachTimKiemHoaDon(listHoaDon);
						dispose();
					} catch (RemoteException e1) {
						e1.printStackTrace();
					}
				}

			}
		});
		btnTimKiem.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		btnTimKiem.setBounds(114, 131, 186, 38);
		contentPanel.add(btnTimKiem);

		JButton btnTimNhanVien = new JButton("Tìm");
		btnTimNhanVien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				FormTimKiemNhanVien formTimKiemNhanVien = new FormTimKiemNhanVien(FormTimKiemHoaDon.this);
				formTimKiemNhanVien.setVisible(true);
			}
		});
		btnTimNhanVien.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		btnTimNhanVien.setBounds(310, 51, 58, 29);
		contentPanel.add(btnTimNhanVien);

	}
}
