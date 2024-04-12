package vn.thienphu.quanlybanhang.controller;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.Normalizer.Form;

import vn.thienphu.quanlybanhang.view.FormIndex;

public class MouseControllerFormIndex implements MouseListener{
	
	private FormIndex formIndex;

	public MouseControllerFormIndex(FormIndex formIndex) {
		this.formIndex = formIndex;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Object compoment = e.getSource();
		if(compoment.equals(formIndex.panel_btnTrangChu) || compoment.equals(formIndex.lblMenuTrangChu)) {
			formIndex.tabbedPane.setSelectedIndex(0);
			
			formIndex.panel_btnTrangChu.setBackground(new Color(255, 165, 0));
			formIndex.panel_btn_traCuuThongTin.setBackground(new Color(255, 255, 255));
			formIndex.panel_btnQuanTri.setBackground(new Color(255, 255, 255));
			formIndex.panel_btnThanhToanHoaDon.setBackground(new Color(255, 255, 255));
			
			formIndex.lblMenuTrangChu.setForeground(new Color(255, 255, 255));
			formIndex.lblMenuTraCuuThongTin.setForeground(new Color(0, 0, 0));
			formIndex.lblMenuQuanTri.setForeground(new Color(0, 0, 0));
			formIndex.lblMenuThanhToanHoaDon.setForeground(new Color(0, 0, 0));
		}else if(compoment.equals(formIndex.panel_btn_traCuuThongTin) || compoment.equals(formIndex.lblMenuTraCuuThongTin)) {
			formIndex.tabbedPane.setSelectedIndex(1);
			
			formIndex.panel_btnTrangChu.setBackground(new Color(255, 255, 255));
			formIndex.panel_btn_traCuuThongTin.setBackground(new Color(255, 165, 0));
			formIndex.panel_btnQuanTri.setBackground(new Color(255, 255, 255));
			formIndex.panel_btnThanhToanHoaDon.setBackground(new Color(255, 255, 255));
			
			formIndex.lblMenuTrangChu.setForeground(new Color(0, 0, 0));
			formIndex.lblMenuTraCuuThongTin.setForeground(new Color(255, 255, 255));
			formIndex.lblMenuQuanTri.setForeground(new Color(0, 0, 0));
			formIndex.lblMenuThanhToanHoaDon.setForeground(new Color(0, 0, 0));
		}else if(compoment.equals(formIndex.panel_btnQuanTri) || compoment.equals(formIndex.lblMenuQuanTri)) {
			formIndex.tabbedPane.setSelectedIndex(2);
			
			formIndex.panel_btnTrangChu.setBackground(new Color(255, 255, 255));
			formIndex.panel_btn_traCuuThongTin.setBackground(new Color(255, 255, 255));
			formIndex.panel_btnQuanTri.setBackground(new Color(255, 165, 0));
			formIndex.panel_btnThanhToanHoaDon.setBackground(new Color(255, 255, 255));
			
			formIndex.lblMenuTrangChu.setForeground(new Color(0, 0, 0));
			formIndex.lblMenuTraCuuThongTin.setForeground(new Color(0, 0, 0));
			formIndex.lblMenuQuanTri.setForeground(new Color(255, 255, 255));
			formIndex.lblMenuThanhToanHoaDon.setForeground(new Color(0, 0, 0));
		}else if(compoment.equals(formIndex.panel_btnThanhToanHoaDon) || compoment.equals(formIndex.lblMenuThanhToanHoaDon)) {
			formIndex.tabbedPane.setSelectedIndex(3);
			
			formIndex.panel_btnTrangChu.setBackground(new Color(255, 255, 255));
			formIndex.panel_btn_traCuuThongTin.setBackground(new Color(255, 255, 255));
			formIndex.panel_btnQuanTri.setBackground(new Color(255, 255, 255));
			formIndex.panel_btnThanhToanHoaDon.setBackground(new Color(255, 165, 0));
			
			formIndex.lblMenuTrangChu.setForeground(new Color(0, 0, 0));
			formIndex.lblMenuTraCuuThongTin.setForeground(new Color(0, 0, 0));
			formIndex.lblMenuQuanTri.setForeground(new Color(0, 0, 0));
			formIndex.lblMenuThanhToanHoaDon.setForeground(new Color(255, 255, 255));
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
