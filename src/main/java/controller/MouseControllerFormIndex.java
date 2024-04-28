package controller;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.Normalizer.Form;

import view.FormIndex;

public class MouseControllerFormIndex implements MouseListener{
	
	private FormIndex formIndex;

	public MouseControllerFormIndex(FormIndex formIndex) {
		this.formIndex = formIndex;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Object compoment = e.getSource();
		
		if(compoment.equals(formIndex.btnTrangChu)) {
			formIndex.tabbedPane.setSelectedIndex(0);
			
			formIndex.btnTrangChu.setBackground(new Color(255, 165, 0));
			formIndex.btnTraCuuThongTin.setBackground(new Color(255, 255, 255));
			formIndex.btnQuanTri.setBackground(new Color(255, 255, 255));
			formIndex.btnThanhToanHoaDon.setBackground(new Color(255, 255, 255));
			
			formIndex.btnTrangChu.setForeground(new Color(255, 255, 255));
			formIndex.btnTraCuuThongTin.setForeground(new Color(0, 0, 0));
			formIndex.btnQuanTri.setForeground(new Color(0, 0, 0));
			formIndex.btnThanhToanHoaDon.setForeground(new Color(0, 0, 0));
		}else if(compoment.equals(formIndex.btnTraCuuThongTin)) {
			formIndex.tabbedPane.setSelectedIndex(1);
			
			formIndex.btnTrangChu.setBackground(new Color(255, 255, 255));
			formIndex.btnTraCuuThongTin.setBackground(new Color(255, 165, 0));
			formIndex.btnQuanTri.setBackground(new Color(255, 255, 255));
			formIndex.btnThanhToanHoaDon.setBackground(new Color(255, 255, 255));
			
			formIndex.btnTrangChu.setForeground(new Color(0, 0, 0));
			formIndex.btnTraCuuThongTin.setForeground(new Color(255, 255, 255));
			formIndex.btnQuanTri.setForeground(new Color(0, 0, 0));
			formIndex.btnThanhToanHoaDon.setForeground(new Color(0, 0, 0));
		}else if(compoment.equals(formIndex.btnQuanTri)) {
			formIndex.tabbedPane.setSelectedIndex(2);
			
			formIndex.btnTrangChu.setBackground(new Color(255, 255, 255));
			formIndex.btnTraCuuThongTin.setBackground(new Color(255, 255, 255));
			formIndex.btnQuanTri.setBackground(new Color(255, 165, 0));
			formIndex.btnThanhToanHoaDon.setBackground(new Color(255, 255, 255));
			
			formIndex.btnTrangChu.setForeground(new Color(0, 0, 0));
			formIndex.btnTraCuuThongTin.setForeground(new Color(0, 0, 0));
			formIndex.btnQuanTri.setForeground(new Color(255, 255, 255));
			formIndex.btnThanhToanHoaDon.setForeground(new Color(0, 0, 0));
		}else if(compoment.equals(formIndex.btnThanhToanHoaDon)) {
			formIndex.tabbedPane.setSelectedIndex(3);
			
			formIndex.btnTrangChu.setBackground(new Color(255, 255, 255));
			formIndex.btnTraCuuThongTin.setBackground(new Color(255, 255, 255));
			formIndex.btnQuanTri.setBackground(new Color(255, 255, 255));
			formIndex.btnThanhToanHoaDon.setBackground(new Color(255, 165, 0));
			
			formIndex.btnTrangChu.setForeground(new Color(0, 0, 0));
			formIndex.btnTraCuuThongTin.setForeground(new Color(0, 0, 0));
			formIndex.btnQuanTri.setForeground(new Color(0, 0, 0));
			formIndex.btnThanhToanHoaDon.setForeground(new Color(255, 255, 255));
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
