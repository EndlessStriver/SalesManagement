package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.MouseControllerFormIndex;
import model.NhanVien;
import model.TaiKhoan;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.JTabbedPane;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import javax.swing.Timer;

import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.TimeZone;
import javax.swing.JButton;

public class FormIndex extends JFrame {

	private static final long serialVersionUID = 1L;
	
	public static TaiKhoan taiKhoan;
	public static NhanVien nhanVien;
	
	private JPanel contentPane;
	public JTabbedPane tabbedPane;
	public MouseControllerFormIndex mouseControllerFormIndex;
	private FormTrangChu trangChu;
	private FormQuanTri quanTri;
	private FormThanhToan thanhToan;
	private FormTraCuuThongTin traCuuThongTin;
	public JLabel lblCloclk;
	private JSeparator separator;
	private JPanel panel;

	private JLabel lblTenNhanVien;
	public JButton btnTrangChu;
	public JButton btnTraCuuThongTin;
	public JButton btnThanhToanHoaDon;
	public JButton btnQuanTri;
	private JButton btnngXut;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
////					cấu hình giao diện look and feel của window
//					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//					ConnectServer connectServer = new ConnectServer();
//					FormIndex frame = new FormIndex();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 * 
	 * @throws RemoteException
	 */
	public FormIndex(TaiKhoan taiKhoan1, NhanVien nhanVien1) throws RemoteException {
		taiKhoan = taiKhoan1;
		nhanVien = nhanVien1;
		mouseControllerFormIndex = new MouseControllerFormIndex(this);
		trangChu = new FormTrangChu();
		quanTri = new FormQuanTri();
		thanhToan = new FormThanhToan();
		traCuuThongTin = new FormTraCuuThongTin();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1412, 792);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(123, 104, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel = new JPanel();
		panel.setBackground(new Color(123, 104, 238));
		panel.setBounds(265, 0, 1131, 52);
		contentPane.add(panel);

		lblCloclk = new JLabel("00:00:00");
		panel.add(lblCloclk);
		lblCloclk.setFont(new Font("Segoe UI Black", Font.PLAIN, 30));

		JPanel menu = new JPanel();
		menu.setBackground(new Color(123, 104, 238));
		menu.setBounds(0, 0, 267, 753);
		contentPane.add(menu);
		menu.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(FormIndex.class.getResource("/images/cart-remove-icon.png")));
		lblNewLabel_1.setBounds(66, 11, 128, 128);
		menu.add(lblNewLabel_1);

		JLabel lblNewLabel = new JLabel("ThanhHoaShop");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 24));
		lblNewLabel.setBounds(36, 150, 198, 52);
		menu.add(lblNewLabel);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(FormIndex.class.getResource("/images/User-icon.png")));
		lblNewLabel_3.setBounds(10, 648, 48, 48);
		menu.add(lblNewLabel_3);

		lblTenNhanVien = new JLabel("Trần Hoài Thanh");
		lblTenNhanVien.setForeground(new Color(255, 255, 255));
		lblTenNhanVien.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		lblTenNhanVien.setBounds(66, 657, 191, 30);
		menu.add(lblTenNhanVien);

		separator = new JSeparator();
		separator.setBounds(25, 200, 209, 2);
		menu.add(separator);
		
		btnTrangChu = new JButton("Trang Chủ");
		btnTrangChu.setBackground(new Color(255, 165, 0));
		btnTrangChu.setForeground(Color.WHITE);
		btnTrangChu.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
		btnTrangChu.setBounds(0, 234, 267, 52);
		btnTrangChu.addMouseListener(mouseControllerFormIndex);
		menu.add(btnTrangChu);
		
		btnTraCuuThongTin = new JButton("Tra Cứu Thông Tin");
		btnTraCuuThongTin.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
		btnTraCuuThongTin.setBounds(0, 297, 267, 52);
		btnTraCuuThongTin.addMouseListener(mouseControllerFormIndex);
		menu.add(btnTraCuuThongTin);
		
		btnThanhToanHoaDon = new JButton("Thanh Toán Hóa Đơn");
		btnThanhToanHoaDon.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
		btnThanhToanHoaDon.setBounds(0, 360, 267, 52);
		btnThanhToanHoaDon.addMouseListener(mouseControllerFormIndex);
		menu.add(btnThanhToanHoaDon);
		
		btnQuanTri = new JButton("Quản Trị");
		btnQuanTri.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
		btnQuanTri.setBounds(0, 423, 267, 52);
		btnQuanTri.addMouseListener(mouseControllerFormIndex);
		menu.add(btnQuanTri);
		
		btnngXut = new JButton("Đăng Xuất");
		btnngXut.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        int response = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn đăng xuất?", "Xác nhận",
		                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		        if (response == JOptionPane.YES_OPTION) {
		            System.exit(0);
		        }
		    }
		});
		btnngXut.setFont(new Font("Arial", Font.PLAIN, 20));
		btnngXut.setBounds(20, 707, 227, 40);
		menu.add(btnngXut);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setEnabled(false);
		tabbedPane.setBackground(new Color(255, 255, 255));
		tabbedPane.setBounds(265, 23, 1134, 730);
		tabbedPane.addTab("Trang Chủ", null, trangChu, null);
		tabbedPane.addTab("Tra Cứu Thông Tin", null, traCuuThongTin, null);
		tabbedPane.addTab("Quản Trị", null, quanTri, null);
		tabbedPane.addTab("Thanh Toán Hóa Đơn", null, thanhToan, null);
		contentPane.add(tabbedPane);
		Timer timer = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TimeZone timeZone = TimeZone.getTimeZone("Asia/Ho_Chi_Minh");
				Calendar calendar = Calendar.getInstance(timeZone);
				long currentTime = System.currentTimeMillis();
				calendar.setTimeInMillis(currentTime);
				String timeString = String.format("%02d:%02d:%02d", calendar.get(Calendar.HOUR_OF_DAY),
						calendar.get(Calendar.MINUTE), calendar.get(Calendar.SECOND));
				lblCloclk.setText(timeString);
			}
		});
		timer.start();
		
		kiemTraQuyen();
		ganTenNhanVien();
	}
	
	public void kiemTraQuyen() {
	    // Loại bỏ tất cả các ActionListener hiện tại
	    for (MouseListener act : btnQuanTri.getMouseListeners()) {
	        btnQuanTri.removeMouseListener(act);
	    }

	    if (taiKhoan.getQuyen().getTenQuyen().equals("Nhân Viên")) {
	        // Vô hiệu hóa nút btnQuanTri
	        btnQuanTri.setEnabled(false);
	    } else {
	        // Kích hoạt nút btnQuanTri và thêm lại ActionListener
	        btnQuanTri.setEnabled(true);
	        btnQuanTri.addMouseListener(mouseControllerFormIndex);
	    }
	}
	
	public void ganTenNhanVien() {
		lblTenNhanVien.setText(nhanVien.getTenNhanVien());
	}

}
