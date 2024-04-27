package item;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Quyen;
import model.TaiKhoan;
import util.ConnectServer;
import view.FormQuanTriTaiKhoan;

import javax.swing.JLabel;
import java.awt.Font;
import java.rmi.RemoteException;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.Color;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormTimKiemTaiKhoan extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldTenTaiKhoan;
	private JPanel myView;
	private JComboBox comboBoxQuyenHan;
	private JRadioButton rdbtnKichHoat;
	private JRadioButton rdbtnTat;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			FormTimKiemTaiKhoan dialog = new FormTimKiemTaiKhoan();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 * @throws RemoteException 
	 */
	public FormTimKiemTaiKhoan(JPanel myView1) throws RemoteException {
		myView = myView1;
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
			textFieldTenTaiKhoan = new JTextField();
			textFieldTenTaiKhoan.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
			textFieldTenTaiKhoan.setColumns(10);
			textFieldTenTaiKhoan.setBounds(114, 11, 186, 29);
			contentPanel.add(textFieldTenTaiKhoan);
		}
		{
			JLabel lblTrngThi = new JLabel("Trạng thái");
			lblTrngThi.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
			lblTrngThi.setBounds(10, 47, 94, 29);
			contentPanel.add(lblTrngThi);
		}
		{
			rdbtnKichHoat = new JRadioButton("Kích hoạt");
			rdbtnKichHoat.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
			rdbtnKichHoat.setBackground(Color.WHITE);
			rdbtnKichHoat.setBounds(114, 51, 109, 23);
			
			contentPanel.add(rdbtnKichHoat);
			
			rdbtnTat = new JRadioButton("Tắt");
			rdbtnTat.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
			rdbtnTat.setBackground(Color.WHITE);
			rdbtnTat.setBounds(114, 87, 109, 23);
			
			contentPanel.add(rdbtnTat);
			
			ButtonGroup group = new ButtonGroup();
			group.add(rdbtnKichHoat);
			group.add(rdbtnTat);
			
		}
		{
			JButton btnTimKiem = new JButton("Tìm kiếm");
			btnTimKiem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String tenTaiKhoan = textFieldTenTaiKhoan.getText();
					String tenTrangThai = "";
					String maQuyen = "";
					
                    // kiểm tra xem radio nào được chọn
					if (rdbtnKichHoat.isSelected()) {
						tenTrangThai = "Kích hoạt";
					} else if (rdbtnTat.isSelected()) {
						tenTrangThai = "Tắt";
					}
					
					// lấy id của quyền
					Quyen quyen = (Quyen) comboBoxQuyenHan.getSelectedItem();
					if (quyen != null) {
						maQuyen = quyen.getIdQuyen()+"";
					}
					
					// nếu là form quản trị tài khoản thì gọi hàm tìm kiếm tài khoản
					if (myView instanceof FormQuanTriTaiKhoan) {
						FormQuanTriTaiKhoan formQuanTriTaiKhoan = (FormQuanTriTaiKhoan) myView;
						
						try {
							List<TaiKhoan> dsTaiKhoan = ConnectServer.taiKhoanInf.timKiemTaiKhoan(tenTaiKhoan, maQuyen, tenTrangThai);
							formQuanTriTaiKhoan.hienThiDanhSachTaiKhoanTimKiem(dsTaiKhoan);
						} catch (RemoteException e1) {
							e1.printStackTrace();
						}
						
					}
					
					dispose();
				}
			});
			btnTimKiem.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
			btnTimKiem.setBounds(114, 157, 186, 38);
			contentPanel.add(btnTimKiem);
		}
		
		JLabel lblQuynHn = new JLabel("Quyền hạn");
		lblQuynHn.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblQuynHn.setBounds(10, 117, 94, 29);
		contentPanel.add(lblQuynHn);
		
		comboBoxQuyenHan = new JComboBox();
		comboBoxQuyenHan.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		comboBoxQuyenHan.setBounds(114, 117, 186, 29);
		contentPanel.add(comboBoxQuyenHan);
		
		layDanhSachQuyenHan();
	}
	
	public void layDanhSachQuyenHan() throws RemoteException {
		List<Quyen> listQuyenHan = ConnectServer.quyenInf.layDanhSachQuyen();
		comboBoxQuyenHan.addItem(null);
		for(Quyen quyen : listQuyenHan) {
			comboBoxQuyenHan.addItem(quyen);
		}
	}
}
